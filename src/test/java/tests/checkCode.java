package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class checkCode extends BaseTest {

    private JavascriptExecutor js;

    @BeforeClass
    public void setup() {
        setUp("https://automationexercise.com/products");
    }
    @Test
    public void test() throws InterruptedException {
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0, 800);");





    }
}
