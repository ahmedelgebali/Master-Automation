package tests;

import Properties.PropReader;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;
import pages.Cart2;
import pages.Products;

import java.io.IOException;

public class CartTest2 extends BaseTest {
    private String numOfQuantityNeeded = "10";
    private Cart2 cart;
    Products product;

    @BeforeClass
    public void setup() throws IOException {
        String url = PropReader.getProp("baseURL");
        setUp(url);
    }
    @AfterClass
    public static void tear(){
        tearDown();
    }
    @BeforeMethod
    public void initializeCart() {
        cart = new Cart2(driver);
        product = new Products(driver);
    }


    @Test (priority = 1)
    public void addItemsToCart(){
        product.navigateToProductsPage();
        product.addItemsToCart(new By[] {product.firstItemPath, product.secondItemPath});
    }
    @Test (dependsOnMethods = "addItemsToCart")
    public void clickOnItemToView() {
        cart.moveToCart();
        By itemLocator = cart.getItemPathBasedOnItsOrderInCart("1");
        System.out.println(itemLocator);
        wait.until(ExpectedConditions.visibilityOfElementLocated(itemLocator));
        cart.clickOnItemToViewAndBack(itemLocator);
    }
    @Test (dependsOnMethods = "clickOnItemToView")
    void changeQuantityOfItem(){
        cart.changeQuantity("1", numOfQuantityNeeded);
    }
}
