package konu_anlatimi;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertKonusu {

    /**
     * Tüm assertler calisir
     * Hatalar assertAll() metodu ile topluca cagrilir
     * assertAll() metodu kullanilmaz ise raporda hatalar yazilmaz
     * */

    @Test
    public void login(){
        SoftAssert softAssert = new SoftAssert();

        System.out.println("Test basladi");

        softAssert.assertEquals(2+2, 5, "Toplama islemi yanlis yapildi");
        System.out.println("Bu satir calisir, cünkü soft assert kullandik");

        softAssert.assertTrue(false, "Yanlis cevap verildi");
        System.out.println("bu satir da calisir");

        softAssert.assertEquals("Java", "Java", "3. kontrol");

        softAssert.assertAll();
    }
}
