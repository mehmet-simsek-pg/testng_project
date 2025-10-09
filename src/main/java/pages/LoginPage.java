package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

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
        super(driver);
    }

    public void checkPage() {
        verifyDisplayed(accountText, "Login sayfasi acilmadi");
    }

    public void fillLoginMask(final String email, final String password) {
        sendKeysToElement(emailInput, email);
        sendKeysToElement(passwordInput, password);
    }
    public void clickLoginBtn(){
        clickElement(loginBtn);
    }
    public void checkErrorMessage() {
        verifyDisplayed(errorMessage, "Hata mesaji görünmüyor");
    }

}
