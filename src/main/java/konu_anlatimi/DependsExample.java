package konu_anlatimi;

import org.testng.annotations.Test;

public class DependsExample {

    @Test
    public void login() {
        System.out.println("Login testi basarili");
    }

    @Test(dependsOnMethods = {"login"})
    public void sepeteEkle() {
        System.out.println("Sepetee ürün eklendi");
    }

    @Test(dependsOnMethods = {"sepeteEkle"})
    public void odeme() {
        System.out.println("Ödeme yapildi");
    }
}
