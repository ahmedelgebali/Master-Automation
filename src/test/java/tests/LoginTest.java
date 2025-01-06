package tests;

import Properties.PropReader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;

import java.io.IOException;

public class LoginTest extends BaseTest {
    Login login = new Login(driver);


    @BeforeClass
    public static void setupTest() throws IOException, InterruptedException {
        String url = PropReader.getProp("loginURL");
        setUp(url);
    }
    @Test
    public void testLogin() throws IOException{
        String mail = PropReader.getProp("mail");
        String pass = PropReader.getProp("pass");
        login.enterLoginMail(mail);
        login.enterLoginPass(pass);
        login.clickLoginBtn();
        login.checkFromLogin();
    }

    @AfterClass
    public static void tear(){
        tearDown();
    }



}
