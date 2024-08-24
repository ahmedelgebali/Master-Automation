package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Navigation {
    public static void main(String[] args) throws InterruptedException {
        WebDriver dr = new FirefoxDriver();
        dr.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(4000);
        WebElement openPage = dr.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']"));
        openPage.click();
        Thread.sleep(4000);

        Set<String> windIds = dr.getWindowHandles();
        List<String> windowList = new ArrayList<>(windIds);
//        String firstWindow = windowList.getFirst();
//        String secondWindow = windowList.get(1);
        for (String winId : windowList) {
            String title = dr.switchTo().window(winId).getTitle();
            System.out.println(title);
            if (title.equals("Human Resources Management Software | OrangeHRM")|| title.equals("OrangeHRM")) {
                dr.close();
            }
            break;
        }


//
//        dr.switchTo().window(firstWindow);
//        openPage.click();
//        Thread.sleep(6000);
//        dr.switchTo().window(firstWindow);
//        Thread.sleep(6000);
//        dr.switchTo().window(secondWindow);

    }
}
