package konu_anlatimi;

import org.testng.annotations.Test;

public class UserTest {

    @Test(dataProvider = "userData", dataProviderClass = DataRepo.class)
    public void userInfo(String name, int age) {
        System.out.println("Kullanicinin ismi: " + name + ", Yasi: " + age);
    }
}
