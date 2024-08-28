package org.example.tests;

import org.example.BaseTest;
import org.example.pages.Signup;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SignupTest extends BaseTest {

    String mail = "ramses100@egy.com0";
    Signup signup = new Signup(driver);

    @BeforeAll
    public static void setUpTest() throws InterruptedException {
        setUp("https://automationexercise.com/");
    }


    @Test
    public void SignupInitialPage() {
        // filing the initial fields for the signup processes by entering mail and name
        signup.openLoginAndSignupPage();
        signup.enterName("Ramses");
        signup.enterMail(mail);
        signup.clickSignupBtn();
    }
    @Test
    public void signupInfoPage(){
        //fil the information in the user info page
        signup.selectTitle();
        signup.enterPass("Ramses1520EGC");
        signup.selectDay("10");
        signup.selectMonth("October");
        signup.selectYear("2010");
        signup.newsCheckbox();
        signup.receiveOfferCheckbox();
        signup.nameAndAddresses("Teiba","Idfou","Egypt","Meet Amen","beside the great pyramid");
        signup.setCountryDropdown("Canada");
        signup.stateAndCity("Ottawa","Kanata");
        signup.zipCode("K2K 0A1");
        signup.mobileNumber("201125648651");
        signup.createAccountBtn();
        signup.printSignupConfirmationMessage();
        signup.clickContinueBtn();
    }
}
