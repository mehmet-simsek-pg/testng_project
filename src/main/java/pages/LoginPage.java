package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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

    // cssSelector -> input[data-qa='login-password']+p
    @FindBy(xpath = "//input[@data-qa='login-password']/following-sibling::p")
    WebElement errorMessage;

    public LoginPage(final WebDriver driver) {

        PageFactory.initElements(driver,this);
    }

    public void checkPage() {
        Assert.assertTrue(accountText.isDisplayed(), "Login sayfasi acilmadi");
    }

    public void fillLoginMask() {
        emailInput.sendKeys("testuser004@example.com");
        passwordInput.sendKeys("123435");
        loginBtn.click();
    }
    public void clickLoginBtn(){
        loginBtn.click();
    }
    public void checkErrorMessage() {
        Assert.assertTrue(errorMessage.isDisplayed(), "Hata mesaji görünmüyor");
    }

}
