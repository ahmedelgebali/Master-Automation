package tests;

import Properties.PropReader;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;

import java.io.IOException;

public class LoginTest extends BaseTest {
    private Login login;


    @BeforeClass
    public static void setupTest() throws IOException {
        String url = PropReader.getProp("loginURL");
        setUp(url);
    }

    //    @AfterClass
    public static void tear(){
        tearDown();
    }

    @Test
    public void testLogin() throws IOException{
        login = new Login(driver);
        String mail = PropReader.getProp("mail");
        String pass = PropReader.getProp("pass");
        login.enterLoginMail(mail);
        login.enterLoginPass(pass);
        login.clickLoginBtn();
        login.checkFromLogin();
    }


}
