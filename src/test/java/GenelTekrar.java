import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public WebDriver createBrowser(final WebDriver browser) {
        driver = browser;
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();
        try {
            WebElement element =
                    driver.findElement(By.xpath("//div[@class='fc-footer-buttons']/button[1]"));

            element.click();
            throw new NoSuchElementException("Element sayfada yok");

        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Bilinmiyen bir hata olustu");
        }
        return driver;
    }

    @Parameters({"browser"})
    @BeforeTest(alwaysRun = true)
    public void init(String browser) {
        switch (browser) {
            case "firefox":
                driver = createBrowser(new FirefoxDriver());
                break;
            case "safari":
                driver = createBrowser(new SafariDriver());
                break;
            case "chrome":
                driver = createBrowser(new ChromeDriver());
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
    @Test(groups = {"negative"})
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

        homePage.clickProductsBtn();
        LOGGER.info("Product button clicked");

        productsPage.enterProductName(productName);
        LOGGER.info("Product name entered");

        productsPage.clickSearchBtn();
        LOGGER.info("Search button clicked");
    }

    @AfterTest(alwaysRun = true)
    public void quit() {
        driver.quit();
    }

}
