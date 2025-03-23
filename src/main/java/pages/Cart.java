package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Cart extends Base {
    private final Products product;
    public Cart(WebDriver driver) {
        super(driver);
        this.product = new Products(driver);
    }
    public Cart(Actions action, JavascriptExecutor js) {
        super(action, js);
        this.product = new Products(driver);
    }



// <--------------------------> locators <-------------------------->
    private final By cartPagePath = By.xpath("//div//ul//li//a[@href='/view_cart']");
    private final By addToCartBtn = By.xpath("//button[normalize-space()='Add to cart']");
    private final By quantityFieldPath = By.xpath("//input[@id='quantity']");
    private final By processedBtn = By.xpath("//a[@class='btn btn-default check_out']");
    private final By placeOrderBtn = By.xpath("//a[@class='btn btn-default check_out']");



// <--------------------------> Action methods <-------------------------->
    // navigate to Cart
    public void moveToCart() {
        waitForElementToBeClickable(cartPagePath);
        driver.findElement(cartPagePath).click();
    }

    // dynamic locators
    private By getDynamicLocator(String baseXPath, String itemNum) {
        return By.xpath(baseXPath.replace("x", String.valueOf(itemNum)));
    }

    public By getItemPriceLocator(String itemNum) {
        return getDynamicLocator("//tr[@id='product-x']//td[@class='cart_price']", itemNum);
    }

    public By getItemTotalPriceLocator(String itemNum) {
        return getDynamicLocator("//tr[@id='product-x']//td[@class='cart_total']", itemNum);
    }

    public By getItemDeleteButtonLocator(String itemNum) {
        return getDynamicLocator("(//td[@class='cart_delete'])[x]", itemNum);
    }

    public By getItemQuantityLocator(String itemNum) {
        return getDynamicLocator("(//td[@class='cart_quantity'])[x]", itemNum);
    }

    // get item path by name
    public String getItemPathByName(String itemName) {
        return "//a[normalize-space()='" + itemName + "']";
    }

    // click product
    public void clickProduct(String itemXpath) {
        By itemLocator = By.xpath(itemXpath);
       wait.until(ExpectedConditions.visibilityOfElementLocated(itemLocator));
        driver.findElement(itemLocator).click();
    }

//    // change quantity
//    public void changeQuantity(String quantity) {
//        waitForElementToBeClickable(quantityFieldPath);
//        driver.findElement(quantityFieldPath).clear();
//        driver.findElement(quantityFieldPath).sendKeys(quantity);
//        product.addItemsToCart(new By[]{addToCartBtn});
//    }


// <--------------------------> helper methods for validation <-------------------------->

        public boolean isItemInCart(String itemName) {
        By itemLocator = By.xpath(getItemPathByName(itemName));
        return isElementDisplayed(itemLocator);
    }

    public boolean isElementDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            // log the exception
            System.out.println("Element not found: " + locator);
            return false;
        }
    }


    public boolean isCartPageDisplayed() {
        return isElementDisplayed(cartPagePath);
    }
}
