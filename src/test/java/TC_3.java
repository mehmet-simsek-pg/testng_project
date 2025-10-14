import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class TC_3 extends BaseGUITest {

    private HomePage homePage;
    private LoginPage loginPage;

    private String email = "testuser004@example.com";
    private String password = "incorrectPassword";

    @BeforeClass
    public void pages() {
         homePage = new HomePage(driver);
         loginPage = new LoginPage(driver);
    }

    @Test(priority = 1, description = "Verify that home page is visible successfully")
    public void verifyHomePage() {
        homePage.verifyPage();
        LOGGER.info("Home page opened");
    }

    @Test(priority = 2, description = "Click on 'Signup / Login' button")
    public void clickLoginSignInBtn() {
        homePage.clickLoginBtn();
        LOGGER.info("Login/Sign in button clicked");
    }

    @Test(priority = 3, description = "Verify 'Login to your account' is visible")
    public void checkLoginText() {
        loginPage.checkPage();
        LOGGER.info("Login page opened");
    }

    @Test(priority = 4, description = "Enter incorrect email address and password")
    public void fillLoginMask() {
        loginPage.fillLoginMask(email, password);
        LOGGER.info("Email and password entered");
    }

    @Test(priority = 5, description = "Click 'login' button")
    public void clickLoginBtn() {
       loginPage.clickLoginBtn();
       LOGGER.info("Login button clicked");
    }

    @Test(priority = 6, description = "Verify error 'Your email or password is incorrect!' is visible",
            dependsOnMethods = {"clickLoginBtn"})
    public void checkErrorMessage() {
        loginPage.checkErrorMessage();
        LOGGER.info("Login basarisiz oldu");
    }
}
