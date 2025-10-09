package konu_anlatimi;

import org.testng.annotations.Test;

public class GroupExampleTest {

    @Test(groups = {"login"})
    public void loginTest(){
        System.out.println("Login testi calisti");
    }

    @Test(groups = {"register"})
    public void registerTest() {
        System.out.println("Register testi calisti");
    }

    @Test(groups = {"login", "register"})
    public void forgotPassword() {
        System.out.println("forgot password testi calisti");
    }
}
