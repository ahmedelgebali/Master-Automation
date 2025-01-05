package tests;

import Properties.PropReader;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.interactions.Actions;
import pages.Home;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class HomeTest extends BaseTest {
    private Home  home;



    @BeforeEach
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
