package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    JavascriptExecutor js = (JavascriptExecutor) driver;


    //set up the browser
    public static void setUp(String url) {

        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        driver.get(url);
        driver.manage().window().maximize();
    }

    public static void tearDown() {
        driver.quit();
        driver.close();
    }
    public void waitForVisibility(By locator){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
