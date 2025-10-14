package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//div[@class='login-form']/h2")
    private WebElement accountText;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    private WebElement loginBtn;

    // cssSelector -> input[data-qa='login-password']+p
    @FindBy(xpath = "//input[@data-qa='login-password']/following-sibling::p")
    private WebElement errorMessage;

    public LoginPage(final WebDriver driver) {
        super(driver);
    }

    public void checkPage() {
        verifyDisplayed(accountText, "Login sayfasi acilmadi");
        LOGGER.info("Verify login page opened");
    }

    public void fillLoginMask(final String email, final String password) {
        sendKeysToElement(emailInput, email);
        LOGGER.info("Email entered");
        sendKeysToElement(passwordInput, password);
        LOGGER.info("Password entered");
    }
    public void clickLoginBtn(){
        clickElement(loginBtn);
        LOGGER.info("Login button clicked");
    }
    public void checkErrorMessage() {
        verifyDisplayed(errorMessage, "Hata mesaji görünmüyor");
        LOGGER.info("Verify error message displayed");
    }

}
