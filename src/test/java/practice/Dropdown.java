package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Dropdown {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_1");
        driver.findElement(By.xpath("//span[@class='multiselect-selected-text']")).click();
//        driver.findElement(By.xpath("//input[@value='CSS']")).click();

        List<WebElement> options = driver.findElements(By.xpath("//ul//li"));
        for (WebElement op : options){
            op.click();
            }
        }

    }