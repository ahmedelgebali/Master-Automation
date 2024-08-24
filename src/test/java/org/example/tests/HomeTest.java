package org.example.tests;

import org.example.BaseTest;
import org.example.pages.Home;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class HomeTest extends BaseTest {

    @BeforeEach
    public void setup(){
        setUp();
    }
    @Test
    public void testHoverOver(){
        Home home = new Home(driver);
        driver.get("https://automationexercise.com/");
        home.hoverOverallItems();
    }

}
