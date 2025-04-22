package tests;

import utils.PropReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Products;
import org.openqa.selenium.By;
import java.io.IOException;

public class ProductsTest extends BaseTest {
    private Products product;

    @BeforeMethod
    public void initializeProduct() throws IOException {
        product = new Products(driver);
        driver.get(PropReader.getProp("baseURL"));
        startTest("Products Page Test");
    }

    @Test(priority = 1)
    public void navigateToPage() {
        test.info("Navigating to products page");
        product.navigateToProductsPage();
        test.pass("Navigated to products page");
    }

    @Test(priority = 2)
    public void addItemsToCart() {
        test.info("Adding items to cart");
        product.addItemsToCart(new By[] {
                product.itemPath1, product.itemPath2, product.itemPath3, product.itemPath4,
                product.itemPath5, product.itemPath6, product.itemPath7
        });
        test.pass("Items added to cart");
    }

    @Test(priority = 3)
    public void testWomenFilter() {
        test.info("Applying women filter");
        product.womenFilter();
        test.pass("Women filter applied");
    }

    @Test(priority = 4)
    public void testMenFilter() {
        test.info("Applying men filter");
        product.menFilter();
        test.pass("Men filter applied");
    }

    @Test(priority = 5)
    public void testKidsFilter() {
        test.info("Applying kids filter");
        product.kidsFilter();
        test.pass("Kids filter applied");
    }

    @Test(priority = 6)
    public void applyBrandFilter() {
        test.info("Applying brand filter");
        product.applyBrandFilter();
        test.pass("Brand filter applied");
    }
}
