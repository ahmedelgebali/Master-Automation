package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ContactUs extends Base{
    public ContactUs(WebDriver driver){super(driver);}


// <--------------------------> locators <-------------------------->
    private final By name = By.xpath("//input[@placeholder='Name']");
    private final By mail = By.xpath("//input[@placeholder='Email']");
    private final By subject = By.xpath("//input[@placeholder='Subject']");
    private final By enterYourMessageBox = By.xpath("//textarea[@id='message']");
    private final By attacheFile = By.xpath("//input[@name='upload_file']");
    private final By submitBtn = By.xpath("//input[@name='submit']");


// <--------------------------> Action methods <-------------------------->
    public void  setName(String enterName){
        driver.findElement(name).sendKeys(enterName);
    }

    public void setMail(String enterMail){
        driver.findElement(mail).sendKeys(enterMail);
    }

    public void setSubject(String enterSubject){
        driver.findElement(subject).sendKeys(enterSubject);
    }

    public void setYourMessage(String yourMessage){
        driver.findElement(enterYourMessageBox).sendKeys(yourMessage);
    }

    public void uploadFile(String filePath) {
        filePath = filePath.trim(); // Trim spaces
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File not found: " + filePath);
            return;
        }
        driver.findElement(attacheFile).sendKeys(filePath);
        System.out.println("File upload attempted: " + filePath);
    }

    public void clickSubmit() throws Exception{
        scrollBy(0,500);
        waitForElementToBeClickable(submitBtn);
        driver.findElement(submitBtn).click();
    }

}
