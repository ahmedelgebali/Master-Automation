package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    JavascriptExecutor js = (JavascriptExecutor) driver;


    //set up the browser
    public static void setUp(String url) throws InterruptedException {

        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(url);
        driver.manage().window().maximize();
    }

    public static void tearDown(){
        driver.quit();
    }

}
