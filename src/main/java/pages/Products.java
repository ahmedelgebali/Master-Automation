package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Products extends Base {

    public Products(WebDriver driver) {
        super(driver);
    }

    public Products(Actions actions, JavascriptExecutor js) {
        super(actions, js);
    }

    // Navigate to products page
    public void navigateToProductsPage() {
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        waitForElementToBeClickable(By.xpath("//a[@href='/products']"));
        js.executeScript("window.scrollBy(0, 100);");
    }

    // Add multiple items to cart
    public void addItemsToCart(By[] itemPaths) {
        for (By itemPath : itemPaths) {
            try {
                waitForElementToBeClickable(itemPath);
                driver.findElement(itemPath).click();

                waitForElementToBeClickable(ProductsLocators.continueBtn);
                driver.findElement(ProductsLocators.continueBtn).click();
            } catch (Exception e) {
                System.err.println("Error adding item to cart: " + itemPath);
                e.printStackTrace();
            }
        }
    }

    // View item details
    public void viewItemDetails(By[] itemPaths) {
        for (By itemPath : itemPaths) {
            try {
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


    public void womenFilter() {
        clickFilter(ProductsLocators.womenFilter, ProductsLocators.dressFilter);
        scrollBy(0, 200);
        clickFilter(ProductsLocators.womenFilter, ProductsLocators.topsFilter);
        scrollBy(0, 400);
        clickFilter(ProductsLocators.womenFilter, ProductsLocators.sareeFilter);
        scrollBy(0, 600);
    }

    public void menFilter() {
        clickFilter(ProductsLocators.menFilter, ProductsLocators.tshirtsFilter);
        scrollBy(0, 200);
        clickFilter(ProductsLocators.menFilter, ProductsLocators.jeansFilter);
        scrollBy(0, 400);
    }

    public void kidsFilter() {
        clickFilter(ProductsLocators.kidsFilter, ProductsLocators.kidsDressFilter);
        scrollBy(0, 200);
        clickFilter(ProductsLocators.kidsFilter, ProductsLocators.kidsTopsAndShirts);
        scrollBy(0, 400);
    }

    public void applyBrandFilter() {
        clickBrandFilter(ProductsLocators.firstBrandFilter);
        scrollBy(0, 200);
        clickBrandFilter(ProductsLocators.secondBrandFilter);
        scrollBy(0, 200);
        clickBrandFilter(ProductsLocators.thirdBrandFilter);
        scrollBy(0, 200);
        clickBrandFilter(ProductsLocators.fourthBrandFilter);
        scrollBy(0, 200);
        clickBrandFilter(ProductsLocators.fifthBrandFilter);
        scrollBy(0, 200);
        clickBrandFilter(ProductsLocators.sixthBrandFilter);
        scrollBy(0, 200);
        clickBrandFilter(ProductsLocators.seventhBrandFilter);
        scrollBy(0, 200);
        clickBrandFilter(ProductsLocators.eighthBrandFilter);
        scrollBy(0, 200);

        new Cart(driver);
    }

    public void clickFilter(By filter, By option) {
        waitForElementToBeClickable(filter);
        driver.findElement(filter).click();
        waitForElementToBeClickable(option);
        driver.findElement(option).click();
    }

    public void clickBrandFilter(By brandFilter) {
        driver.findElement(brandFilter).click();
    }
}
