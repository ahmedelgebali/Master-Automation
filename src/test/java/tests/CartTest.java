package tests;

import pages.ProductsLocators;
import utils.PropReader;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;
import pages.Cart;
import pages.Login;
import pages.Products;
import java.io.IOException;

public class CartTest extends BaseTest {
    private Cart cart;
    private Products product;
    Login login;


    @BeforeClass
    public void initializeCart() {
        cart = new Cart(driver);
        product = new Products(driver);
        login = new Login(driver);
    }


    @Test(priority = 1)
    public void viewProductDetails() throws IOException {
        test.info("Navigating to Products page and show the products details");

        driver.get(PropReader.getProp("baseURL"));
        product.navigateToProductsPage();
        test.pass("moved toProducts page successfully");

        product.viewItemDetails(new By[] {
                ProductsLocators.itemDetails1, ProductsLocators.itemDetails2, ProductsLocators.itemDetails3, ProductsLocators.itemDetails4,
                ProductsLocators.itemDetails5, ProductsLocators.itemDetails6, ProductsLocators.itemDetails7, ProductsLocators.itemDetails8, ProductsLocators.itemDetails9,
                ProductsLocators.itemDetails10, ProductsLocators.itemDetails11, ProductsLocators.itemDetails12, ProductsLocators.itemDetails13, ProductsLocators.itemDetails14,
                ProductsLocators.itemDetails15, ProductsLocators.itemDetails16, ProductsLocators.itemDetails17, ProductsLocators.itemDetails18, ProductsLocators.itemDetails19,
                ProductsLocators.itemDetails20, ProductsLocators.itemDetails21
        });
        test.pass("Product details viewed successfully");
    }


    @Test(priority = 2)
    public void addItemsToCart() {
        test.info("Adding items to cart");

        product.addItemsToCart(new By[] {ProductsLocators.itemPath1, ProductsLocators.itemPath2, ProductsLocators.itemPath3, ProductsLocators.itemPath4,
                ProductsLocators.itemPath5, ProductsLocators.itemPath6, ProductsLocators.itemPath7, ProductsLocators.itemPath9, ProductsLocators.itemPath10,
                ProductsLocators.itemPath15, ProductsLocators.itemPath16, ProductsLocators.lastItemPath
        });
        test.pass("Items added to cart successfully");
    }


    @Test(priority = 3, dependsOnMethods = "addItemsToCart")
    public void printOutItemPrices() {
        test.info("Printing out item prices");

        cart.moveToCart();
        test.pass("Moved to Cart ");

        cart.printItemPrice("2");
        test.pass("Item prices printed in the console");
    }


    @Test(priority = 4, dependsOnMethods = "printOutItemPrices" )
    public void clickOnItemsToView() {
        test.info("Clicking on item to view");

        By itemLocator = cart.getItemPathBasedOnItsOrderInCart("2");
        wait.until(ExpectedConditions.visibilityOfElementLocated(itemLocator));
        cart.clickOnItemToViewAndBack(itemLocator);
        test.pass("Viewed the item and returned to Cart");
    }


    @Test(priority = 5)
    public void changeQuantityOfItem() {
        test.info("Changing quantity of item");

        String numOfQuantityNeeded = "10";
        cart.changeQuantity("2", numOfQuantityNeeded); //starts form 2
        test.pass("Item quantity changed to 10 rather than 1 ");
    }


     @Test (priority = 6, dependsOnMethods = "changeQuantityOfItem")
     public void processToFillTheCartInfoAndCheckout() throws IOException {
        test.info("Processing to check out ");

         cart.moveToCart();
         test.pass("Moved to cart ");

         cart.loginToCheckout();
         performLogin();
         test.pass("logged in in order to complete the checkout process ");

         cart.moveToCart();
         test.pass("Moved to Cart again");

         cart.processAndPlaceOrder();
         test.pass("Processed and placed the order ");
     }


    @Test(priority = 7, dependsOnMethods = "processToFillTheCartInfoAndCheckout")
    public void fillTheCartInfoAndCheckoutTheOrder() throws IOException {
        test.info("Filling the payment info Checking out the order");

        //filling the cart info to purchase
        String name = PropReader.getProp("nameOnCart");
        String cartNum = PropReader.getProp("cartNum");
        String cvc = PropReader.getProp("CVC");
        String expMonth = PropReader.getProp("expirationMonth");
        String expYear = PropReader.getProp("expirationYear");

        cart.fillTheCartInfoAndCheckout(name, cartNum, cvc, expMonth, expYear);
        test.pass("Entered the the Payment info and purchased successfully ");
    }


    //helper log in method
    public void performLogin() throws IOException {
        String mail = PropReader.getProp("mail");
        String pass = PropReader.getProp("pass");

        login.enterLoginMail(mail);
        login.enterLoginPass(pass);
        login.clickLoginBtn();
        login.checkFromLogin();
    }
}
