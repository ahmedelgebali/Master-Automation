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
        driver.get(PropReader.getProp("loginURL"));
        login = new Login(driver);
        startTest("Login Test");
    }

    @Test(priority = 1)
    public void testLogin() throws IOException {
        test.info("Performing login");

        String mail = PropReader.getProp("mail");
        String pass = PropReader.getProp("pass");

        login.enterLoginMail(mail);
        login.enterLoginPass(pass);
        login.clickLoginBtn();
        login.checkFromLogin();

        test.pass("Login successful");
    }

    @Test(priority = 2)
    public void logoutAndLogin() throws IOException, InterruptedException {
        test.info("Logging out and performing login again");

        login.clickLogoutBtn();
        Thread.sleep(2000); // Avoid using sleep, replace with proper wait if needed

        String mail = PropReader.getProp("mail");
        String pass = PropReader.getProp("pass");

        login.enterLoginMail(mail);
        login.enterLoginPass(pass);
        login.clickLoginBtn();
        login.checkFromLogin();

        test.pass("Login after logout successful");
    }
}
