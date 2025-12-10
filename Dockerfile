FROM maven:3.9-eclipse-temurin-21

LABEL maintainer="mehmetsimsek" \
      project="testng_project" \
      purpose="Selenium + TestNG + Allure testleri"

USER root

# 1) Gerekli paketleri kur
RUN apt-get update && \
    apt-get install -y wget gnupg2 ca-certificates unzip && \
    rm -rf /var/lib/apt/lists/*

# 2) Google Chrome GPG key ve repository ekle
RUN mkdir -p /usr/share/keyrings && \
    wget -q -O - https://dl.google.com/linux/linux_signing_key.pub \
      | gpg --dearmor \
      | tee /usr/share/keyrings/google-chrome.gpg > /dev/null && \
    echo "deb [arch=amd64 signed-by=/usr/share/keyrings/google-chrome.gpg] http://dl.google.com/linux/chrome/deb/ stable main" \
      > /etc/apt/sources.list.d/google-chrome.list

# 3) Chrome’u kur
RUN apt-get update && \
    apt-get install -y google-chrome-stable && \
    rm -rf /var/lib/apt/lists/*

# 4) Çalışma dizini
WORKDIR /usr/src/app

# 5) Maven cache için sadece pom.xml kopyala
COPY pom.xml .
RUN mvn -B -q dependency:resolve dependency:resolve-plugins

# 6) Projenin tamamını kopyala
COPY . .

ENV MAVEN_OPTS="-Dfile.encoding=UTF-8"

# 7) Container çalıştığında testleri çalıştır
CMD ["mvn", "clean", "test"]
