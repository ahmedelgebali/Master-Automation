package tests;

import Properties.PropReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Cart;
import pages.Products;

import java.io.IOException;

public class CartTest extends BaseTest {
    SoftAssert softAssert = new SoftAssert();

    private String itemName;
    private String  theTendedItemNumber = "1";
    private String numOfQuantityNeeded = "10";
    private Cart cart;

    @BeforeClass
    public static void setup() throws IOException {
        String url = PropReader.getProp("productsURL");
        setUp(url);
    }
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @BeforeMethod
    public void setUpCart() {
        cart = new Cart(driver);
    }

    @Test(priority = 1)
    public void addItemsToCart() {
        Products product = new Products(driver);
        // capture the first item's name
        itemName = product.getFirstItemName();
        softAssert.assertNotNull(itemName, "Item name should not be null.");
        // add item to the cart
        product.addItemsToCart(new By[]{product.firstItemPath});
    }

    @Test(priority = 2, dependsOnMethods = "addItemsToCart")
    public void navigateToCart() {
        cart.moveToCart();
        softAssert.assertTrue(cart.isCartPageDisplayed(), "Cart page is displayed");
        softAssert.assertAll();
    }

    @Test(priority = 3, dependsOnMethods = "navigateToCart")
    public void performActionOnItems() {
        navigateToProductDetails();
        changeQuantity(numOfQuantityNeeded);
        verifyQuantityChange();
        validateItemPrice();
        validateTotalPrice();
    }


    public void navigateToProductDetails() {
        // Navigate to product details page
        cart.clickProduct(cart.getItemPathByName(itemName)); //add product to cart
        By quantityPath = cart.getItemQuantityLocator(theTendedItemNumber); //get quantity path
        softAssert.assertNotNull(quantityPath, "Item price should not be null.");
    }

    public void changeQuantity(String quantity) {
        // Change the quantity of the item in the cart
        cart.changeQuantity(quantity);
        driver.navigate().back();
        driver.navigate().refresh();
    }

    public void verifyQuantityChange() {
        // Verify the quantity change was successful
        By quantityPath = cart.getItemQuantityLocator(theTendedItemNumber);
        String quantity = driver.findElement(quantityPath).getText();
        System.out.println("Quantity after change: " + quantity);
        softAssert.assertEquals(quantity, "11", "Item quantity should be updated");
    }

    public void validateItemPrice() {
        // Validate the item price
        By itemPrice = cart.getItemPriceLocator(theTendedItemNumber);
        String price = driver.findElement(itemPrice).getText();
        softAssert.assertNotNull(itemPrice, "Item price should not be null");
        System.out.println("Item price: " + price);
    }

    public void validateTotalPrice() {
        // Validate the total price
        By totalPrice = cart.getItemTotalPriceLocator(theTendedItemNumber);
        softAssert.assertNotNull(totalPrice, "Total price should not be null.");
    }

}
