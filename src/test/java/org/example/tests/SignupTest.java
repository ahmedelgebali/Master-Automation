package org.example.tests;

import org.example.BaseTest;
import org.example.pages.Signup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SignupTest extends BaseTest {



    @BeforeEach
    public void setUpTest() throws InterruptedException {
        setUp("https://automationexercise.com/");
    }

    @Test
    public void testSignup(){

        // filing the initial fields for the signup processes by entering mail and name
        Signup signup = new Signup(driver);
        String mail = "ramses100@egy.com0";

        signup.openLoginAndSignupPage();
        signup.enterName("Ramses");
        signup.enterMail(mail);
        signup.clickSignupBtn();

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
