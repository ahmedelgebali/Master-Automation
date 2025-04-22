package tests;

import utils.PropReader;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Signup;
import java.io.IOException;

public class SignupTest extends BaseTest {
    public SignupTest() throws IOException {}

    Signup signup = new Signup(driver);


    @BeforeClass
    public static void setUpTest() throws IOException, InterruptedException {
        String url = PropReader.getProp("baseURL");
        setUp(url);
    }



    @Test
    public void SignupInitialPage() throws IOException {
        String name = PropReader.getProp("name");
        String mail = PropReader.getProp("mail");
        // filing the initial fields for the signup processes by entering mail and name

        signup.openLoginAndSignupPage();
        signup.enterName(name);
        signup.enterMail(mail);
        signup.clickSignupBtn();
    }

    @Test
    public void signupInfoPage() throws IOException {
        String pass = PropReader.getProp("pass");
        String day = PropReader.getProp("day");
        String month= PropReader.getProp("month");
        String year= PropReader.getProp("year");
        String firstName = PropReader.getProp("firstName");
        String lastName = PropReader.getProp("lastName");
        String companyName = PropReader.getProp("companyName");
        String addressStreet = PropReader.getProp("addressStreet");
        String address2 = PropReader.getProp("address2");
        String zip = PropReader.getProp("zip");
        String country = PropReader.getProp("country");
        String state  = PropReader.getProp("state");
        String city = PropReader.getProp("city");
        String mobileNumber = PropReader.getProp("mobileNumber");

        //fil the information in the user info page
        signup.selectTitle();
        signup.enterPass(pass);
        signup.selectDay(day);
        signup.selectMonth(month);
        signup.selectYear(year);
        signup.newsCheckbox();
        signup. receiveOfferCheckbox();
        signup.nameAndAddresses(firstName,lastName,companyName,addressStreet,address2);
        signup.setCountryDropdown(country);
        signup.stateAndCity(state,city);
        signup.zipCode(zip);
        signup.mobileNumber(mobileNumber);
        signup.createAccountBtn();
        signup.printSignupConfirmationMessage();
        signup.clickContinueBtn();
    }
}
