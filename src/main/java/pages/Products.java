package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class Products extends Base{

    public Products(WebDriver driver) {
        super(driver);
    }
    // Constructor with Actions and JavascriptExecutor
    public Products(Actions actions, JavascriptExecutor js) {
        super(actions, js);
    }








    // Items LOCATOR to add to cart
    public By firstItemNamePath = By.xpath("(//div[@class='productinfo text-center'])[1]/p");
    public By firstItemPath = By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[1]");
    public By secondItemPath = By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[3]");
    public By thirdItemPath = By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[5]");



    // continue shopping btn's xpath
    public By continueBtn = By.xpath("//button[@class='btn btn-success close-modal btn-block']");
    //view cart btn
    public By viewCartBtn = By.xpath("//u[normalize-space()='View Cart']");

    //filter XPaths --> category
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

    //filter XPaths --> Brands
            public By firstBrandFilter = By.xpath("//a[@href='/brand_products/Polo']");
            public By secondBrandFilter = By.xpath("//a[@href='/brand_products/H&M']");
            public By thirdBrandFilter = By.xpath("//a[@href='/brand_products/Madame']");
            public By fourthBrandFilter = By.xpath("//a[@href='/brand_products/Mast & Harbour']");
            public By fifthBrandFilter = By.xpath("//a[@href='/brand_products/Babyhug']");
            public By sixthBrandFilter = By.xpath("//a[@href='/brand_products/Allen Solly Junior']");
            public By seventhBrandFilter = By.xpath("//a[@href='/brand_products/Kookie Kids']");
            public By eighthBrandFilter = By.xpath("//a[@href='/brand_products/Biba']");





// Add products to cart and filter

    // navigate to products page
    public void navigateToProductsPage(){
        driver.findElement(By.xpath("//a[@href='/products']")).click(); //navigate to Products page
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

        // transfer controlling into Cart Page
        new Cart(driver);

    }
    // brand filter
    public void clickBrandFilter(By brandFilter){
        driver.findElement(brandFilter).click();
    }

}
