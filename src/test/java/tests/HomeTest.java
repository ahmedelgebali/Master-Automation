package tests;

import Properties.PropReader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Home;


import java.io.IOException;

public class HomeTest extends BaseTest {
    private Home home;

    public void setup() throws IOException {
        String url= PropReader.getProp("baseURL");
        setUp(url);
    }
    @AfterClass
    public static void tear(){
        tearDown();
    }


    @Test (priority = 1)
    public void testHeaderSliderInHome(){
        home = new Home(driver);
        home.headerSliderAction();
    }

    @Test (priority = 2)
    public void testHoverOverItemsInHome(){
        home.hoverOverallItems();
    }

    @Test (priority = 3)
    public void testFooterSliderInHome(){
        home.footerSliderAction();
    }


}
