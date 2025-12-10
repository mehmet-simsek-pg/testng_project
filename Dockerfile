# Projemizi derlemek ve testleri çalıştırmak için
# Maven 3.9 + JDK 21 içeren resmi bir base image kullanıyoruz.
# Bu image üzerinde Java ve Maven hazır geliyor.
FROM maven:3.9-eclipse-temurin-21

# İmajı kimin hazırladığını açıklayan metadata bilgisi.
LABEL maintainer="mehmetsimsek (örnek)" \
      project="testng_project" \
      purpose="Selenium + TestNG + Allure testlerinin Docker içinde çalıştırılması"

# Root kullanıcısına geçiyoruz, çünkü aşağıda apt-get ile paket kuracağız.
USER root

# Linux paket listesini güncelliyoruz.
RUN apt-get update && \
    \
    # Chrome kurabilmek için wget, gnupg ve unzip araçlarını yüklüyoruz.
    apt-get install -y wget gnupg unzip && \
    \
    # Google Chrome için resmi GPG anahtarını indiriyoruz.
    wget -qO- https://dl.google.com/linux/linux_signing_key.pub \
      | gpg --dearmor -o /usr/share/keyrings/google-linux-signing-keyring.gpg && \
    \
    # Google Chrome deposunu sources list'e ekliyoruz.
    echo "deb [arch=amd64 signed-by=/usr/share/keyrings/google-linux-signing-keyring.gpg] http://dl.google.com/linux/chrome/deb/ stable main" \
      > /etc/apt/sources.list.d/google-chrome.list && \
    \
    # Yeni eklediğimiz Chrome reposu ile paket listesini tekrar güncelliyoruz.
    apt-get update && \
    \
    # Google Chrome tarayıcısını kuruyoruz.
    # Testlerde ChromeDriver bu tarayıcıyı kullanarak açacak.
    apt-get install -y google-chrome-stable && \
    \
    # İmaj boyutunu küçük tutmak için apt cache temizliği yapıyoruz.
    rm -rf /var/lib/apt/lists/*

# Container içinde projemizin çalışacağı çalışma dizinini ayarlıyoruz.
# Bundan sonra yaptığımız tüm dosya işlemleri bu klasör altında olacak.
WORKDIR /usr/src/app

# İlk olarak sadece pom.xml dosyasını kopyalıyoruz.
# Böylece Maven dependency cache'i Docker layer olarak saklanabiliyor.
# Kodda ufak değişiklik yaptığımızda tüm bağımlılıkları tekrar indirmiyoruz.
COPY pom.xml .

# Maven dependency’lerini (jar dosyalarını) indiriyoruz.
# -B: batch mode (non-interactive), -q: daha sessiz log.
RUN mvn -B -q dependency:resolve dependency:resolve-plugins

# Şimdi projenin geri kalanını (src, resources, logs vs.) kopyalıyoruz.
# Burada Dockerfile ile aynı dizindeki her şeyi image içine almış oluyoruz.
COPY . .

# (Opsiyonel) Maven için bazı default ayarları environment variable olarak verebiliriz.
# Örneğin log seviyesini, encoding'i vb. yönetmek için kullanılabilir.
ENV MAVEN_OPTS="-Dfile.encoding=UTF-8"

# Container içinde çalışacak varsayılan komutu belirliyoruz.
# Bu komut, container ayağa kalktığında testleri çalıştırır:
# 1) mvn clean -> target klasörünü temizler
# 2) mvn test  -> TestNG testlerini çalıştırır, Allure sonuçlarını üretir.
CMD ["mvn", "clean", "test"]
