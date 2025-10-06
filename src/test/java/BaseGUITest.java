import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utility.BaseDriver;

public class BaseGUITest {
    WebDriver driver;

    @BeforeClass
    public void init(){
        driver  = BaseDriver.driver("https://automationexercise.com/");
    }

    @AfterClass
    public void quitTest() {
        driver.quit();
    }
}
