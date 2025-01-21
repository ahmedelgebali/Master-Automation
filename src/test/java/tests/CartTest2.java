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
//    @AfterClass
    public static void tear(){
        tearDown();
    }
    @BeforeMethod
    public void initializeCart() {
        cart = new Cart2(driver);
        product = new Products(driver);
    }

    @Test (priority = 2)
    public void viewProductDetails(){
        product.navigateToProductsPage();
        product.viewItemDetails(new By[]{
                product.itemDetails1, product.itemDetails2, product.itemDetails3, product.itemDetails4,
                product.itemDetails5, product.itemDetails6, product.itemDetails7, product.itemDetails8, product.itemDetails9,
                product.itemDetails10, product.itemDetails11, product.itemDetails12, product.itemDetails13, product.itemDetails14,
                product.itemDetails15, product.itemDetails16, product.itemDetails17, product.itemDetails18, product.itemDetails19,
                product.itemDetails20, product.itemDetails21
        });
    }

    @Test (priority = 1, groups = "checkMethode")
    public void addItemsToCart(){
        product.addItemsToCart(new By[] {product.firstItemPath, product.secondItemPath, product.lasteItemPath});
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
