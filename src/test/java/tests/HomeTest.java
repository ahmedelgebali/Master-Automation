package tests;

import Properties.PropReader;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Home;


import java.io.IOException;

public class HomeTest extends BaseTest {
    private Home  home;



    @BeforeClass
    public void setup() throws InterruptedException, IOException {
        String url= PropReader.getProp("baseUrl");
        setUp(url);
    }
//    @AfterAll
//    public static void tear(){
//        tearDown();
//    }


    @Test
    public void testHoverOver(){
         home = new Home(driver);
        home.hoverOverallItems();
    }

}
