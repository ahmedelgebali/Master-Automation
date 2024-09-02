package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class dynamicTables {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, (Duration.ofSeconds(10)));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            driver.get("https://demo.opencart.com/admin/index.php?route=common/login");

//          js.executeScript("window.scrollBy(0,1000)");


            Thread.sleep(1500);
            driver.findElement(By.xpath("//input[@id='input-username']")).sendKeys("demo");
            driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("demo");
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            driver.findElement(By.xpath("//a[@class='parent collapsed'][normalize-space()='Customers']")).click();
            driver.findElement(By.xpath("//ul[@id='collapse-5']//a[contains(text(),'Customers')]")).click();
            int tableSies = 345;
            for (int i = 1; i <= tableSies; i++) {
                int T = 2;
                WebElement pagePath = driver.findElement(By.xpath("//a[normalize-space()='" + T + "']"));
                pagePath.click();
                T++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
