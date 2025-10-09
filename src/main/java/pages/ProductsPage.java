package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProductsPage extends BasePage{

    @FindBy(xpath = "//div[@class='features_items']/h2")
    private WebElement allProductsText;

    @FindBy(xpath = "//input[@name='search']")
    private WebElement searchBox;

    @FindBy(xpath = "//button[@id='submit_search']")
    private WebElement searchBtn;

    @FindBy(css = " h2.title")
    private WebElement searchedProductText;

    @FindBy(xpath = "//div[@class='productinfo text-center']/p")
     private WebElement arananUrun;

    public ProductsPage(final WebDriver driver) {
        super(driver);
    }

    public void checkPage() {
        verifyDisplayed(allProductsText, "Products page acilmadi");
    }

    public void enterProductName(String productName) {
        sendKeysToElement(searchBox, productName);
    }

    public void clickSearchBtn() {
        clickElement(searchBtn);
    }

    public void verifySearchProductText() {
        verifyDisplayed(searchedProductText, "Ürün arama yapilamadi");
    }

    public void allProductsAreVisible(final String productName) {

        final String expected = arananUrun.getText();
        final String actual = productName;

        Assert.assertEquals(actual, expected, "Aranan ürün bulunamadi");
    }
}
