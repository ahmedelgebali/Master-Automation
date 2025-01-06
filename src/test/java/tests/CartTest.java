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
    private Products product;

    @BeforeClass
    public static void setup() throws IOException {
        String url = PropReader.getProp("baseURL");
        setUp(url);
    }


    @Test (priority = 1)
    public void addItemToCart() {
        product = new Products(driver);
        product.navigateToProductsPage(); // Navigate to products page
        product.addItemsToCart(new By[]{product.firstItemPath}); // Add the first item
        assertTrue(cart.isItemInCart(product.firstItemPath), "Item was not added to the cart.");
    }

    @Test(priority = 2)
    public void navigateToCart() {
        cart = new Cart(driver);
        cart.moveToCart(); // Navigate directly to cart
        assertTrue(cart.isCartPageDisplayed(), "Failed to navigate to the cart page.");
    }

    @Test(priority = 3)
    public void performActionOnItem() {
        product.navigateToProductsPage(); // Navigate to products page
        String itemName = driver.findElement(product.firstItemPath).getText();
        String itemText = cart.getDynamicXpathToGetItemText(itemName);
        String itemPath = cart.getDynamicXPath(itemText);
        cart.clickProduct(itemPath); // Perform action
        assertTrue(cart.isProductActionSuccessful(itemName), "Action on the item failed.");
    }

//    @AfterAll
//    public static void tearDown() {
//        driver.quit(); // Close the WebDriver session after all tests are complete

}
