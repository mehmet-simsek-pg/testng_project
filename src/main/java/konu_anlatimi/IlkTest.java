package konu_anlatimi;

import org.testng.Assert;
import org.testng.annotations.*;

public class IlkTest {

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before class calisti");
    }
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before method calisti");
    }

    @Test(priority = 1, description = "Basit doğrulama")
    public void test1() {
        Assert.assertTrue(3 > 2);
    }

    @Test(priority = 2, timeOut = 2000,
            expectedExceptions = NumberFormatException.class)
    public void test2() {
        Integer.parseInt("abc");
    }
    @AfterMethod
    public void afterMethod() { System.out.println("  > AfterMethod"); }

    @AfterClass
    public void afterClass() { System.out.println(">> AfterClass"); }
}
