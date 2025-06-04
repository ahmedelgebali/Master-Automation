package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home extends Base {

    public Home(WebDriver driver) {
        super(driver);
    }


// <--------------------------> Actions Methods <-------------------------->

    public void headerSliderAction() {
        for (By sliderControl : HomeLocators.HEADER_SLIDER_ARRAY) {
            safeClick(sliderControl);
            pause(500);
        }
    }

    //handle the popping banner add
    public void collapseBanner() throws NoSuchElementException {
        //collapse banner ad when it appears
        WebElement collapseBtn = driver.findElement(By.xpath("//div[@class='grippy-host']"));
        if (collapseBtn.isDisplayed()) {
            collapseBtn.click();
        }
    }


    public void footerSliderAction() {
        clickWithPause(HomeLocators.FOOTER_SLIDER_LEFT);
        clickWithPause(HomeLocators.FOOTER_SLIDER_RIGHT);
    }

    public void addItemsToCartFromFooter() {
        addItemToCart(HomeLocators.FOOTER_ITEM1_ADD_TO_CART);
        addItemToCart(HomeLocators.FOOTER_ITEM2_ADD_TO_CART);
        addItemToCart(HomeLocators.FOOTER_ITEM3_ADD_TO_CART);

    }


    public void scrollToViewItems() {
        for (int i = 0; i < 15; i++) {
            scrollBy(0, 500);
            pause(200);
        }
    }


    // <--------------------------> Helper methods <-------------------------->

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

    private void clickWithPause(By locator) {
        safeClick(locator);
        pause(200);
    }

    private void addItemToCart(By itemLocator) {
        safeClick(itemLocator);
        waitForVisibility(HomeLocators.POPUP_CONTINUE_BTN);
        safeClick(HomeLocators.POPUP_CONTINUE_BTN);
        pause(250);
    }


}


// the next methods for testing the Hovering Over the items action by the mouse pointer --> TB refactored
   /*
    public void hoverOverallItems() {
        int counter = 0;
        for (By itemLocator: HomeLocators.ITEMS_PATHS_ARRAY) {
            WebElement item = safeFindElement(itemLocator);
            if (item == null) continue;

            if (hoverOverElementWithRetries(item)) {
                waitForAnimationToComplete(item);
            }

            pause(1000);
            counter++;

            if (counter % 4 == 0) {
                scrollPageBy();
                pause(1000);
            }
        }
        safeClick(HomeLocators.SCROLL_UP_BTN);
    }

    // <--------------------------> Helper Methods <-------------------------->

    private boolean hoverOverElementWithRetries(WebElement element) {
        for (int i = 0; i < 3; i++) {
            try {
                scrollIntoView(element);
                actions.moveToElement(element).perform();
                return true;
            } catch (Exception e) {
                if (i == 2) {
                    System.out.println("Hover failed after retries: " + e.getMessage());
                }
            }
        }
        return false;
    }



    private void scrollIntoView(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }


    private void scrollPageBy() {
        scrollBy(0, 100);
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
    */

