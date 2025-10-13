package konu_anlatimi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertExample {

    @Test
    public void checkoutTest() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();

        SoftAssert softAssert = new SoftAssert();

        // Sayfanin basligini kontrol et
        String title = driver.getTitle();
        softAssert.assertEquals(title, "Automation Exercise", "Sayfa basligi yanlis");

        // ürün ismi dogru mu diye test et
        WebElement productNameText = driver.findElement(By.cssSelector(".productinfo p"));
        String productName = "Blau top";
        softAssert.assertEquals(productNameText.getText(), productName, "Ürün adi yanlis");

        // ürün fiyati dogru mu diye kontrol et
        WebElement productPriceText = driver.findElement(By.cssSelector(".productinfo h2"));
        String productPrice = "Rs. 490";
        softAssert.assertEquals(productPriceText.getText(), productPrice, "Ürün fiyati hatali");

        driver.quit();

        softAssert.assertAll();

    }
}
