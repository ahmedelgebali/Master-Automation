package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class checkCode extends BaseTest {

    private JavascriptExecutor js;

    @BeforeEach
    public void setup() throws InterruptedException {
        setUp("https://automationexercise.com/");
    }
    @Test
    public void test() throws InterruptedException {
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0, 800);");

        driver.findElement(By.xpath("//body/section[1]")).click();
    }
}
