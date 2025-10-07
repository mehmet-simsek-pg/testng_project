package konu_anlatimi;

import org.testng.annotations.Test;

public class DependsOnGroupsExample {

    // login grubundaki tüm testlerin basarili bir sekilde calismasi gerekir,
    // yoksa addProductToCart test i calismaz

    @Test(groups = "login")
    public void loginWithValidUser() {
        System.out.println("Login basarili oldu");
    }

    @Test(groups = "login")
    public void loginWithInValidUser() {
        System.out.println("Yanlis kullanici bilgileriyle login basarisiz oldu");
    }

    @Test(dependsOnGroups = {"login"})
    public void addProductToCart() {
        System.out.println("Ürün sepete eklendi (login islemleri sonrasi)");
    }
}
