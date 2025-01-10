package tests;

import Properties.PropReader;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Cart;
import pages.Products;

import java.io.IOException;

public class CartTest extends BaseTest {
    String itemName;
    int theTendedItemNumber = 1;
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
    public void setObject() {
        cart = new Cart(driver);
    }


    @Test(priority = 1)
    public void addItemsToCart() {
        Products product = new Products(driver);
        //getting the name of the item for latter use in the dynamic xpath in the cart
        System.out.println("this is before getting the item name " + itemName);
        itemName = driver.findElement(product.firstItemNamePath).getText();
        System.out.println("this is after getting the item name " + itemName);
        product.addItemsToCart(new By[]{product.firstItemPath}); // add the first item to cart
    }


    @Test(priority = 2)
    public void navigateToCart() {
        cart.moveToCart(); // navigate directly to Cart
    }


    @Test(priority = 3)
    public void performActionOnItems() {
        //giving the item name that I got from the "addItemToCart" methode
        // and receive the dynamic path for the item in the cart page
        String itemPath = cart.getItemPathViaItemName(itemName);
        System.out.println("Generated XPath: " + itemPath);

        cart.clickProduct(itemPath);                                                //open the product info page
        cart.changeQuantity("10");                      //change the product quantity, then add them to cart and handle the po-up to continue
        driver.navigate().back();                                                   //back to cart
        driver.navigate().refresh();
        By itemPricePath = cart.getItemPriceViaItemNumber(theTendedItemNumber);    //the item price
        waitForVisibility(itemPricePath);
        String itemPriceText = driver.findElement(itemPricePath).getText();
        System.out.println("the price for the --> [" + itemName + "] is --> [" + itemPriceText + "]");

        By itemQuantityPath = cart.getItemQuantityNumViaItemNumber(theTendedItemNumber); //item quantity
        String itemQuantity = driver.findElement(itemQuantityPath).getText();
        System.out.println("the total number of quantity for the -->\" " + itemName + "\" is --> [" + itemQuantity + "]");

        By itemTotalPricePath = cart.getItemTotalPriceViaItemNumber(theTendedItemNumber); //items total price
        String itemsTotalPrice = driver.findElement(itemTotalPricePath).getText();
        System.out.println("the total price for the --> [" + itemName + "] is --> [" + itemsTotalPrice + "]");
    }

}
