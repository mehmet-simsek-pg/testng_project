import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

public class UrunSiralamasi extends BaseGUITest{

    /**
     * Ana sayfadaki ürünlerin isimleri toplayin
     * 5. ürünün isminin Winter Top olup olmadigini test edin
     * */

    private HomePage homePage;

    @BeforeClass
    public void pages(){
        homePage = new HomePage(driver);
        LOGGER.info("Home page acildi");
    }

    @Test(groups = "{product}")
    public void productName() {

        homePage.verifyProductName();
        LOGGER.info("5. ürün ismi bulundu");
    }
}
