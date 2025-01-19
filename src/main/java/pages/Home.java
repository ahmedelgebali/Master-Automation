package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Home extends Base {
    public Home(WebDriver driver) {
        super(driver);
    }
    public Home(Actions actions, JavascriptExecutor js) {
        super(actions, js);
    }


// <--------------------------> items locators <-------------------------->
    private static final String item1 = ("//div[@class='features_items']//div[2]//div[1]//div[1]//div[2]");
    private static final String item2 = ("//div[3]//div[1]//div[1]//div[2]");
    private static final String item3 = ("//div[4]//div[1]//div[1]//div[2]");
    private static final String item4 = ("//div[5]//div[1]//div[1]//div[2]");
    private static final String item5 = ("//div[6]//div[1]//div[1]//div[2]");
    private static final String item6 = ("//div[7]//div[1]//div[1]//div[2]");
    private static final String item7 = ("//div[8]//div[1]//div[1]//div[2]");
    private static final String item8 = ("//div[9]//div[1]//div[1]//div[2]");
    private static final String item9 = ("//div[10]//div[1]//div[1]//div[2]");
    private static final String item10 = ("//div[11]//div[1]//div[1]//div[2]");
    private static final String item11 = ("//div[12]//div[1]//div[1]//div[2]");
    private static final String item12 = ("//div[13]//div[1]//div[1]//div[2]");
    private static final String item13 = ("//div[14]//div[1]//div[1]//div[2]");
    private static final String item14 = ("//div[15]//div[1]//div[1]//div[2]");
    private static final String item15 = ("//div[16]//div[1]//div[1]//div[2]");
    private static final String item16 = ("//div[17]//div[1]//div[1]//div[2]");
    private static final String item17 = ("//div[18]//div[1]//div[1]//div[2]");
    private static final String item18 = ("//div[19]//div[1]//div[1]//div[2]");
    private static final String item19 = ("//div[20]//div[1]//div[1]//div[2]");
    private static final String item20 = ("//div[21]//div[1]//div[1]//div[2]");
    private static final String item21 = ("//div[22]//div[1]//div[1]//div[2]");
    private static final String item22 = ("//div[23]//div[1]//div[1]//div[2]");
    private static final String item24 = ("//div[25]//div[1]//div[1]//div[2]");
    private static final String item25 = ("//div[26]//div[1]//div[1]//div[2]");
    private static final String item26 = ("//div[27]//div[1]//div[1]//div[2]");
    private static final String item27 = ("//div[28]//div[1]//div[1]//div[2]");
    private static final String item28 = ("//div[29]//div[1]//div[1]//div[2]");
    private static final String item29 = ("//div[30]//div[1]//div[1]//div[2]");
    private static final String item30 = ("//div[31]//div[1]//div[1]//div[2]");
    private static final String item31 = ("//div[32]//div[1]//div[1]//div[2]");
    private static final String item32 = ("//div[33]//div[1]//div[1]//div[2]");
    private static final String item33 = ("//div[34]//div[1]//div[1]//div[2]");
    private static final String item34 = ("//div[35]//div[1]//div[1]//div[2]");

    // array to hover over them in the loop
    public static By[] itemsPathsArray = {
            By.xpath(item1), By.xpath(item2), By.xpath(item3), By.xpath(item4),
            By.xpath(item5), By.xpath(item6), By.xpath(item7), By.xpath(item8),
            By.xpath(item9), By.xpath(item10), By.xpath(item11), By.xpath(item12),
            By.xpath(item13), By.xpath(item14), By.xpath(item15), By.xpath(item16),
            By.xpath(item17), By.xpath(item18), By.xpath(item19), By.xpath(item20),
            By.xpath(item21), By.xpath(item22), By.xpath(item24), By.xpath(item25),
            By.xpath(item26), By.xpath(item27), By.xpath(item28), By.xpath(item29),
            By.xpath(item30), By.xpath(item31), By.xpath(item32), By.xpath(item33),
            By.xpath(item34)
    };

    //header slider locators
    private final String leftSliderHeader = "://a[@class='left control-carousel hidden-xs']//i[@class='fa fa-angle-left']";
    private final String rightSliderHeader = "//a[@class='right control-carousel hidden-xs']//i[@class='fa fa-angle-right']";
    private final String sliderThreeDots1 = "//section[@id='slider']//li[1]";
    private final String sliderThreeDots2 = "//section[@id='slider']//li[2]";
    private final String sliderThreeDots3 = "//section[@id='slider']//li[3]";
    private final By[] sliderHeaderArray = {
            By.xpath(leftSliderHeader), By.xpath(rightSliderHeader), By.xpath(sliderThreeDots1),
            By.xpath(sliderThreeDots2), By.xpath(sliderThreeDots3)
    };

    //footer slider locators
    private final By sliderLeftFooter = By.xpath("//a[@class='left recommended-item-control']//i[@class='fa fa-angle-left']");
    private final By sliderRightFooter = By.xpath("//a[@class='right recommended-item-control']//i[@class='fa fa-angle-right']");
    private final By firstItemAddToCartBtnInFooterSlider = By.xpath("/html[1]/body[1]/section[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]");
    private final By secondItemAddToCartBtnInFooterSlider = By.xpath("//div[@class='item active']//div[1]//div[1]//div[1]//div[1]//a[1]");
    private final By thirdItemAddToCartBtnInFooterSlider = By.xpath("//div[@class='item active']//div[3]//div[1]//div[1]//div[1]//a[1]");
    // pop-up continue button xpath
    private final By popupContinueBtn = By.xpath("//button[normalize-space()='Continue Shopping']");




// <--------------------------> Actions methods  <-------------------------->
    public static By[] getItemsPathsArray() {
        return itemsPathsArray;
    }


    //perform action on the header slider
    public void headerSliderAction() {
        for (By slider : sliderHeaderArray) {
            safeClick(slider);
            pause(500);
        }
    }

    //footer slider
    public void footerSliderAction() {
        safeClick(sliderLeftFooter);
        safeClick(sliderLeftFooter);
        safeClick(sliderRightFooter);
        safeClick(firstItemAddToCartBtnInFooterSlider);
        safeClick(secondItemAddToCartBtnInFooterSlider);
        safeClick(thirdItemAddToCartBtnInFooterSlider);
        safeClick(popupContinueBtn);
    }

    // hover over all items in the array
    public void hoverOverallItems() {
        int counter = 0;
        for (By itemLocator : itemsPathsArray) {
            WebElement itemToHover = safeFindElement(itemLocator);
            if (itemToHover == null) continue;  // skip if the element is not found
            // perform hover operation
            if (hoverOverElementWithRetries(itemToHover)) {
                waitForAnimationToComplete(itemToHover); // wait for any potential animation to complete
            }
            pause(1000);
            counter++;

            // scroll down after every 3 items
            if (counter % 4 == 0) {
                scrollPageBy();
                pause(1000);
            }
        }
        // click on the btn to scroll back up
        safeClick(By.xpath("//body/section[1]"));
    }

    //bellow all methods associated with --> (hoverOverallItems)

    // hover over all item on home
    private boolean hoverOverElementWithRetries(WebElement element) {
        int retries = 3;
        for (int i = 0; i < retries; i++) {
            try {
                scrollIntoView(element);
                actions.moveToElement(element).perform();
                return true;
            } catch (Exception e) {
                // Retry if an exception occurs
                if (i == retries - 1) {
                    System.out.println("Failed to hover over element after retries: " + e.getMessage());
                    return false;
                }
            }
        }
        return false;
    }

    // Scrolls the element into view
    private void scrollIntoView(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Scrolls the page by a certain amount
    private void scrollPageBy() {
        js.executeScript("window.scrollBy(arguments[0], arguments[1]);", 0, 100);
    }

    // Waits until the element is clickable
    private void waitForAnimationToComplete(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            System.out.println("Animation did not complete in time: " + e.getMessage());
        }
    }

    // Safe element finder
    private WebElement safeFindElement(By locator) {
        try {
            return driver.findElement(locator);
        } catch (Exception e) {
            System.out.println("Element not found: " + e.getMessage());
            return null;
        }
    }

    // Safe click method
    private void safeClick(By locator) {
        try {
            WebElement element = safeFindElement(locator);
            if (element != null) {
                element.click();
            }
        } catch (Exception e) {
            System.out.println("Failed to click element: " + e.getMessage());
        }
    }

    // Pauses execution for the specified time
    private void pause(int milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Pause interrupted: " + e.getMessage());
        }
    }


}
