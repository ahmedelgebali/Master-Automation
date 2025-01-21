package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Arrays;
import java.util.List;

public class Products extends Base{
    public Products(WebDriver driver) {
        super(driver);
    }
    public Products(Actions actions, JavascriptExecutor js) {
        super(actions, js);
    }


// <--------------------------> Locators <-------------------------->
    // items to add to cart
    //public By firstItemNamePath = By.xpath("(//div[@class='productinfo text-center'])[1]/p");
    public By itemPath1 = By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[1]");
    public By itemPath2 = By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[3]");
    public By thirdItemPath = By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[5]");
    public By fourthItemPath = By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[7]");
    public By fifthItemPath = By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[11]");
    public By sixthItemPath = By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[13]");
    public By seventhItemPath = By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[15]");
    public By ninthItemPath = By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[17]");
    public By tenthItemPath = By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[19]");
    public By fifteenthItemPath = By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[29]");
    public By sixteenthItemPath = By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[31]");
    public By lasteItemPath = By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[67]");

    // continue shopping btn
    public By continueBtn = By.xpath("//button[@class='btn btn-success close-modal btn-block']");
    //view cart btn
    public By viewCartBtn = By.xpath("//u[normalize-space()='View Cart']");


    // view product details
    public By itemDetails1 = By.cssSelector("a[href='/product_details/1']");
    public By itemDetails2 = By.cssSelector("a[href='/product_details/2']");
    public By itemDetails3 = By.cssSelector("a[href='/product_details/3']");
    public By itemDetails4 = By.cssSelector("a[href='/product_details/4']");
    public By itemDetails5 = By.cssSelector("a[href='/product_details/5']");
    public By itemDetails6 = By.cssSelector("a[href='/product_details/6']");
    public By itemDetails7 = By.cssSelector("a[href='/product_details/7']");
    public By itemDetails8 = By.cssSelector("a[href='/product_details/8']");
    public By itemDetails9 = By.cssSelector("a[href='/product_details/11']");
    public By itemDetails10 = By.cssSelector("a[href='/product_details/12']");
    public By itemDetails11 = By.cssSelector("a[href='/product_details/13']");
    public By itemDetails12 = By.cssSelector("a[href='/product_details/14']");
    public By itemDetails13 = By.cssSelector("a[href='/product_details/15']");
    public By itemDetails14 = By.cssSelector("a[href='/product_details/16']");
    public By itemDetails15 = By.cssSelector("a[href='/product_details/18']");
    public By itemDetails16 = By.cssSelector("a[href='/product_details/19']");
    public By itemDetails17 = By.cssSelector("a[href='/product_details/20']");
    public By itemDetails18 = By.cssSelector("a[href='/product_details/21']");
    public By itemDetails19 = By.cssSelector("a[href='/product_details/22']");
    public By itemDetails20 = By.cssSelector("a[href='/product_details/23']");
    public By itemDetails21 = By.cssSelector("a[href='/product_details/24']");


    //filter locators --> category
            //WOMEN
                public By womenFilter = By.xpath("//a[normalize-space()='Women']//i[@class='fa fa-plus']");
                public By dressFilter = By.xpath("//div[@id='Women']//a[contains(text(),'Dress')]");
                public By topsFilter = By.xpath("//a[normalize-space()='Tops']");
                public By sareeFilter = By.xpath("//a[normalize-space()='Saree']");

            //MEN
                public By menFilter = By.xpath("//a[normalize-space()='Men']//i[@class='fa fa-plus']");
                public By tshirtsFilter = By.xpath("//a[normalize-space()='Tshirts']");
                public By jeansFilter = By.xpath("//a[normalize-space()='Jeans']");

            //KIDS
                public By kidsFilter = By.xpath("//a[normalize-space()='Kids']//i[@class='fa fa-plus']");
                public By kidsDressFilter = By.xpath("//div[@id='Kids']//a[contains(text(),'Dress')]");
                public By kidsTopsAndShirts = By.xpath("//a[normalize-space()='Tops & Shirts']");

    //filter locators --> Brands
            public By firstBrandFilter = By.xpath("//a[@href='/brand_products/Polo']");
            public By secondBrandFilter = By.xpath("//a[@href='/brand_products/H&M']");
            public By thirdBrandFilter = By.xpath("//a[@href='/brand_products/Madame']");
            public By fourthBrandFilter = By.xpath("//a[@href='/brand_products/Mast & Harbour']");
            public By fifthBrandFilter = By.xpath("//a[@href='/brand_products/Babyhug']");
            public By sixthBrandFilter = By.xpath("//a[@href='/brand_products/Allen Solly Junior']");
            public By seventhBrandFilter = By.xpath("//a[@href='/brand_products/Kookie Kids']");
            public By eighthBrandFilter = By.xpath("//a[@href='/brand_products/Biba']");





// <--------------------------> Actions methods  <-------------------------->
    // navigate to products page
    public void navigateToProductsPage(){
        driver.findElement(By.xpath("//a[@href='/products']")).click(); //navigate to Products page
        waitForElementToBeClickable(By.xpath("//a[@href='/products']"));
        js.executeScript("window.scrollBy(0, 100);");
    }

    // Add multiple items to the cart
    public void addItemsToCart(By[] itemPaths) {
        for (By itemPath : itemPaths) {
            try {
                // Wait for the item to be clickable and click it
                waitForElementToBeClickable(itemPath);
                driver.findElement(itemPath).click();

                // Wait for the continue button and click it
                waitForElementToBeClickable(continueBtn);
                driver.findElement(continueBtn).click();
            } catch (Exception e) {
                System.err.println("Error adding item to cart: " + itemPath);
                e.printStackTrace();
            }
        }
    }
    public void viewItemDetails(By[] itemPaths) {
        for (By itemPath : itemPaths) {
            try {
                // Wait for the item to be clickable and click it
                waitForElementToBeClickable(itemPath);
                driver.findElement(itemPath).click();
                Thread.sleep(1000);
                driver.navigate().back();
            } catch (Exception e) {
                System.err.println("Error viewing item details: " + itemPath);
                e.printStackTrace();
            }
        }
    }


    // apply filter
    public void womenFilter() {
        //women's filters
        clickFilter(womenFilter, dressFilter);
        scrollBy(0,200);
        clickFilter(womenFilter, topsFilter);
        scrollBy(0,400);
        clickFilter(womenFilter, sareeFilter);
        scrollBy(0,600);
    }

    //men's filters
    public void menFilter() {
            clickFilter(menFilter, tshirtsFilter);
            scrollBy(0,200);
            clickFilter(menFilter, jeansFilter);
            scrollBy(0,400);
        }

    //kids' filters
    public void kidsFilter(){
        clickFilter(kidsFilter, kidsDressFilter);
        scrollBy(0,200);
        clickFilter(kidsFilter, kidsTopsAndShirts);
        scrollBy(0,400);
    }

    //click filter method , helper methode
    public void clickFilter(By filter, By option){
        waitForElementToBeClickable(filter);
        driver.findElement(filter).click();
        waitForElementToBeClickable(option);
        driver.findElement(option).click();
    }



    // apply brand filter
    public void applyBrandFilter(){
        clickBrandFilter(firstBrandFilter);
        scrollBy(0,200);
        clickBrandFilter(secondBrandFilter);
        scrollBy(0,200);
        clickBrandFilter(thirdBrandFilter);
        scrollBy(0,200);
        clickBrandFilter(fourthBrandFilter);
        scrollBy(0,200);
        clickBrandFilter(fifthBrandFilter);
        scrollBy(0,200);
        clickBrandFilter(sixthBrandFilter);
        scrollBy(0,200);
        clickBrandFilter(seventhBrandFilter);
        scrollBy(0,200);
        clickBrandFilter(eighthBrandFilter);
        scrollBy(0,200);

        // transfer controlling into Cart Page
        new Cart(driver);

    }

    // brand filter
    public void clickBrandFilter(By brandFilter){
        driver.findElement(brandFilter).click();
    }


}

