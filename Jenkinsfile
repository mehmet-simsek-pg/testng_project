pipeline {

    agent any                            // Pipeline tüm ajanlarda (node'larda) çalışabilir.

    // ─────────────────────────────────────────────────────────────
    // GLOBAL OPTIONS – Build davranışları burada yönetilir
    // ─────────────────────────────────────────────────────────────
    options {
        timestamps()                     // Konsol çıktısına zaman damgası ekler → log takibi kolaylaşır.
        disableConcurrentBuilds()        // Aynı job'ın aynı anda iki kez çalışmasını engeller.
        buildDiscarder(logRotator(       // Eski build’leri silerek disk kullanımını optimize eder.
            numToKeepStr: '20',          // Son 20 build saklansın.
            artifactNumToKeepStr: '10'   // Son 10 build'in artefaktları saklansın.
        ))
    }

    // ─────────────────────────────────────────────────────────────
    // ENVIRONMENT – Pipeline boyunca kullanılacak sabit değerler.
    // ─────────────────────────────────────────────────────────────
    environment {
        ALLURE_RESULTS_PATH = 'target/allure-results' // Allure sonuçlarının bulunduğu klasör.
        RECIPIENTS          = 'ornek.mail@domain.com' // E-posta gönderilecek kişi/kişiler.
    }

    // ─────────────────────────────────────────────────────────────
    // TOOLS – Jenkins'in global tool configuration’da tanımlı JDK/Maven kullanılacak.
    // ─────────────────────────────────────────────────────────────
    tools {
        jdk    'JDK21'                   // Jenkins’e tanımlı JDK21 kullanılacak.
        maven  'Maven-3.9'               // Jenkins’e tanımlı Maven 3.9 kullanılacak.
    }

    stages {

        // ─────────────────────────────────────────────────────────
        stage('Prepare Workspace') {     // Build başlamadan önce workspace temizlenir.
        // ─────────────────────────────────────────────────────────
            steps {
                echo "Workspace temizleniyor..."
                deleteDir()              // Var olan tüm dosya/klasörleri silerek temiz bir ortam sağlar.
            }
        }

        // ─────────────────────────────────────────────────────────
        stage('Checkout') {              // Git reposundan kod çekilir.
        // ─────────────────────────────────────────────────────────
            steps {
                echo "Kaynak kod çekiliyor..."
                git branch: 'main',      // master/main hangi branch'ten çekilecekse burada belirtilir.
                    url: 'https://github.com/mehmet-simsek-pg/testng_project.git'
            }
        }

        // ─────────────────────────────────────────────────────────
        stage('Build & Test') {          // Maven test komutu ile projedeki testler çalıştırılır.
        // ─────────────────────────────────────────────────────────
            steps {
                echo "Maven testleri çalıştırılıyor..."
                sh 'mvn -U -B clean test'
                // -U: Snapshot bağımlılıkları güncellensin.
                // -B: Batch mode (Jenkins için interaktif olmayan mod).
                // clean test → önce temizler sonra testleri çalıştırır.
            }
        }

        // ─────────────────────────────────────────────────────────
        stage('Publish JUnit Results') { // Jenkins test sonuçlarını raporlar.
        // ─────────────────────────────────────────────────────────
            steps {
                junit 'target/surefire-reports/*.xml'
                // TestNG surefire XML çıktısını JUnit formatı gibi publish eder.
            }
        }

        // ─────────────────────────────────────────────────────────
        stage('Generate Allure Report') { // Allure eklentisi ile rapor oluşturulur.
        // ─────────────────────────────────────────────────────────
            steps {
                echo "Allure raporu üretiliyor..."
                allure([
                    commandLine: 'Allure',
                    results: [[path: "${ALLURE_RESULTS_PATH}"]] // Allure sonuç dosyalarının yolu.
                ])
            }
        }

        // ─────────────────────────────────────────────────────────
        stage('Zip Allure Results') {     // Allure sonuçları paketlenir ve artifact olarak saklanır.
        // ─────────────────────────────────────────────────────────
            steps {
                echo "Allure sonuçları zipleniyor ve arşivleniyor..."

                sh 'rm -f allure-results.zip || true'
                // Önceden zip varsa sil. Hata verirse yok say.

                sh "zip -r allure-results.zip ${ALLURE_RESULTS_PATH}"
                // Zip dosyası oluşturulur (-r recursive)

                archiveArtifacts artifacts: 'allure-results.zip', fingerprint: true
                // Sonrasında Jenkins arayüzünde indirilebilir hale gelir.
            }
        }
    }

    // ─────────────────────────────────────────────────────────────
    // POST CONDITIONS – Pipeline başarı / hata durumlarına göre işlem yapılır.
    // ─────────────────────────────────────────────────────────────
    post {

        success {                         // Build başarıyla tamamlanmışsa çalışır.
            emailext(
                subject: "✅ Jenkins Build SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
Merhaba,

Jenkins job: ${env.JOB_NAME}
Build numarası: ${env.BUILD_NUMBER}
Sonuç: ✅ SUCCESS

Allure sonuç dosyası zip olarak Jenkins'te arşivlendi.
Detaylı Allure raporu için:
${env.BUILD_URL}allure

Selamlar,
Jenkins
""",
                to: "${RECIPIENTS}",      // Yukarıda environment’da tanımlandı.
                attachLog: false,         // Log eklenmesin.
                attachmentsPattern: 'allure-results.zip' // Zip dosyasını ek olarak gönder.
            )
        }

        failure {                         // Build başarısız olursa çalışır.
            emailext(
                subject: "❌ Jenkins Build FAILED: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
Merhaba,

Jenkins job: ${env.JOB_NAME}
Build numarası: ${env.BUILD_NUMBER}
Sonuç: ❌ FAILED

Lütfen Jenkins loglarını ve Allure Report'u inceleyin:
${env.BUILD_URL}

Selamlar,
Jenkins
""",
                to: "${RECIPIENTS}",
                attachLog: true,          // Hata durumunda Jenkins console log'u mail'e eklenir.
                attachmentsPattern: 'allure-results.zip'
            )
        }

        always {                          // Başarılı veya başarısız her durumda çalışır.
            echo "Build bitti: Sonuç = ${currentBuild.currentResult}"
        }
    }
}
