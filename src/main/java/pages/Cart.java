package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class Cart extends Base{

    public Cart(WebDriver driver){super(driver);}
    public Cart(Actions action, JavascriptExecutor js){
        super(action, js);
    }
    Products product = new Products(driver);




    //paths
    public By cartPagePath = By.xpath("//div//ul//li//a[@href='/view_cart']");
    public By itemPricePath = By.xpath("tr[id='product-x'] td[class='cart_price']");
    public By itemTotalPricePath = By.xpath("tr[id='product-x'] td[class='cart_total']");
    public By itemDeleteBtnPath = By.xpath("(//td[@class='cart_delete'])[x]");
    public By itemQuantityNumberPath = By.xpath("(//td[@class='cart_quantity'])[x]");

    public By quantityFiled = By.xpath("//input[@id='quantity']");

    //processed btn
    private final By processedBtn = By.xpath("//a[@class='btn btn-default check_out']");
    //place order btn
    private final By placeOrderBtn = By.xpath("//a[@class='btn btn-default check_out']");


    public void moveToCart(){
        driver.findElement(cartPagePath).click();
    }



    // the dynamic xpath for each product based on the product name in the Products page
    public String getItemPathViaItemName(String itemName) {
        return "//a[normalize-space()='" + itemName + "']";    }

    public By getItemPriceViaItemNumber(int itemNum) {
        return By.xpath("tr[id='product-" + itemNum + "'] td[class='cart_price']");
    }
    public By getItemTotalPriceViaItemNumber(int itemNum) {
        return By.xpath("tr[id='product-" + itemNum + "'] td[class='cart_total']");
    }
    public By getItemDeleteBtnViaItemNumber(int itemNum) {
        return By.xpath("(//td[@class='cart_delete'])[" + itemNum + "]");
    }
    public By getItemQuantityNumViaItemNumber(int itemNum) {
        return By.xpath("(//td[@class='cart_quantity'])[" + itemNum + "]");
    }




    public void clickProduct(String itemXpath) {
        driver.findElement(By.xpath(itemXpath)).click();
    }
    public void changeQuantity(String numOfQuantityNeeded, String itemPath){
        driver.findElement(quantityFiled).clear();
        driver.findElement(quantityFiled).sendKeys(numOfQuantityNeeded);
        By itemLocator = By.xpath(itemPath);
        product.addItemsToCart(new By []{itemLocator});

    }











    public boolean isItemInCart(By firstItemPath) {
        return false;
    }

    public boolean isCartPageDisplayed() {
        return false;
    }

    public boolean isProductActionSuccessful(String itemName) {
        return false;
    }
}
