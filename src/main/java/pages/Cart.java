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



    public void moveToCart(){
//        driver.get("https://automationexercise.com/view_cart");
        driver.findElement(By.xpath("/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]")).click();
    }


    public String getDynamicXpathToGetItemText(String itemTextName) {
        String returnedItemName = driver.findElement(By.xpath("//a[normalize-space()='"+itemTextName+"']")).getText();
        return returnedItemName;
    }

    // the dynamic xpath for each product based on the product name in the Products page
    public String getDynamicXPath(String itemName) {
        return "//a[normalize-space()='" + itemName + "']";
    }


    public void clickProduct(String itemXpath) {
        driver.findElement(By.xpath(itemXpath)).click();
    }









    private final By firstItme = By.xpath("//a[normalize-space()='Men Tshirt']");
    private final By firstItemRemoveBtn = By.xpath("//tr[@id='product-1']//i[@class='fa fa-times']");
    private final By secondItemRemoveBtn = By.xpath("//tr[@id='product-3']//a[@class='cart_quantity_delete']");
    private final By thirdItemRemoveBtn = By.xpath("");

    //processed btn
    private final By processedBtn = By.xpath("//a[@class='btn btn-default check_out']");

    //place order btn
    private final By placeOrderBtn = By.xpath("//a[@class='btn btn-default check_out']");


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
