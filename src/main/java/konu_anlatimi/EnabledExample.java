package konu_anlatimi;

import org.testng.annotations.Test;

public class EnabledExample {

    @Test
    public void testA() {
        System.out.println("A testi calisti");
    }

    // test skip olmaz, yokmus gibi davranir, bir nevi yoruma almak gibi
    @Test(enabled = false)
    public void testB() {
        System.out.println("B testi calisti");
    }

    @Test(enabled = false)
    public void paypalIleOde(){
        System.out.println("Paypal sistemi calismadigi icin, test devre disi birakildi");
    }
}
