package org.example.tests;

import org.example.BaseTest;
import org.example.pages.Products;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class ProductsTest extends BaseTest {
    @BeforeEach
    public void setup() throws InterruptedException {
        setUp("https://automationexercise.com/");
    }

    @Test
    public void addItemsToCartTest() throws InterruptedException {
        Products product = new Products(driver);

        product.addItemsToCartAndFilter();

    }
}
