package tests;

import utils.PropReader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ContactUs;

import java.io.IOException;

public class ContactUsTest extends BaseTest{
    ContactUs contact;

    @BeforeClass
    public static void setup() throws IOException {
        String url = PropReader.getProp("contactUs");
        setUp(url);
    }
    @AfterClass
    public static void tear(){
        tearDown();
    }

    @Test
    public void testContactUs() throws Exception {
        contact = new ContactUs(driver);
        String name = PropReader.getProp("contactName");
        String mail = PropReader.getProp("contactMail");
        String subject = PropReader.getProp("contactSubject");
        String message = PropReader.getProp("contactMessage");
        String imagePath = PropReader.getProp("imagePath");

        contact.setName(name);
        contact.setMail(mail);
        contact.setSubject(subject);
        contact.setYourMessage(message);
        contact.uploadFile(imagePath);
        contact.clickSubmit();
    }

}
