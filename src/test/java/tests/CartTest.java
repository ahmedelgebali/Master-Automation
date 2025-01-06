package tests;

import Properties.PropReader;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import pages.Cart;
import pages.Products;
import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class CartTest extends BaseTest {
    private Cart cart;
    String itemName;

    @BeforeClass
    public static void setup() throws IOException {
        String url = PropReader.getProp("productsURL");
        setUp(url);
    }



    @Test (priority = 1)
    public String addItemToCart() {
        Products product = new Products(driver);
        itemName = driver.findElement(product.firstItemPath).getText();
        product.addItemsToCart(new By[]{product.firstItemPath}); // Add the first item
        return itemName;
    }

//    @Test(priority = 2)
    public void navigateToCart() {
        cart = new Cart(driver);
        cart.moveToCart(); // Navigate directly to cart
    }

//    @Test(priority = 3)
    public void performActionOnItem() {
        String itemText = cart.getDynamicXpathToGetItemText(itemName);
        String itemPath = cart.getDynamicXPath(itemText);
        cart.clickProduct(itemPath);
    }




//    @AfterAll
//    public static void tearDown() {
//        driver.quit(); // Close the WebDriver session after all tests are complete

}
