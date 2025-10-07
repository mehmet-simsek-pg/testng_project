package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//div[@class='features_items']/h2")
    WebElement homePageText;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']/li[4]/a")
    WebElement loginBtn;

    public HomePage(final WebDriver driver){
       super(driver);
    }

    public void verifyPage() {
        verifyDisplayed(homePageText, "Yanlis sayfa acildi");
    }

    public void clickLoginBtn() {
        clickable(loginBtn);
    }
}
