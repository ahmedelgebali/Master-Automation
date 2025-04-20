package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

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

// <--------------------------> Locators <-------------------------->
    private final By cartPagePath = By.xpath("//div//ul//li//a[@href='/view_cart']");
    private final By quantityFieldPath = By.xpath("//input[@id='quantity']");
    private final By addToCartBtn = By.xpath("//button[normalize-space()='Add to cart']");
    private final By processedBtn = By.xpath("//a[@class='btn btn-default check_out']");
    private final By placeOrderBtn = By.xpath("//a[@class='btn btn-default check_out']");
    private final By nameOnCart = By.xpath("//input[@name='name_on_card']");
    private final By cartNum = By.xpath("//input[@name='card_number']");
    private final By cvc = By.xpath("//input[@placeholder='ex. 311']");
    private final By expirationMonth = By.xpath("//input[@placeholder='MM']");
    private final By expirationYear = By.xpath("//input[@placeholder='yyyy']");
    private final By payAndConfirm = By.xpath("//button[@id='submit']");
    private final By continueBtn = By.xpath("//a[normalize-space()='Continue']");






// <--------------------------> Action methods <-------------------------->

    // navigate to Cart
    public void moveToCart() {
        waitForElementToBeClickable(cartPagePath);
        driver.findElement(cartPagePath).click();
    }

    public By getItemPathBasedOnItsOrderInCart(String itemOrder){
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

    public void printItemPrice(String itemNumber){
        String itemPrice = driver.findElement(getItemPriceLocator(itemNumber)).getText();
        System.out.println(itemPrice);
    }


    // dynamic locators
    private By getDynamicLocator(String baseLocator, String itemNum) {
        return By.cssSelector(baseLocator.replace("X", String.valueOf(itemNum)));
    }

    public By getItemPriceLocator(String itemNum) {
        return getDynamicLocator("tr[id='product-X'] td[class='cart_price'] p", itemNum);
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


    public void processedCheckout(String NameOnCart, String CartNumber, String CVC, String ExpirationMonth, String ExpirationYear) {
        driver.findElement(processedBtn).click();
        scrollBy(0,100);
        driver.findElement(placeOrderBtn).click();
        driver.findElement(nameOnCart).sendKeys(NameOnCart);
        driver.findElement(cartNum).sendKeys(CartNumber);
        driver.findElement(cvc).sendKeys(CVC);
        driver.findElement(expirationMonth).sendKeys(ExpirationMonth);
        driver.findElement(expirationYear).sendKeys(ExpirationYear);
        driver.findElement(payAndConfirm).click();
        waitForElementToBeClickable(continueBtn);
        driver.findElement(continueBtn).click();
    }



}
