package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.Locale;

public class BaseTest {

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    JavascriptExecutor js = (JavascriptExecutor) driver;


    //set up the browser
    @BeforeClass (alwaysRun = true)
    @Parameters ("browser")
    public static void setBrowser(@Optional("chrome") String browser){
        initializingBrowser(browser);
    }
//    @BeforeClass (alwaysRun = true)
    public static void setUp(String url) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(url);
        driver.manage().window().maximize();
    }

    public static void  initializingBrowser(String browser){
        switch (browser.toLowerCase(Locale.ROOT)){
            case "chrome" : driver = new ChromeDriver();  break;
            case "edge"   : driver = new EdgeDriver();    break;
            case "firefox": driver = new FirefoxDriver(); break;
            default       : driver = new ChromeDriver();
        }
    }



//    @AfterClass(alwaysRun = true)
    public static void tearDown() {
        driver.quit();
    }

    public void waitForVisibility(By locator){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
