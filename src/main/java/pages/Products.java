package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
    public By firstItemPath = By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[1]");
    public By secondItemPath = By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[3]");
    public By thirdItemPath = By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[5]");
    public By fourthItemPath = By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[7]");
    public By fifthItemPath = By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[11]");
    public By sixthItemPath = By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[13]");
    public By seventhItemPath = By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[15]");
    public By ninthItemPath = By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[17]");
    public By tenthItemPath = By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[19]");
    public By fifteenthItemPath = By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[29]");
    public By sixteenthItemPath = By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[31]");

    // continue shopping btn
    public By continueBtn = By.xpath("//button[@class='btn btn-success close-modal btn-block']");
    //view cart btn
    public By viewCartBtn = By.xpath("//u[normalize-space()='View Cart']");

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


    public List<String> getItemNames() {
        return Arrays.asList(
                extractText(firstItemPath),
                extractText(secondItemPath),
                extractText(secondItemPath)
        );
    }

    public String extractText (By itemPath) {
        WebElement itemElement = driver.findElement(itemPath);
        return itemElement.getText();
    }

}

