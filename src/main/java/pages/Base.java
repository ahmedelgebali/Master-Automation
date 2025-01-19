package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base {
    protected WebDriver driver;
    protected Actions actions;
    protected JavascriptExecutor js;
    WebDriverWait wait;

    // Constructors
    //with driver
    public Base(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }

    // with Actions and javascript explicitly
    public Base(Actions actions, JavascriptExecutor js) {
        this.actions = actions;
        this.js = js;
    }



    public void waitForElementToBeClickable(By locator){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void scrollBy(int x, int y){
        js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x,y);

    }

}

