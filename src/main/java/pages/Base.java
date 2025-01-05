package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Base {
    protected WebDriver driver;
    protected Actions actions;
    protected JavascriptExecutor js;


    public Base(){};


    // Constructor with WebDriver
    public Base(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver); // Initialize Actions
        this.js = (JavascriptExecutor) driver; // Cast driver to JavascriptExecutor
    }

    // Constructor with Actions and JavascriptExecutor explicitly
    public Base(Actions actions, JavascriptExecutor js) {
        this.actions = actions;
        this.js = js;
    }

}

