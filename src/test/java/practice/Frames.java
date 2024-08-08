package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Frames {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://ui.vision/demo/webtest/frames/");

        //frame 1
        WebElement frame1 = driver.findElement(By.cssSelector("frame[src='frame_1.html']"));
        driver.switchTo().frame(frame1);
        driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Hello this text inside frame 1");
        driver.switchTo().defaultContent();

        //frame 2
        WebElement frame2 = driver.findElement(By.cssSelector("frame[src='frame_2.html']"));
        driver.switchTo().frame(frame2);
        driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("hi there, this text inside frame 2");
        driver.switchTo().defaultContent();

        //frame3
        WebElement frame3 = driver.findElement(By.cssSelector("frame[src='frame_3.html']"));
        driver.switchTo().frame(frame3);
        driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("this frame 3 input ");
        WebElement subFrame3 = driver.findElement(By.xpath("//iframe[normalize-space()='Loading...']"));
        driver.switchTo().frame(subFrame3);
        driver.findElement(By.id("i5")).click();
        driver.switchTo().defaultContent();
        driver.switchTo().defaultContent();

//        for (int i =2; i<= 1; i++){}

        //frame4
        WebElement frame4 = driver.findElement(By.cssSelector("frame[src='frame_4.html']"));
        driver.switchTo().frame(frame4);
        driver.findElement(By.xpath("//input[@name='mytext4']")).sendKeys("this frame 4 input ");
        driver.switchTo().defaultContent();

        driver.quit();
    }
}
