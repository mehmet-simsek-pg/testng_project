import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseGUITest{

    @Test(priority = 1, description = "Verify that home page is visible successfully")
    public void verifyHomePage() {
        WebElement homePageText = driver.findElement(By.xpath("//div[@class='features_items']/h2"));
        Assert.assertTrue(homePageText.isDisplayed(), "Yanlis sayfa acildi");
    }

    @Test(priority = 2, description = "Click on 'Signup / Login' button")
    public void clickLoginBtn() {
        WebElement loginBtn = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[4]/a"));
        loginBtn.click();
    }

    @Test(priority = 3, description = "Verify 'Login to your account' is visible")
    public void checkLoginText() {

        WebElement accountText = driver.findElement(By.xpath("//div[@class='login-form']/h2"));
        Assert.assertTrue(accountText.isDisplayed(), "Login sayfasi acilmadi");
    }

    @Test(priority = 4, description = "Enter correct email address and password")
    public void fillLoginMask() {
        WebElement emailInput = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        WebElement loginBtn = driver.findElement(By.xpath("//button[@data-qa='login-button']"));

        emailInput.sendKeys("testuser004@example.com");
        passwordInput.sendKeys("12345");
        loginBtn.click();
    }
}
