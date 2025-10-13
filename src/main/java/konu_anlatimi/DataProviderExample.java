package konu_anlatimi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {

    /**
     * Object[][] burada kac satir varsa, test o kadar calisir.
     * Bu örnekte tek testimiz 3 defa calisti baska verilerle.
     * Bu yapinin calismasi icin Test annotations a (dataProvider = "loginData") bu sekilde dataProvider tanitilmali
     * */

    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][] {
                {"standard_user","secret_sauce"},
                {"locked_out_user","secret_sauce"},
                {"problem_user","secret_sauce"}
        };
    }

    @Test(dataProvider = "loginData")
    public void login(String username, String password) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.id("login-button"));

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();

        driver.quit();

        System.out.println("Kullanici adi: " + username + " | Sifre: " + password);
    }
}
