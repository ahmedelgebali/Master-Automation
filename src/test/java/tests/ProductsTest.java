package tests;

import Properties.PropReader;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Products;
import org.openqa.selenium.By;

import java.io.IOException;

public class ProductsTest extends BaseTest {
    Products product = new Products(driver);

    @BeforeClass
    public static void setup() throws IOException {
        String url = PropReader.getProp("baseURL");
        setUp(url);
    }


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
