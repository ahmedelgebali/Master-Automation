package tests;
import Properties.PropReader;
import org.testng.annotations.*;
import pages.Products;
import org.openqa.selenium.By;
import java.io.IOException;

public class ProductsTest extends BaseTest {
    Products product;

    @BeforeClass
    public void setup() throws IOException {
        String url = PropReader.getProp("baseURL");
        setUp(url);
    }
    @AfterClass
    public void tear(){
        tearDown();
    }
    @BeforeMethod
    public void initializeProduct() {
        product = new Products(driver);
    }

    @Test(priority = 1)
    public void navigateToPage(){
        product.navigateToProductsPage();
    }

    @Test(priority = 2)
    public void addItemsToCart() {
        product.addItemsToCart(new By[] {product.itemPath1, product.itemPath2, product.itemPath3, product.itemPath4, product.itemPath5,
                product.itemPath6, product.itemPath7});
    }

    @Test(priority = 3)
    public void testWomenFilter(){
        product.womenFilter();
    }
    @Test(priority = 4)
    public void testMenFilter(){
        product.menFilter();
    }
    @Test(priority = 5)
    public void testKidsFilter(){
        product.kidsFilter();
    }
    @Test(priority = 6)
    public void applyBrandFilter(){
        product.applyBrandFilter();
        //note this methode pass the driver into Cart page once finished
    }


}
