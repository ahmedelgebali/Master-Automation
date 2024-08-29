package org.example.tests;

import org.example.BaseTest;
import org.example.pages.Home;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HomeTest extends BaseTest {
    @BeforeEach
    public void setup() throws InterruptedException {
        setUp("https://automationexercise.com/");
    }


    @Test
    public void testHoverOver(){
        Home home = new Home(driver);

        home.hoverOverallItems();
    }

}
