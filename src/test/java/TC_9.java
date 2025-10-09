import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsPage;

public class TC_9 extends BaseGUITest{

    private HomePage homePage;
    private ProductsPage productsPage;
    private final String productName = "Winter Top";

    @BeforeClass
    public void pages() {
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Test(priority = 1, description = "Verify that home page is visible successfully")
    public void checkHomePage() {
        homePage.verifyPage();
    }

    @Test(priority = 2, description = "Click on 'Products' button")
    public void clickProductsBtn() {
        homePage.clickProductsBtn();
    }

    @Test(priority = 3, description = "Verify user is navigated to ALL PRODUCTS page successfully")
    public void verifyAllProducts() {
        productsPage.checkPage();
    }

    @Test(priority = 4, description = "Enter product name in search input and click search button")
    public void enterProductName() {
        productsPage.enterProductName(productName);
        productsPage.clickSearchBtn();
    }

    @Test(priority = 5, description = "Verify 'SEARCHED PRODUCTS' is visible")
    public void verifySearchedProducts() {
        productsPage.verifySearchProductText();
    }

    @Test(priority = 6, description = "Verify all the products related to search are visible")
    public void visibleAllProducts() {
        productsPage.allProductsAreVisible("Winter Top");
    }
}
