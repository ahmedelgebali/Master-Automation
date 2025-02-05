package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class dataProviderPractice {
    WebDriver driver;

    @BeforeClass
    @Parameters({"browser"})
    void setup(String browser){
        switch (browser){
            case "chrome" : driver = new ChromeDriver();  break;
            case "edge"   : driver = new EdgeDriver();    break;
            case "firefox": driver = new FirefoxDriver(); break;
            default       : driver = new FirefoxDriver(); break;
        }
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "loginData")
    void login(String mail, String pass) {
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(mail);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pass);
        driver.findElement(By.xpath(" //button[@id='submit']")).click();
        List<WebElement> errorMsgElements = driver.findElements(By.xpath("//div[@id='error']"));
        if (!errorMsgElements.isEmpty()) {
            String invalidLoginMSG = errorMsgElements.get(0).getText();
            System.out.println("Login failed with message: " + invalidLoginMSG);
        } else {
            // Proceed to check for successful login
            String validLoginMSG = driver.findElement(By.xpath("//h1[@class='post-title']")).getText();
            System.out.println("Login successful with message: " + validLoginMSG);

        }
    }

    @AfterClass
    void tear(){
        driver.quit();
    }



    @DataProvider(name = "loginData", indices = {})
    String [][] login(){
        String uerData [][] ={
                {"ahmed", "Pass@12"},
                {"ahmed", "Pass@12"},
                {"student", "Pass@12"},
                {"student", "Password123"},
        };
        return uerData;
    }



}

