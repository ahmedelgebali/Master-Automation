package pages;

import org.openqa.selenium.By;

public class HomeLocators {

    // Header slider controls
    public static final By LEFT_SLIDER_HEADER = By.xpath("//a[@class='left control-carousel hidden-xs']//i[@class='fa fa-angle-left']");
    public static final By RIGHT_SLIDER_HEADER = By.xpath("//a[@class='right control-carousel hidden-xs']//i[@class='fa fa-angle-right']");
    public static final By SLIDER_DOT_1 = By.xpath("//section[@id='slider']//li[1]");
    public static final By SLIDER_DOT_2 = By.xpath("//section[@id='slider']//li[2]");
    public static final By SLIDER_DOT_3 = By.xpath("//section[@id='slider']//li[3]");

    public static final By[] HEADER_SLIDER_ARRAY = {
            LEFT_SLIDER_HEADER, RIGHT_SLIDER_HEADER, SLIDER_DOT_1, SLIDER_DOT_2, SLIDER_DOT_3
    };

    // Footer slider
    public static final By FOOTER_SLIDER_LEFT = By.xpath("//a[@class='left recommended-item-control']//i[@class='fa fa-angle-left']");
    public static final By FOOTER_SLIDER_RIGHT = By.xpath("//a[@class='right recommended-item-control']//i[@class='fa fa-angle-right']");
    public static final By FOOTER_ITEM1_ADD_TO_CART = By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[72]");
    public static final By FOOTER_ITEM2_ADD_TO_CART = By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[73]");
    public static final By FOOTER_ITEM3_ADD_TO_CART = By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[74]");

    // Popup button
    public static final By POPUP_CONTINUE_BTN = By.xpath("//button[normalize-space()='Continue Shopping']");

    // Scroll up button
    public static final By SCROLL_UP_BTN = By.xpath("//body/section[1]");

    // All items on home page
    public static final By[] ITEMS_PATHS_ARRAY = new By[]{
            By.xpath("//div[@class='features_items']//div[2]//div[1]//div[1]//div[2]"),
            By.xpath("//div[3]//div[1]//div[1]//div[2]"),
            By.xpath("//div[4]//div[1]//div[1]//div[2]"),
            By.xpath("//div[5]//div[1]//div[1]//div[2]"),
            By.xpath("//div[6]//div[1]//div[1]//div[2]"),
            By.xpath("//div[7]//div[1]//div[1]//div[2]"),
            By.xpath("//div[8]//div[1]//div[1]//div[2]"),
            By.xpath("//div[9]//div[1]//div[1]//div[2]"),
            By.xpath("//div[10]//div[1]//div[1]//div[2]"),
            By.xpath("//div[11]//div[1]//div[1]//div[2]"),
            By.xpath("//div[12]//div[1]//div[1]//div[2]"),
            By.xpath("//div[13]//div[1]//div[1]//div[2]"),
            By.xpath("//div[14]//div[1]//div[1]//div[2]"),
            By.xpath("//div[15]//div[1]//div[1]//div[2]"),
            By.xpath("//div[16]//div[1]//div[1]//div[2]"),
            By.xpath("//div[17]//div[1]//div[1]//div[2]"),
            By.xpath("//div[18]//div[1]//div[1]//div[2]"),
            By.xpath("//div[19]//div[1]//div[1]//div[2]"),
            By.xpath("//div[20]//div[1]//div[1]//div[2]"),
            By.xpath("//div[21]//div[1]//div[1]//div[2]"),
            By.xpath("//div[22]//div[1]//div[1]//div[2]"),
            By.xpath("//div[23]//div[1]//div[1]//div[2]"),
            By.xpath("//div[25]//div[1]//div[1]//div[2]"),
            By.xpath("//div[26]//div[1]//div[1]//div[2]"),
            By.xpath("//div[27]//div[1]//div[1]//div[2]"),
            By.xpath("//div[28]//div[1]//div[1]//div[2]"),
            By.xpath("//div[29]//div[1]//div[1]//div[2]"),
            By.xpath("//div[30]//div[1]//div[1]//div[2]"),
            By.xpath("//div[31]//div[1]//div[1]//div[2]"),
            By.xpath("//div[32]//div[1]//div[1]//div[2]"),
            By.xpath("//div[33]//div[1]//div[1]//div[2]"),
            By.xpath("//div[34]//div[1]//div[1]//div[2]"),
            By.xpath("//div[35]//div[1]//div[1]//div[2]")
    };
}
