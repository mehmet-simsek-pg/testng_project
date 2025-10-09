package konu_anlatimi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserExample {

    WebDriver driver;

    @Parameters("browser")
    @BeforeTest
    public void init(String browserName) {

        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if(browserName.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        } else {
            driver = new SafariDriver();
        }
    }

    @Test
    public void openPage() {
        driver.get("https://automationexercise.com/");
        System.out.println("Sayfanin basligi: " + driver.getTitle());
    }

    @AfterTest
    public void quitDriver() {
        driver.quit();
    }
}
