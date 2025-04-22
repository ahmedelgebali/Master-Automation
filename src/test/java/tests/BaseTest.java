package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import utils.ExtentManager;

import java.time.Duration;
import java.util.Locale;
public class BaseTest {

    protected static WebDriver driver;
    protected static WebDriverWait wait;

    protected static ExtentReports extent;
    protected static ExtentTest test;

    @BeforeSuite
    public void setupExtent() {
        extent = ExtentManager.getInstance();
    }

    protected void startTest(String testName) {
        test = extent.createTest(testName);
    }

    @AfterSuite
    public void tearDownExtent() {
        extent.flush();
    }



    @BeforeClass(alwaysRun = true)
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        initializingBrowser(browser);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }



    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }





    private void initializingBrowser(String browser) {
        switch (browser.toLowerCase(Locale.ROOT)) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                driver = new ChromeDriver();
        }
    }

    public void waitForVisibility(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}

