package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Cart extends Base {
    private final Products product;
    private final Login login;

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



// <--------------------------> Locators <-------------------------->
    private final By cartPagePath = By.xpath("//div//ul//li//a[@href='/view_cart']");
    private final By quantityFieldPath = By.xpath("//input[@id='quantity']");
    private final By processedBtn = By.xpath("//a[@class='btn btn-default check_out']");
    private final By placeOrderBtn = By.xpath("//a[@class='btn btn-default check_out']");
    private final By nameOnCart = By.xpath("//input[@name='name_on_card']");
    private final By cartNum = By.xpath("//input[@name='card_number']");
    private final By cvc = By.xpath("//input[@placeholder='ex. 311']");
    private final By expirationMonth = By.xpath("//input[@placeholder='MM']");
    private final By expirationYear = By.xpath("//input[@placeholder='YYYY']");
    private final By payAndConfirm = By.xpath("//button[@id='submit']");
    private final By addToCartBtnInViewItem = By.xpath("//button[@type='button']");
    private final By continueBtn = By.xpath("//a[normalize-space()='Continue']");
    private final By loginPath  = By.xpath("//u[normalize-space()='Register / Login']");



// <--------------------------> Action methods <-------------------------->
    // navigate to Cart
    public void moveToCart() {
        waitForElementToBeClickable(cartPagePath);
        driver.findElement(cartPagePath).click();
    }

    public By getItemPathBasedOnItsOrderInCart(String itemOrder){
        String itemsLocator = "a[href='/product_details/X']";
        return By.cssSelector(itemsLocator.replace("X", String.valueOf(itemOrder)));
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
    // change quantity of a particular item
    public void changeQuantity(String itemOrder, String quantity) {
        By itemLocator = getItemPathBasedOnItsOrderInCart(itemOrder);
        clickOnItemToView(itemLocator);
        waitForVisibility(quantityFieldPath);

        driver.findElement(quantityFieldPath).clear();
        driver.findElement(quantityFieldPath).sendKeys(quantity);
        product.addItemsToCart(new By[]{addToCartBtnInViewItem});
        driver.navigate().back();

    }

    public void printItemPrice(String itemNumber){
        String itemPrice = driver.findElement(getItemPriceLocator(itemNumber)).getText();
        System.out.println(itemPrice);
    }
    public void goLogin(){
        driver.findElement(processedBtn).click();
        driver.findElement(loginPath).click();

    }

    public void processedCheckout(String NameOnCart, String CartNumber, String CVC, String ExpirationMonth, String ExpirationYear) {

        scrollBy(0,1000);
        waitForVisibility(placeOrderBtn);
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

// <--------------------------> Helper methods <-------------------------->

    // dynamic locators
    private By getDynamicLocator(String baseLocator, String itemNum) {
        return By.cssSelector(baseLocator.replace("X", String.valueOf(itemNum)));
    }

    public By getItemPriceLocator(String itemNum) {
        return getDynamicLocator("tr[id='product-X'] td[class='cart_price'] p", itemNum);
    }

    /*

    public By getItemTotalPriceLocator(String itemNum) {
        return getDynamicLocator("//tr[@id='product-x']//td[@class='cart_total']", itemNum);
    }

    public By getItemDeleteButtonLocator(String itemNum) {
        return getDynamicLocator("(//td[@class='cart_delete'])[x]", itemNum);
    }

    public By getItemQuantityLocator(String itemNum) {
        return getDynamicLocator("(//td[@class='cart_quantity'])[x]", itemNum);
    }

     */
}
