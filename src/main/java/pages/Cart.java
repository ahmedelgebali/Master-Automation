package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Cart extends Base {
    private final Products product;
    private final Login login;
    // <--------------------------> Locators <-------------------------->
    private final By cartPagePath = By.xpath("//div//ul//li//a[@href='/view_cart']");
    private final By quantityFieldPath = By.xpath("//input[@id='quantity']");
    private final By processToCheckout = By.xpath("//a[normalize-space()='Proceed To Checkout']");
    private final By placeOrderBtn = By.xpath("//a[normalize-space()='Place Order']");
    private final By nameOnCart = By.xpath("//input[@name='name_on_card']");
    private final By cartNum = By.xpath("//input[@name='card_number']");
    private final By cvc = By.xpath("//input[@placeholder='ex. 311']");
    private final By expirationMonth = By.xpath("//input[@placeholder='MM']");
    private final By expirationYear = By.xpath("//input[@placeholder='YYYY']");
    private final By payAndConfirm = By.xpath("//button[@id='submit']");
    private final By addToCartBtnInViewItem = By.xpath("//button[@type='button']");
    private final By continueBtn = By.xpath("//a[normalize-space()='Continue']");
    private final By loginPath = By.xpath("//u[normalize-space()='Register / Login']");

    public Cart(WebDriver driver) {
        super(driver);
        this.product = new Products(driver);
        this.login = new Login(driver);
    }

    public Cart(Actions action, JavascriptExecutor js) {
        super(action, js);
        this.product = new Products(driver);
        this.login = new Login(driver);
    }

    // <--------------------------> Action methods <-------------------------->
    // navigate to Cart
    public void moveToCart() {
        waitForElementToBeClickable(cartPagePath);
        driver.findElement(cartPagePath).click();
    }

    //view item details
    public void clickOnItemToViewAndBack(By itemLocator) {
        waitForElementToBeClickable(itemLocator);
        driver.findElement(itemLocator).click();
        driver.navigate().back();
    }

    // change the quantity of a particular item
    public void changeQuantity(String itemOrder, String quantity) {
        By itemLocator = getItemPathBasedOnItsOrderInCart(itemOrder);
        clickOnItemToView(itemLocator);
        waitForVisibility(quantityFieldPath);

        driver.findElement(quantityFieldPath).clear();
        driver.findElement(quantityFieldPath).sendKeys(quantity);
        product.addItemsToCart(new By[]{addToCartBtnInViewItem});
        driver.navigate().back();
    }


    //printing the precises of items in the Cart
    public void printItemPrice(String itemNumber) {
        String itemPrice = driver.findElement(getItemPriceLocator(itemNumber)).getText();
        System.out.println(itemPrice);
    }

    // login to check out the order
    public void loginToCheckout() {
        driver.findElement(processToCheckout).click();
        driver.findElement(loginPath).click();
        //The login to be performed through the Test class
    }

    //follow to check out the order
    public void processAndPlaceOrder() {
        driver.findElement(processToCheckout).click();
        scrollBy(0, 1000);
        waitForVisibility(placeOrderBtn);
        driver.findElement(placeOrderBtn).click();
    }

    //check out the order
    public void fillTheCartInfoAndCheckout(String NameOnCart, String CartNumber, String CVC, String ExpirationMonth, String ExpirationYear) {
        driver.findElement(nameOnCart).sendKeys(NameOnCart);
        driver.findElement(cartNum).sendKeys(CartNumber);
        driver.findElement(cvc).sendKeys(CVC);
        driver.findElement(expirationMonth).sendKeys(ExpirationMonth);
        driver.findElement(expirationYear).sendKeys(ExpirationYear);
        driver.findElement(payAndConfirm).click();

        waitForElementToBeClickable(continueBtn);
        driver.findElement(continueBtn).click();
    }


    // <--------------------------> Helper methods <-------------------------->
    public void clickOnItemToView(By itemLocator) {
        waitForElementToBeClickable(itemLocator);
        driver.findElement(itemLocator).click();
    }

    // dynamic locators
    private By getDynamicLocator(String baseLocator, String itemNum) {
        return By.cssSelector(baseLocator.replace("X", String.valueOf(itemNum)));
    }

    public By getItemPriceLocator(String itemNum) {
        return getDynamicLocator("tr[id='product-X'] td[class='cart_price'] p", itemNum);
    }

    public By getItemPathBasedOnItsOrderInCart(String itemOrder) {
        String itemsLocator = "a[href='/product_details/X']";
        return By.cssSelector(itemsLocator.replace("X", String.valueOf(itemOrder)));
    }

}
