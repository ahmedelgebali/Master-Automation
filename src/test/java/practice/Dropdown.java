package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Dropdown {
    public static void main(String[] args) {

        String selectUrl = "https://testautomationpractice.blogspot.com/";
        String bootUrl = "https://www.jquery-az.com/boots/demo.php?ex=63.0_1";


        WebDriver driver = new FirefoxDriver();
        driver.get(selectUrl);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //hidden dropdowns






/*
        //select dropdowns
        WebElement options = driver.findElement(By.xpath("//select[@id='country']"));
        Select select = new Select(options);
        js.executeScript("window.scrollBy(0, 200)");
        select.selectByVisibleText("Canada");



*/


/*
         //bootstrap
        driver.findElement(By.xpath("//span[@class='multiselect-selected-text']")).click();
        List<WebElement> options = driver.findElements(By.xpath("//ul//li"));
        for (WebElement op : options){
            op.click();
            }
*/


        }



    }