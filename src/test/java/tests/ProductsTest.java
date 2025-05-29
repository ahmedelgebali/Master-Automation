package tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Products;
import pages.ProductsLocators;
import utils.PropReader;

import java.io.IOException;

public class ProductsTest extends BaseTest {
    private Products product;


    @BeforeClass
    public void initializeProduct() throws IOException {
        product = new Products(driver);
        driver.get(PropReader.getProp("baseURL"));
    }


    @Test(priority = 1)
    public void navigateToPage() {
        test.info("Navigating to products page");

        product.navigateToProductsPage();
        test.pass("Moved to products page successfully");
    }


    @Test(priority = 2)
    public void addItemsToCart() {
        test.info("Adding some items to cart");

        product.addItemsToCart(new By[]{ProductsLocators.itemPath1, ProductsLocators.itemPath2, ProductsLocators.itemPath3, ProductsLocators.itemPath4,
                ProductsLocators.itemPath5, ProductsLocators.itemPath6, ProductsLocators.itemPath7, ProductsLocators.itemPath9, ProductsLocators.itemPath10,
                ProductsLocators.itemPath15, ProductsLocators.itemPath16, ProductsLocators.lastItemPath
        });
        test.pass("Some items added to the cart successfully");
    }


    @Test(priority = 3)
    public void testWomenFilter() {
        test.info("Checking from women filter");

        product.womenFilter();
        test.pass("Women filter works as expected ");
    }


    @Test(priority = 4)
    public void testMenFilter() {
        test.info("Testing men filter");

        product.menFilter();
        test.pass("Men filter works as expected ");
    }


    @Test(priority = 5)
    public void testKidsFilter() {
        test.info("Testing kids filter");

        product.kidsFilter();
        test.pass("Kids filter works as expected ");
    }


    @Test(priority = 6)
    public void applyBrandFilter() {
        test.info("Testing brand filter");

        product.applyBrandFilter();
        test.pass("Brand filter works as expected ");
    }
}
