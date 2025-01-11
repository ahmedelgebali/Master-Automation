package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Cart extends Base {

    private final Products product;

    // constructors
    public Cart(WebDriver driver) {
        super(driver);
        this.product = new Products(driver);
    }
    public Cart(Actions action, JavascriptExecutor js) {
        super(action, js);
        this.product = new Products(driver);
    }

    //  locators
    private final By cartPagePath = By.xpath("//div//ul//li//a[@href='/view_cart']");
    private final By addToCartBtn = By.xpath("//button[normalize-space()='Add to cart']");
    private final By quantityFieldPath = By.xpath("//input[@id='quantity']");
    private final By processedBtn = By.xpath("//a[@class='btn btn-default check_out']");
    private final By placeOrderBtn = By.xpath("//a[@class='btn btn-default check_out']");



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

    // Get Item Path by Name
    public String getItemPathByName(String itemName) {
        return "//a[normalize-space()='" + itemName + "']";
    }

    // Click Product
    public void clickProduct(String itemXpath) {
        By itemLocator = By.xpath(itemXpath);
        waitForElementToBeClickable(itemLocator);
        driver.findElement(itemLocator).click();
    }

    // Change Quantity
    public void changeQuantity(String quantity) {
        waitForElementToBeClickable(quantityFieldPath);
        driver.findElement(quantityFieldPath).clear();
        driver.findElement(quantityFieldPath).sendKeys(quantity);
        product.addItemsToCart(new By[]{addToCartBtn});
    }

    // Helper Methods for Validation (Example Placeholders)
    public boolean isItemInCart(String itemName) {
        By itemLocator = By.xpath(getItemPathByName(itemName));
        return isElementDisplayed(itemLocator);
    }

    public boolean isElementDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            // Log the exception or debug message if needed
            System.out.println("Element not found: " + locator);
            return false;
        }
    }


    public boolean isCartPageDisplayed() {
        return isElementDisplayed(cartPagePath);
    }

    public boolean isProductActionSuccessful(String itemName) {
        return isItemInCart(itemName);
    }
}
