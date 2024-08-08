package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home {
    private final WebDriver driver;

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    //header slider locators
    private By leftSliderHeader = By.xpath("://a[@class='left control-carousel hidden-xs']//i[@class='fa fa-angle-left']");
    private By rightSliderHeaser = By.xpath("//a[@class='right control-carousel hidden-xs']//i[@class='fa fa-angle-right']");
    private By sliderThreeDots1 = By.xpath("//section[@id='slider']//li[1]");
    private By sliderThreeDots2 = By.xpath("//section[@id='slider']//li[2]");
    private By sliderThreeDots3 = By.xpath("//section[@id='slider']//li[3]");

    //items locators
    private By item1 = By.xpath("//div[@class='features_items']//div[2]//div[1]//div[1]//div[2]");
    private By item2 = By.xpath("//div[3]//div[1]//div[1]//div[2]");
    private By item3 = By.xpath("//div[4]//div[1]//div[1]//div[2]");
    private By item4 = By.xpath("//div[5]//div[1]//div[1]//div[2]");
    private By item5 = By.xpath("//div[6]//div[1]//div[1]//div[2]");
    private By item6 = By.xpath("//div[7]//div[1]//div[1]//div[2]");
    private By item7 = By.xpath("//div[8]//div[1]//div[1]//div[2]");
    private By item8 = By.xpath("//div[9]//div[1]//div[1]//div[2]");
    private By item9  = By.xpath("//div[10]//div[1]//div[1]//div[2]");
    private By item10 = By.xpath("//div[11]//div[1]//div[1]//div[2]");
    private By item11 = By.xpath("//div[12]//div[1]//div[1]//div[2]");
    private By item12 = By.xpath("//div[13]//div[1]//div[1]//div[2]");
    private By item13 = By.xpath("//div[14]//div[1]//div[1]//div[2]");
    private By item14 = By.xpath("//div[15]//div[1]//div[1]//div[2]");
    private By item15 = By.xpath("//div[16]//div[1]//div[1]//div[2]");
    private By item16 = By.xpath("//div[17]//div[1]//div[1]//div[2]");
    private By item17 = By.xpath("//div[18]//div[1]//div[1]//div[2]");
    private By item18 = By.xpath("//div[19]//div[1]//div[1]//div[2]");
    private By item19 = By.xpath("//div[20]//div[1]//div[1]//div[2]");
    private By item20 = By.xpath("//div[21]//div[1]//div[1]//div[2]");
    private By item21 = By.xpath("//div[22]//div[1]//div[1]//div[2]");
    private By item22 = By.xpath("//div[23]//div[1]//div[1]//div[2]");
    private By item23 = By.xpath("//div[24]//div[1]//div[1]//div[2]");
    private By item24 = By.xpath("//div[25]//div[1]//div[1]//div[2]");
    private By item25 = By.xpath("//div[26]//div[1]//div[1]//div[2]");
    private By item26 = By.xpath("//div[27]//div[1]//div[1]//div[2]");
    private By item27 = By.xpath("//div[28]//div[1]//div[1]//div[2]");
    private By item28 = By.xpath("//div[29]//div[1]//div[1]//div[2]");
    private By item29 = By.xpath("//div[30]//div[1]//div[1]//div[2]");
    private By item30 = By.xpath("//div[31]//div[1]//div[1]//div[2]");
    private By item31 = By.xpath("//div[32]//div[1]//div[1]//div[2]");
    private By item32 = By.xpath("//div[33]//div[1]//div[1]//div[2]");
    private By item33 = By.xpath("//div[34]//div[1]//div[1]//div[2]");
    private By item34 = By.xpath("//div[35]//div[1]//div[1]//div[2]");

    //footer slider locators
    private By sliderLeftFooter = By.xpath("//a[@class='left recommended-item-control']//i[@class='fa fa-angle-left']");
    private By sliderRightFooter = By.xpath("//a[@class='right recommended-item-control']//i[@class='fa fa-angle-right']");

    private By firstItemAddToCartBtnInFooterSlider = By.xpath("//div[@class='item active']//div[1]//div[1]//div[1]//div[1]//a[1]");
    private By scondItemAddToCartBtnInFooterSlider = By.xpath("//div[@class='item active']//div[2]//div[1]//div[1]//div[1]//a[1]");
    private By thirdItemAddToCartBtnInFooterSlider = By.xpath("//div[@class='item active']//div[3]//div[1]//div[1]//div[1]//a[1]");














}
