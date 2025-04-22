package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends Base{
    public Login(WebDriver driver){super(driver);}


// <--------------------------> Locators  <-------------------------->
    private By mailInput = By.xpath("//input[@data-qa='login-email']");
    private By passInput = By.xpath("//input[@placeholder='Password']");
    private By loginBtn = By.xpath("//button[normalize-space()='Login']");
    private By loggedInAsText = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a");

    private By logout = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");



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
        String text = driver.findElement(loggedInAsText).getText();
        System.out.println(text);
    }

    public void clickLogoutBtn(){
        driver.findElement(logout).click();
    }

}
