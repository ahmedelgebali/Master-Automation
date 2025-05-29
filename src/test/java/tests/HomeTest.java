package tests;

import org.testng.annotations.BeforeClass;
import utils.PropReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Home;
import java.io.IOException;

public class HomeTest extends BaseTest {

    private Home home;

    @BeforeClass
    public void initializeHome() throws IOException {
        home = new Home(driver);
        startTest("Home Page Test");
        driver.get(PropReader.getProp("baseURL"));
    }



    @Test(priority = 1)
    public void testHeaderSlider() {
        test.info("Testing header slider");


        home.headerSliderAction();
        test.pass("Header slider action works");

        home.collapseBanner();
        test.pass("Banner ad collapsed");
    }

    @Test(priority = 2, dependsOnMethods = "testHeaderSlider")
    public void viewAllHomeItems(){
        test.info("Viewing all items in Home page");

        home.scrollToViewItems();
        test.pass("all Home items found ");
    }



    @Test(priority = 3, dependsOnMethods = "viewAllHomeItems")
    public void testFooter() {
        test.info("Testing footer slider");

        home.footerSliderAction();
        test.pass("Footer slider action works");

        home.addItemsToCartFromFooter();
        test.pass("items added to Cart via Footer successfully");

    }

}




    /*
    this test i ignored for now due to an issue in performing the Hovering processes over all Home's items
     @Test(priority = 2, dependsOnMethods = "testHeaderSlider")
    public void testHoverOverAllItems() {
        test.info("Hovering over all items");

        home.hoverOverallItems();
        test.pass("Hover over all items action completed");
    }
     */

