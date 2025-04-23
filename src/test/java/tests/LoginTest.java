package tests;

import utils.PropReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Login;
import java.io.IOException;

public class LoginTest extends BaseTest {

    Login login;

    @BeforeMethod
    public void initializeLogin() throws IOException {
        login = new Login(driver);
        startTest("Login Test");
    }

    @Test(priority = 1)
    public void testLogin() throws IOException, InterruptedException {
        driver.get(PropReader.getProp("loginURL"));
        test.info("Performing login");

        performLogin();
        test.pass("Login successful");
    }

    @Test(priority = 2)
    public void logoutAndLogin() throws IOException, InterruptedException {
        test.info("Logging out and performing login again");

        login.clickLogoutBtn();
        Thread.sleep(1000);

        performLogin();

        test.pass("Login after logout successful");
    }


    public void performLogin() throws IOException, InterruptedException {
        String mail = PropReader.getProp("mail");
        String pass = PropReader.getProp("pass");

        login.enterLoginMail(mail);
        login.enterLoginPass(pass);
        login.clickLoginBtn();
        login.checkFromLogin();
    }
}
