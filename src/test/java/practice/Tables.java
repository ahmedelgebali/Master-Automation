package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Tables {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://testautomationpractice.blogspot.com/");
        js.executeScript("window.scrollBy(0,1000)");

        int countRaw = 1;
        for (int c=2; c<=7; c++) {
            for (int i = 1; i<=4; i++){
                String tableText = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+c+"]//td["+i+"]")).getText();
                System.out.println("Raw number:"+countRaw+", Cell number:"+i+ ", Content --> : {" +tableText+"}");
            }
            countRaw++;
        }




        /*
        String[] tableXpath = new String[5];
        // Loop to generate and store XPaths
        for (int i = 1; i <= 5; i++) {
            tableXpath[i - 1] = "//table[@name='BookTable']//tr[" + i + "]";
        }
        int i = 1;
        for (String xpath : tableXpath){
            System.out.println("Raw Number:"+ i +" --> "+ driver.findElement(By.xpath(xpath)).getText());
            i++;
        }

         */

        driver.quit();

    }


}

