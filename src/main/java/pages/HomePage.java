package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(xpath = "//div[@class='features_items']/h2")
    WebElement homePageText;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']/li[4]/a")
    WebElement loginBtn;


}
