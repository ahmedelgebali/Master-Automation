package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Navigation {
    public static void main(String[] args) throws InterruptedException {

        WebDriver dr = new FirefoxDriver();
       dr.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
       Thread.sleep(5000);
       dr.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();

        Set<String> windIds = dr.getWindowHandles();
        List<String> windowList = new ArrayList<>(windIds);
        String firstWindow = windowList.getFirst();
        String secondWindow = windowList.get(1);


        dr.switchTo().window(firstWindow);
        dr.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
        dr.switchTo().window(firstWindow);
        dr.switchTo().window(secondWindow);

    }
}
