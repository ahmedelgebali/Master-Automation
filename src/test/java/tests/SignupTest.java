package tests;

import com.aventstack.extentreports.Status;
import org.testng.annotations.BeforeClass;
import utils.PropReader;
import org.testng.annotations.Test;
import pages.Signup;
import java.io.IOException;

public class SignupTest extends BaseTest {

    Signup signup;


    @BeforeClass
    public void initializeSignup() {
        signup = new Signup(driver);
    }


    @Test(priority = 1)
    public void signupInitialPage() throws IOException {
        test.log(Status.INFO, "Navigating to Signup Page to create a new user ");

        String url = PropReader.getProp("baseURL");
        String name = PropReader.getProp("name");
        String mail = PropReader.getProp("mail");

        driver.get(url);
        test.pass("Opened the Home page successfully");

        signup.openLoginAndSignupPage();
        test.pass("Opened the login & signup page successfully");

        signup.enterName(name);
        signup.enterMail(mail);
        signup.clickSignupBtn();
        test.pass("Entered the initial Signup info successfully");
    }

    @Test(priority = 2, dependsOnMethods = "signupInitialPage")
    public void signupInfoPage() throws IOException {
        test.log(Status.INFO, "Filing the extension Signup info..");

        String pass = PropReader.getProp("pass");
        String day = PropReader.getProp("day");
        String month = PropReader.getProp("month");
        String year = PropReader.getProp("year");
        String firstName = PropReader.getProp("firstName");
        String lastName = PropReader.getProp("lastName");
        String companyName = PropReader.getProp("companyName");
        String addressStreet = PropReader.getProp("addressStreet");
        String address2 = PropReader.getProp("address2");
        String zip = PropReader.getProp("zip");
        String country = PropReader.getProp("country");
        String state = PropReader.getProp("state");
        String city = PropReader.getProp("city");
        String mobileNumber = PropReader.getProp("mobileNumber");

        signup.selectTitle(); //Mr.
        signup.enterPass(pass);
        signup.selectDay(day);
        signup.selectMonth(month);
        signup.selectYear(year);
        signup.markNewsCheckbox();
        signup.receiveOfferCheckbox();
        signup.nameAndAddresses(firstName, lastName, companyName, addressStreet, address2);
        signup.setCountryDropdown(country);
        signup.stateAndCity(state, city);
        signup.zipCode(zip);
        signup.mobileNumber(mobileNumber);
        signup.createAccountBtn();
        signup.printSignupConfirmationMessage();
        signup.clickContinueBtn();

        test.pass("Extension Signup info entered and created a new user successfully");
    }
}
