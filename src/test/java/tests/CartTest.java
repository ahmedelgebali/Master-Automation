package tests;

import utils.PropReader;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;
import pages.Cart;
import pages.Login;
import pages.Products;

import java.io.IOException;

public class CartTest extends BaseTest {
    private String numOfQuantityNeeded = "10";
    private Cart cart;
    private Products product;
    private Login login;

    @BeforeMethod
    public void initializeCart() throws IOException {
        driver.get(PropReader.getProp("baseURL"));
        cart = new Cart(driver);
        product = new Products(driver);
        login = new Login(driver);
        startTest("Cart Test");
    }

    @Test(priority = 1)
    public void viewProductDetails() {
        test.info("Navigating to product details");
        product.navigateToProductsPage();
        product.viewItemDetails(new By[] {
                product.itemDetails1, product.itemDetails2, product.itemDetails3, product.itemDetails4,
                product.itemDetails5, product.itemDetails6, product.itemDetails7, product.itemDetails8, product.itemDetails9,
                product.itemDetails10, product.itemDetails11, product.itemDetails12, product.itemDetails13, product.itemDetails14,
                product.itemDetails15, product.itemDetails16, product.itemDetails17, product.itemDetails18, product.itemDetails19,
                product.itemDetails20, product.itemDetails21
        });
        test.pass("Product details viewed");
    }

    @Test(priority = 2)
    public void addItemsToCart() {
        test.info("Adding items to cart");
        product.navigateToProductsPage();
        product.addItemsToCart(new By[] {product.itemPath1, product.itemPath2});
        test.pass("Items added to cart");
    }

    @Test(dependsOnMethods = "addItemsToCart")
    public void printOutItemPrices() {
        test.info("Printing out item prices");
        cart.moveToCart();
        cart.printItemPrice("1");
        test.pass("Item prices printed");
    }

    @Test(dependsOnMethods = "printOutItemPrices")
    public void clickOnItemToView() {
        test.info("Clicking on item to view");
        cart.moveToCart();
        By itemLocator = cart.getItemPathBasedOnItsOrderInCart("1");
        wait.until(ExpectedConditions.visibilityOfElementLocated(itemLocator));
        cart.clickOnItemToViewAndBack(itemLocator);
        test.pass("Clicked on item and returned");
    }

    @Test(dependsOnMethods = "clickOnItemToView")
    public void changeQuantityOfItem() {
        test.info("Changing quantity of item");
        cart.changeQuantity("1", numOfQuantityNeeded);
        test.pass("Item quantity changed");
    }

    // @Test (dependsOnMethods = "addItemsToCart")
    public void checkout() throws IOException {
        test.info("Performing checkout");
        cart.moveToCart();

        String name = PropReader.getProp("nameOnCart");
        String cartNum = PropReader.getProp("cartNum");
        String cvc = PropReader.getProp("CVC");
        String expMonth = PropReader.getProp("expirationMonth");
        String expYear = PropReader.getProp("expirationYear");

        cart.processedCheckout(name, cartNum, cvc, expMonth, expYear);
        test.pass("Checkout processed successfully");
    }
}
