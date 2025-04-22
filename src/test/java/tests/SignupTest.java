package tests;

import com.aventstack.extentreports.Status;
import utils.PropReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Signup;
import java.io.IOException;

public class SignupTest extends BaseTest {

    Signup signup;

    @BeforeMethod
    public void initializeSignup() throws IOException {
        signup = new Signup(driver);
        startTest("Signup Test");  // Start the test for each method
    }

    @Test(priority = 1)
    public void signupInitialPage() throws IOException {
        test.log(Status.INFO, "Navigating to the base URL");
        driver.get(PropReader.getProp("baseURL"));

        String name = PropReader.getProp("name");
        String mail = PropReader.getProp("mail");

        signup.openLoginAndSignupPage();
        signup.enterName(name);
        signup.enterMail(mail);
        signup.clickSignupBtn();

        test.pass("Signup initial page loaded successfully");
    }

    @Test(priority = 2, dependsOnMethods = "signupInitialPage")
    public void signupInfoPage() throws IOException {
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

        signup.selectTitle();
        signup.enterPass(pass);
        signup.selectDay(day);
        signup.selectMonth(month);
        signup.selectYear(year);
        signup.newsCheckbox();
        signup.receiveOfferCheckbox();
        signup.nameAndAddresses(firstName, lastName, companyName, addressStreet, address2);
        signup.setCountryDropdown(country);
        signup.stateAndCity(state, city);
        signup.zipCode(zip);
        signup.mobileNumber(mobileNumber);
        signup.createAccountBtn();
        signup.printSignupConfirmationMessage();
        signup.clickContinueBtn();

        test.pass("Signup info page completed successfully");
    }
}
