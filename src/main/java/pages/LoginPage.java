package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage {

    @FindBy(xpath = "//div[@class='login-form']/h2")
    WebElement accountText;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    WebElement emailInput;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    WebElement passwordInput;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    WebElement loginBtn;


    public void checkPage() {
        Assert.assertTrue(accountText.isDisplayed(), "Login sayfasi acilmadi");
    }

    public void fillLoginMask() {
        emailInput.sendKeys("testuser004@example.com");
        passwordInput.sendKeys("123435");
        loginBtn.click();
    }

}
