package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Dropdowns {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://testautomationpractice.blogspot.com/");
        WebElement drpEl = driver.findElement(By.xpath("//select[@id='country']"));
        System.out.println(drpEl.getText());
        js.executeScript("window.scrollBy(0,500)");
        Select drpC = new Select(drpEl);
        drpC.selectByVisibleText("Germany");

        List<WebElement> drpOptions = drpC.getOptions();
        System.out.println(drpOptions.size());

    }
}
