pipeline {

// jenkins icerisinde jdk ve maven i tanimladik. bu sayede localdeki jdk ve maven a bakmayacak.
tools {
    jdk 'JDK21'
    maven 'Maven-3.9'
}

// stages sirayla jenkins in calistiracagi komutlar
stages {
// ilk adimda github tan projeyi cekip, main branche checkout oluyor
    stage('Checkout') {
        git branch: 'main',
        url: 'https://github.com/mehmet-simsek-pg/testng_project.git'
}

// 2. stepte testleri calistiriyor
    stage('Run Test') {
        // Mac
        sh 'mvn clean test'

        // Windows
        //bat 'mvn clean test'
}

        // bu stepte ise reportu olusturuyor
    stage('Generate Allure Report') {
    // allure result un olustugu klasörü tanimladik
       steps {
            allure([
                results: [[path: 'target/allure-results']]
                   ])
        }
}
}
}