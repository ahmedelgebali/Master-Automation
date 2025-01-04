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

    //elements
    //item names
    private final By firstItme = By.xpath("//a[normalize-space()='Men Tshirt']");

    private final By firstItemRemoveBtn = By.xpath("//tr[@id='product-1']//i[@class='fa fa-times']");
    private final By secondItemRemoveBtn = By.xpath("//tr[@id='product-3']//a[@class='cart_quantity_delete']");
    private final By thirdItemRemoveBtn = By.xpath("");

    //processed btn
    private final By processedBtn = By.xpath("//a[@class='btn btn-default check_out']");

    //place order btn
    private final By placeOrderBtn = By.xpath("//a[@class='btn btn-default check_out']");


}
