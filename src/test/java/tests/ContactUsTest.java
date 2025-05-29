package tests;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import utils.PropReader;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ContactUs;
import java.io.IOException;
import java.util.Objects;

public class ContactUsTest extends BaseTest {
    ContactUs contact;

    @BeforeClass
    public void initializeContact() throws IOException {
        driver.get(PropReader.getProp("contactUs"));
    }


    @Test
    public void contactUsPageLoads() throws IOException {
        test.log(Status.INFO, "Opening Contact Us page");

        if (Objects.equals(driver.getCurrentUrl(), PropReader.getProp("contactUs"))) {
            test.pass("Page loaded successfully");
        } else {
            test.fail("Page failed to load");
        }
    }

    @Test(priority = 1)
    public void testContactUs() throws Exception {
        test.info("Filling out the Contact Us form");

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

        //skip the pop-up
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        test.pass("Form submitted successfully");
    }
}
