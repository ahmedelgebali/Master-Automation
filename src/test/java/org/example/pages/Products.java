package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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








    // Add products to cart and filter
    public void addItemsToCartAndFilter() throws InterruptedException {
        navigateToProductsPage();
        this.addItemsToCart(new By[] {firstItemPath, secondItemPath, thirdItemPath});
        applyFilter();
        applyBrandFilter();
    }


    // navigate to products page
    public void navigateToProductsPage(){
        driver.findElement(By.xpath("//a[@href='/products']")).click(); //navigate to Products page
        js.executeScript("window.scrollBy(0, 100);");
    }

    // Add multiple items to the cart
    public void addItemsToCart(By[] itemPaths){
        for (By itemPath : itemPaths){
            driver.findElement(itemPath).click();
            waitFor(continueBtn);
            driver.findElement(continueBtn).click();
        }
    }

    // wait for the btn 2b clickable and then click on it
    public void waitFor(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // apply filter
    public void applyFilter(){
        //women's filters
        clickFilter(womenFilter, dressFilter);
        clickFilter(womenFilter, topsFilter);
        clickFilter(womenFilter, sareeFilter);

        //men's filters
        clickFilter(menFilter, tshirtsFilter);
        clickFilter(menFilter, jeansFilter);

        //kids' filters
        clickFilter(kidsFilter, kidsDressFilter);
        clickFilter(kidsFilter, kidsTopsAndShirts);
    }
    //click filter method
    public void clickFilter(By filter, By option){
        driver.findElement(filter).click();
        driver.findElement(option).click();
    }

    // apply brand filter
    public void applyBrandFilter(){
        clickBrandFilter(firstBrandFilter);
        clickBrandFilter(secondBrandFilter);
        clickBrandFilter(thirdBrandFilter);
        clickBrandFilter(fourthBrandFilter);
        clickBrandFilter(fifthBrandFilter);
        clickBrandFilter(sixthBrandFilter);
        clickBrandFilter(seventhBrandFilter);
        clickBrandFilter(eighthBrandFilter);
    }

    // brand filter
    public void clickBrandFilter(By brandFilter){
        driver.findElement(brandFilter).click();
    }
}
