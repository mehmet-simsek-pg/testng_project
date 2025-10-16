package report;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("User Management")
@Feature("Login Functionality")
public class AllureLoginExample {
    /**
     * Project -> Epics -> User Stories -> Tasks
     * */

    private WebDriver driver;

    private void login(final String username, final String password) {
        driver.get("https://www.saucedemo.com/");

        step("Kullanici username i giriliyor");
        driver.findElement(By.id("user-name")).sendKeys(username);

        step("Kullanici sifresini giriyor");
        driver.findElement(By.id("password")).sendKeys(password);

        step("Login butona tiklandi");
        driver.findElement(By.id("login-button")).click();

    }
    @BeforeMethod
    public void init() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Dogru kullanici bilgileri ile login testi")
    @Description("Gecerli kullanici bilgileri ile login olma")
    @Severity(SeverityLevel.CRITICAL)
    public void validLoginTest() {

        login("standard_user", "secret_sauce");
        String title = "Swag Labs";
        Assert.assertEquals(driver.getTitle(), title, "Ana sayfa acilmadi");

    }

    @Test(description = "Yanlis kullanici bilgileri ile login testi")
    @Description("Gecersiz kullanici bilgileri ile login olma")
    @Severity(SeverityLevel.CRITICAL)
    public void inValidLoginTest(){

        login("problem_user", "secret_sauce");

        Assert.assertTrue(driver.getTitle().contains("Swag"), "Login olamadi");
    }

    @Attachment(value = "Adim sayisi", type = "text/plain")
    public String step(String message) {
        return message;
    }

    @AfterMethod
    public void quit() {
        driver.quit();
    }

    /**
     * SeverityLevels:
     * BLOCKER -> Sistemi tamamen durduran hata
     * CRITICAL -> Temel fonksiyonlarin calismasini engelleyen hata
     * NORMAL -> Önemli olmayan hata
     * MINOR -> Kücük hatalar
     * TRIVIAL -> Önemsiz hatalar
     * */
}
