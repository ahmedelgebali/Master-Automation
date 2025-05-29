package tests;

import pages.ProductsLocators;
import utils.PropReader;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import pages.Cart;
import pages.Login;
import pages.Products;
import java.io.IOException;

public class CartTest2 extends BaseTest {
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
    public void addItemsToCart() throws IOException {
        driver.get(PropReader.getProp("baseURL"));
        product.navigateToProductsPage();

        product.addItemsToCart(new By[] {ProductsLocators.itemPath1, ProductsLocators.itemPath2});
    }




    @Test ( priority = 2)
    public void checkout() throws IOException {


        cart.moveToCart();
        cart.goLogin();
        performLogin();
        cart.moveToCart();

        String name = PropReader.getProp("nameOnCart");
        String cartNum = PropReader.getProp("cartNum");
        String cvc = PropReader.getProp("CVC");
        String expMonth = PropReader.getProp("expirationMonth");
        String expYear = PropReader.getProp("expirationYear");

        cart.processedCheckout(name, cartNum, cvc, expMonth, expYear);
        test.pass("Checkout processed successfully");
    }


    public void performLogin() throws IOException {
        String mail = PropReader.getProp("mail");
        String pass = PropReader.getProp("pass");

        login.enterLoginMail(mail);
        login.enterLoginPass(pass);
        login.clickLoginBtn();
        login.checkFromLogin();
    }
}
