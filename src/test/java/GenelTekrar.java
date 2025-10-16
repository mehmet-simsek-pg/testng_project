import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductsPage;

public class GenelTekrar {

    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    ProductsPage productsPage;
    private static final Logger LOGGER = LogManager.getLogger(GenelTekrar.class);

    @Parameters({"browser"})
    @BeforeTest
    public void init(String browser) {
        switch (browser) {
            case "firefox":
                driver = new FirefoxDriver();
                driver.get("https://automationexercise.com/");
                driver.manage().window().maximize();
                break;
            case "safari":
                driver = new SafariDriver();
                driver.get("https://automationexercise.com/");
                driver.manage().window().maximize();
                break;
            case "chrome":
                driver = new ChromeDriver();
                driver.get("https://automationexercise.com/");
                driver.manage().window().maximize();
                break;
        }
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        LOGGER.debug("Pages created");
    }

    @Parameters({"username", "password"})
    @Test(groups = {"smoke"})
    public void loginWithValidData(String username, String password) {
        homePage.clickLoginBtn();
        LOGGER.info("Sign in/ Login button clicked");

        loginPage.checkPage();
        LOGGER.info("Login page opened");

        loginPage.fillLoginMask(username, password);
        LOGGER.info("Username and password entered");

        loginPage.clickLoginBtn();
        LOGGER.info("Login button clicked");

    }

    @Parameters({"username", "incorrect"})
    @Test(groups = {"smoke"})
    public void loginWithInValidData(String username, String incorrect) {
        homePage.clickLoginBtn();
        LOGGER.info("Sign in/ Login button clicked " + " negative");

        loginPage.checkPage();
        LOGGER.info("Login page opened "+ " negative");

        loginPage.fillLoginMask(username, incorrect);
        LOGGER.info("Username and password entered "+ " negative");

        loginPage.clickLoginBtn();
        LOGGER.info("Login button clicked "+ " negative");
    }

    @Parameters({"productName"})
    @Test(dependsOnGroups = {"smoke"})
    public void searchProduct(String productName) {

        productsPage.enterProductName(productName);
        LOGGER.info("Product name entered");

        productsPage.clickSearchBtn();
        LOGGER.info("Search button clicked");
    }

    @AfterTest
    public void quit() {
        driver.quit();
    }

}
