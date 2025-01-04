package tests;

import Properties.PropReader;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import pages.Products;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.IOException;

public class ProductsTest extends BaseTest {
    Products product = new Products(driver);

    @BeforeAll
    public static void setup() throws IOException {
        String url = PropReader.getProp("baseURL");
        setUp(url);
    }
//    @AfterAll
//    public static void teardown(){
//        tearDown();
//    }

    @Test

    public void navigateToPage(){
        product.navigateToProductsPage();
    }

    @Test
    public void addItemsToCart() throws InterruptedException {
//        By[] productsPaths = Home.getItemsPathsArray();
        product.addItemsToCart(new By[] {product.firstItemPath, product.secondItemPath, product.thirdItemPath});
    }





    @Test
    public void applyMenAndWomenFilter(){
        product.applyFilter();
    }
    @Test
    public void applyBrandFilter(){
        product.applyBrandFilter();

    }


}
