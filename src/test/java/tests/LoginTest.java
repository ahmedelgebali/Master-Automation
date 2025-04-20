package tests;

import Properties.PropReader;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Login;

import java.io.IOException;

public class LoginTest extends BaseTest {
    Login login;

    @BeforeClass
    public static void setupTest() throws IOException {
        String url = PropReader.getProp("loginURL");
        setUp(url);
    }

    @BeforeMethod
    public void initialize(){
       login = new Login(driver);
    }

//    @AfterClass
    public static void tear(){
        tearDown();
    }

    @Test(priority = 1)
    public void testLogin() throws IOException{

        String mail = PropReader.getProp("mail");
        String pass = PropReader.getProp("pass");
        login.enterLoginMail(mail);
        login.enterLoginPass(pass);
        login.clickLoginBtn();
        login.checkFromLogin();
    }

    @Test(priority = 2)
    public void logoutAndLogin() throws IOException, InterruptedException {
        login = new Login(driver);
        login.clickLogoutBtn();
        Thread.sleep(2000);
        testLogin();
    }


}
