package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Products {
    private WebDriver driver;
    private JavascriptExecutor js;

    // Corrected constructor
    public Products(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }

    // Items' add to cart button's XPaths
    private By firstItemPath = By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[1]/div[1]/a");
    private By secondItemPath = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[1]/a");
    private By thirdItemPath = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[1]/a");


    // continue shopping btn's xpath
    private By continueBtn = By.xpath("//button[@class='btn btn-success close-modal btn-block']");
    //view cart btn
    private By viewCartBtn = By.xpath("//u[normalize-space()='View Cart']");

    //filter XPaths --> category
            //WOMEN
            private By womenFilter = By.xpath("//a[normalize-space()='Women']//i[@class='fa fa-plus']");
                private By dressFilter = By.xpath("//div[@id='Women']//a[contains(text(),'Dress')]");
                private By topsFilter = By.xpath("//a[normalize-space()='Tops']");
                private By sareeFilter = By.xpath("//a[normalize-space()='Saree']");

            //MEN
            private By menFilter = By.xpath("//a[normalize-space()='Men']//i[@class='fa fa-plus']");
                private By tshirtsFilter = By.xpath("//a[normalize-space()='Tshirts']");
                private By jeansFilter = By.xpath("//a[normalize-space()='Jeans']");

            //KIDS
            private By kidsFilter = By.xpath("//a[normalize-space()='Kids']//i[@class='fa fa-plus']");
                private By kidsDressFilter = By.xpath("//div[@id='Kids']//a[contains(text(),'Dress')]");
                private By kidsTopsAndShirts = By.xpath("//a[normalize-space()='Tops & Shirts']");

    //filter XPaths --> Brands
            private By firstBrandFilter = By.xpath("//a[@href='/brand_products/Polo']");
            private By secondBrandFilter = By.xpath("//a[@href='/brand_products/H&M']");
            private By thirdBrandFilter = By.xpath("//a[@href='/brand_products/Madame']");
            private By fourthBrandFilter = By.xpath("//a[@href='/brand_products/Mast & Harbour']");
            private By fifthBrandFilter = By.xpath("//a[@href='/brand_products/Babyhug']");
            private By sixthBrandFilter = By.xpath("//a[@href='/brand_products/Allen Solly Junior']");
            private By seventhBrandFilter = By.xpath("//a[@href='/brand_products/Kookie Kids']");
            private By eighthBrandFilter = By.xpath("//a[@href='/brand_products/Biba']");









    // Add products to cart
    public void addItemsToCart() throws InterruptedException {
        js.executeScript("window.scrollBy(0, 100);");

        // add 3 items to the cart
        driver.findElement(firstItemPath).click();
        Thread.sleep(5);
        driver.findElement(continueBtn).click();
        driver.findElement(secondItemPath).click();
        Thread.sleep(5);
        driver.findElement(continueBtn).click();
        driver.findElement(thirdItemPath).click();
        Thread.sleep(5);
        driver.findElement(continueBtn).click();

        //women filter
        driver.findElement(womenFilter).click();
        driver.findElement(dressFilter).click();

        driver.findElement(womenFilter).click();
        driver.findElement(topsFilter).click();

        driver.findElement(womenFilter).click();
        driver.findElement(sareeFilter).click();

        //men filter
        driver.findElement(menFilter).click();
        driver.findElement(tshirtsFilter).click();

        driver.findElement(menFilter).click();
        driver.findElement(jeansFilter).click();

        //kids
        driver.findElement(kidsFilter).click();
        driver.findElement(kidsDressFilter).click();

        driver.findElement(kidsFilter).click();
        driver.findElement(kidsTopsAndShirts).click();

        //brands checking from their availability
        driver.findElement(firstBrandFilter).click();
        driver.findElement(secondBrandFilter).click();
        driver.findElement(thirdBrandFilter).click();
        driver.findElement(fourthBrandFilter).click();
        driver.findElement(fifthBrandFilter).click();
        driver.findElement(sixthBrandFilter).click();
        driver.findElement(seventhBrandFilter).click();
        driver.findElement(eighthBrandFilter).click();


    }
}
