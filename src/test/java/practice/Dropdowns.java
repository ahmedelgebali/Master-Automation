package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Dropdowns {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        JavascriptExecutor js = (JavascriptExecutor) driver;


        driver.get("https://www.google.co.uk/");
        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Selenium w");
        List<WebElement> searchResults = driver.findElements(By.xpath("//div[@id='Alh6id']//span"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        for (WebElement result : searchResults){
            System.out.println(result.getText());
        }


        /*
        driver.get("https://testautomationpractice.blogspot.com/");
        WebElement drpEl = driver.findElement(By.xpath("//select[@id='country']"));
        System.out.println(drpEl.getText());
        js.executeScript("window.scrollBy(0,500)");
        Select drpC = new Select(drpEl);
        drpC.selectByVisibleText("Germany");

        List<WebElement> drpOptions = drpC.getOptions();
        System.out.println(drpOptions.size());

         */

    }
}
