package org.example.tests;

import org.example.BaseTest;
import org.example.pages.Home;
import org.example.pages.Products;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class ProductsTest extends BaseTest {
    Products product = new Products(driver);

    @BeforeAll
    public static void setup() throws InterruptedException {
        setUp("https://automationexercise.com/");
    }
//    @AfterAll
    public static void teardown(){
        tearDown();
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


     /*

    @Test
    public void addItemsToCart() throws InterruptedException {
        By[] productsPaths = Home.getItemsPathsArray();
        product.addItemsToCart(new By[] { productsPaths[1] });
    }

     */




    @Test
    public void applyMenAndWomenFilter(){
        product.applyFilter();
    }
    @Test
    public void applyBrandFilter(){
        product.applyBrandFilter();
    }

}
