package org.example.tests;

import base.PropReader;
import org.example.BaseTest;
import org.example.pages.Home;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class HomeTest extends BaseTest {

    @BeforeEach
    public void setup() throws InterruptedException, IOException {
        String url= PropReader.getProp("baseUrl");
        setUp(url);
    }


    @Test
    public void testHoverOver(){
        Home home = new Home(driver);
        home.hoverOverallItems();
    }

}
