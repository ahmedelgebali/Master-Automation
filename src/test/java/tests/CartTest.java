package tests;

import Properties.PropReader;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Cart;
import pages.Products;

import java.io.IOException;

public class CartTest extends BaseTest {
    private Cart cart;
    String itemName;

    @BeforeClass
    public static void setup() throws IOException {
        String url = PropReader.getProp("productsURL");
        setUp(url);
    }


    @AfterClass
    public static void tearDown() {
        driver.quit(); // Close the WebDriver session after all tests are complete

    }

    @Test(priority = 1)
    public void addItemToCart() {
        Products product = new Products(driver);
        product.addItemsToCart(new By[]{product.firstItemPath}); // Add the first item
        itemName = driver.findElement(product.firstItemPath).getText();
        System.out.println(itemName);
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
}
