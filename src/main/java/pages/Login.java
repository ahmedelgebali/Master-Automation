package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends Base{
    public Login(WebDriver driver){super(driver);}


// <--------------------------> Locators  <-------------------------->
    private final By mailInput = By.xpath("//input[@data-qa='login-email']");
    private final By passInput = By.xpath("//input[@placeholder='Password']");
    private final By loginBtn = By.xpath("//button[normalize-space()='Login']");
    private final By loggedInAsText = By.xpath("//li[10]//a[1]");
    private final By logout = By.xpath("//a[normalize-space()='Logout']");



// <--------------------------> Actions methods  <-------------------------->
    public void enterLoginMail(String mail){
        driver.findElement(mailInput).sendKeys(mail);
    }

    public void enterLoginPass( String password){
        driver.findElement(passInput).sendKeys(password);
    }

    public void clickLoginBtn(){
        driver.findElement(loginBtn).click();
    }

    public void checkFromLogin(){
        waitForElementToBeClickable(loggedInAsText);
        String text = driver.findElement(loggedInAsText).getText();
        System.out.println(text);
    }

    public void clickLogoutBtn(){
        driver.findElement(logout).click();
    }

}
