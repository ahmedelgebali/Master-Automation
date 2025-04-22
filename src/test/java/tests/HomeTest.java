package tests;

import utils.PropReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Home;
import java.io.IOException;

public class HomeTest extends BaseTest {

    private Home home;

    @BeforeMethod
    public void initializeHome() throws IOException {
        home = new Home(driver);
        startTest("Home Page Test");
    }

    @Test(priority = 1)
    public void testHeaderSlider() throws IOException {
        test.info("Testing header slider");
        driver.get(PropReader.getProp("baseURL"));
        home.headerSliderAction();
        test.pass("Header slider action completed");
    }

    @Test(priority = 2)
    public void testHoverOverAllItems() {
        test.info("Hovering over all items");
        home.hoverOverallItems();
        test.pass("Hover over all items action completed");
    }

    @Test(priority = 3)
    public void testFooterSlider() {
        test.info("Testing footer slider");
        home.footerSliderAction();
        test.pass("Footer slider action completed");
    }
}
