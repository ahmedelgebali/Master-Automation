package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUs extends Base{
    public ContactUs(WebDriver driver){super(driver);}


// <--------------------------> locators <-------------------------->
    private By name = By.xpath("//input[@placeholder='Name']");
    private By mail = By.xpath("//input[@placeholder='Email']");
    private By subject = By.xpath("//input[@placeholder='Subject']");
    private By enterYourMessageBox = By.xpath("//textarea[@id='message']");
    private By attacheFile = By.xpath("//input[@name='upload_file']");
    private By submitBtn = By.xpath("//input[@name='submit']");




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
    public void uploadFile(String filePath){
        driver.findElement(attacheFile).sendKeys(filePath);
        String imageUploadedMessage = driver.findElement(attacheFile).getText();
        System.out.println(imageUploadedMessage);
        if (imageUploadedMessage != null) {
            System.out.println(imageUploadedMessage);
        } else {
            System.out.println("Couldn't upload the file.");
        }

    }
    public void clickSubmit(){
        driver.findElement(submitBtn).click();
    }



}
