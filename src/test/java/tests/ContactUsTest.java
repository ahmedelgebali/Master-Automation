package tests;

import Properties.PropReader;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.ContactUs;

import java.io.IOException;

public class ContactUsTest extends BaseTest{
    ContactUs contact = new ContactUs(driver);

    @BeforeAll
    public static void setup() throws IOException {
        String url = PropReader.getProp("contactUs");
        setUp(url);
    }

    @Test
    public void testContactUs() throws IOException{
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

//    @AfterAll
//    public static void tear(){
//        tearDown();
//    }
}
