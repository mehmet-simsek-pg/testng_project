package konu_anlatimi;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert {
    /**
     * Ilk hata sonrasi test biter
     * Raporlarda sadece o hatali assert görünür.
     * */

    @Test
    public void login() {
        System.out.println("Test basladi");

        Assert.assertEquals(2+2, 4, "Toplam yanlis");
        System.out.println("Bu satir sorunsuz calisir, cünkü islem dogru");

        Assert.assertTrue(false, "Hatali islem yapildi");
        System.out.println("Bu satir asla calismayacak, cünkü kosul saglanmiyor");

        Assert.assertEquals("Java", "Java", "Ders isimleri yanlis yazilmis");

    }
}
