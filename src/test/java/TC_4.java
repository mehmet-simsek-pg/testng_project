import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class TC_4 extends BaseGUITest {

    private HomePage homePage;
    private LoginPage loginPage;

    private String email = "testuser004@example.com";
    private String password = "12345";

    @BeforeClass
    public void pages() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 1, description = "Verify that home page is visible successfully")
    public void verifyHomePage() {
        homePage.verifyPage();
    }

    @Test(priority = 2, description = "Click on 'Signup / Login' button")
    public void clickLoginSignInBtn() {
        homePage.clickLoginBtn();
    }

    @Test(priority = 3, description = "Verify 'Login to your account' is visible")
    public void checkLoginText() {
        loginPage.checkPage();
    }

    @Test(priority = 4, description = "Enter correct email address and password")
    public void fillLoginMask() {
        loginPage.fillLoginMask(email, password);
    }

    @Test(priority = 5, description = "Click 'login' button")
    public void clickLoginBtn() {
        loginPage.clickLoginBtn();
    }

    @Test(priority = 6, description = "Verify that 'Logged in as username' is visible")
    public void verifyLoggedIn() {
        homePage.verifyLoggedIn();
    }

    @Test(priority = 7, description = "Click 'Logout' button")
    public void clickLogoutBtn() {
        homePage.clickLogoutBtn();
    }

    @Test(priority = 8, description = "Verify that user is navigated to login page")
    public void navigateLoginPage() {
        loginPage.checkPage();
    }
}
