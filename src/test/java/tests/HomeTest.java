package tests;

import utils.PropReader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Home;
import java.io.IOException;

public class HomeTest extends BaseTest {

    private Home home;


    @BeforeMethod
    public void initializeHome() throws IOException {
        home = new Home(driver);
    }


    @Test(priority = 1)
    public void testHeaderSlider() throws IOException {
        driver.get(PropReader.getProp("baseURL"));
        home.headerSliderAction();
    }

    @Test(priority = 2)
    public void testHoverOverAllItems() {
        home.hoverOverallItems();
    }

    @Test(priority = 3)
    public void testFooterSlider() {
        home.footerSliderAction();
    }
}
