package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//div[@class='features_items']/h2")
    private WebElement homePageText;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']/li[4]/a")
    private WebElement loginBtn;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']/li[10]/a")
    private WebElement username;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']/li[4]/a")
    private WebElement logoutBtn;

    public HomePage(final WebDriver driver){
       super(driver);
    }

    public void verifyPage() {
        verifyDisplayed(homePageText, "Yanlis sayfa acildi");
    }

    public void clickLoginBtn() {
        clickElement(loginBtn);
    }

    public void verifyLoggedIn() {
        verifyDisplayed(username, "Kullanici login olamadi");
    }

    public void clickLogoutBtn() {
        clickElement(logoutBtn);
    }
}
