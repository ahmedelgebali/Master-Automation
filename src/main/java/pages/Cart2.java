package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Cart2 extends Base {
    private final Products product;
    public Cart2(WebDriver driver) {
        super(driver);
        this.product = new Products(driver);
    }
    public Cart2(Actions action, JavascriptExecutor js) {
        super(action, js);
        this.product = new Products(driver);
    }

// <--------------------------> Locators <-------------------------->
    private final By cartPagePath = By.xpath("//div//ul//li//a[@href='/view_cart']");
    private final By quantityFieldPath = By.xpath("//input[@id='quantity']");
    private final By addToCartBtn = By.xpath("//button[normalize-space()='Add to cart']");
    private final By processedBtn = By.xpath("//a[@class='btn btn-default check_out']");
    private final By placeOrderBtn = By.xpath("//a[@class='btn btn-default check_out']");





// <--------------------------> Action methods <-------------------------->

    // navigate to Cart
    public void moveToCart() {
        waitForElementToBeClickable(cartPagePath);
        driver.findElement(cartPagePath).click();
    }

    public By getItemPathBasedOnItsOrderInCart(String itemOrder){

    // cssSelector   a[href='/product_details/X']
    // index xpath   (//a[normalize-space()='Blue Top'])[X]
        //tr[@id='product-X']//img[@alt='Product Image']

        String itemsLocator = "(//a[normalize-space()='Blue Top'])[X]";
        return By.xpath(itemsLocator.replace("X", String.valueOf(itemOrder)));
    }

    public void clickOnItemToViewAndBack(By itemLocator){
        waitForElementToBeClickable(itemLocator);
        driver.findElement(itemLocator).click();
        driver.navigate().back();
    }
    public void clickOnItemToView(By itemLocator) {
        waitForElementToBeClickable(itemLocator);
        driver.findElement(itemLocator).click();
    }

    // change quantity
    public void changeQuantity(String itemOrder, String quantity) {
        By itemLocator = getItemPathBasedOnItsOrderInCart(itemOrder);
        clickOnItemToView(itemLocator);
        waitForElementToBeClickable(quantityFieldPath);
        driver.findElement(quantityFieldPath).clear();
        driver.findElement(quantityFieldPath).sendKeys(quantity);
        product.addItemsToCart(new By[]{addToCartBtn});
    }


}
