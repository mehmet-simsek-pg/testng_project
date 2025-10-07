package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {

    @FindBy(xpath = "//div[@class='features_items']/h2")
    WebElement homePageText;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']/li[4]/a")
    WebElement loginBtn;

    public HomePage(final WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void verifyPage() {
        Assert.assertTrue(homePageText.isDisplayed(), "Yanlis sayfa acildi");
    }

    public void clickLoginBtn() {
        loginBtn.click();
    }
}
