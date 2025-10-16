package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.Assert;

public class HomePage extends BasePage{

    @FindBy(xpath = "//div[@class='features_items']/h2")
    private WebElement homePageText;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']/li[4]/a")
    private WebElement loginBtn;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']/li[10]/a")
    private WebElement username;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']/li[4]/a")
    private WebElement logoutBtn;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']/li[2]a")
    private WebElement productsBtn;

    @FindBy(xpath = "(//div[@class='single-products'])[5]/div/p")
    private WebElement productName;

    public HomePage(final WebDriver driver){
       super(driver);
    }

    public void verifyPage() {
        verifyDisplayed(homePageText, "Yanlis sayfa acildi");
        LOGGER.info("Verify home page open");
    }

    public void clickLoginBtn() {
        clickElement(loginBtn);
        LOGGER.info("Login button clicked");
    }

    public void verifyLoggedIn() {
        verifyDisplayed(username, "Kullanici login olamadi");
        LOGGER.info("Verify user logged in");
    }

    public void clickLogoutBtn() {
        clickElement(logoutBtn);
        LOGGER.info("Logout button clicked");
    }

    public void clickProductsBtn() {
        clickElement(productsBtn);
        LOGGER.info("Products page opened");
    }

    public void verifyProductName() {
        Assert.assertTrue(productName.isDisplayed(),"Product name görünmedi");
    }
}
