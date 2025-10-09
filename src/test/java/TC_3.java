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
    }

    @Test(priority = 2, description = "Click on 'Signup / Login' button")
    public void clickLoginSignInBtn() {
        homePage.clickLoginBtn();
    }

    @Test(priority = 3, description = "Verify 'Login to your account' is visible")
    public void checkLoginText() {
        loginPage.checkPage();
    }

    @Test(priority = 4, description = "Enter incorrect email address and password")
    public void fillLoginMask() {
        loginPage.fillLoginMask(email, password);
    }

    @Test(priority = 5, description = "Click 'login' button")
    public void clickLoginBtn() {
       loginPage.clickLoginBtn();
    }

    @Test(priority = 6, description = "Verify error 'Your email or password is incorrect!' is visible",
            dependsOnMethods = {"clickLoginBtn"})
    public void checkErrorMessage() {
        loginPage.checkErrorMessage();
    }
}
