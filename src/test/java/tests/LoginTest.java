package tests;

import utils.PropReader;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Login;

import java.io.IOException;

public class LoginTest extends BaseTest {
        Login login;
    @BeforeMethod
    public void initialize() throws IOException {
            login = new Login(driver);
    }

    public void performLogin() throws IOException {
        String mail = PropReader.getProp("mail");
        String pass = PropReader.getProp("pass");
        login.enterLoginMail(mail);
        login.enterLoginPass(pass);
        login.clickLoginBtn();
        login.checkFromLogin();
    }

    @Test(priority = 1)
    public void testLogin() throws IOException {
        driver.get(PropReader.getProp("loginURL"));
        performLogin();
    }

    @Test(priority = 2)
    public void logoutAndLogin() throws IOException, InterruptedException {
        login.clickLogoutBtn();
        Thread.sleep(2000);
        performLogin();
    }
}

