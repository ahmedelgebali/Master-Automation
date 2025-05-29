package pages;

import org.openqa.selenium.By;

public class ProductsLocators {

    // items to add to cart
    public static final By itemPath1 = By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[1]");
    public static final By itemPath2 = By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[3]");
    public static final By itemPath3 = By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[5]");
    public static final By itemPath4 = By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[7]");
    public static final By itemPath5 = By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[11]");
    public static final By itemPath6 = By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[13]");
    public static final By itemPath7 = By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[15]");
    public static final By itemPath9 = By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[17]");
    public static final By itemPath10 = By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[19]");
    public static final By itemPath15 = By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[29]");
    public static final By itemPath16 = By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[31]");
    public static final By lastItemPath = By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[67]");

    // continue shopping btn
    public static final By continueBtn = By.xpath("//button[@class='btn btn-success close-modal btn-block']");

    // view product details
    public static final By itemDetails1 = By.cssSelector("a[href='/product_details/1']");
    public static final By itemDetails2 = By.cssSelector("a[href='/product_details/2']");
    public static final By itemDetails3 = By.cssSelector("a[href='/product_details/3']");
    public static final By itemDetails4 = By.cssSelector("a[href='/product_details/4']");
    public static final By itemDetails5 = By.cssSelector("a[href='/product_details/5']");
    public static final By itemDetails6 = By.cssSelector("a[href='/product_details/6']");
    public static final By itemDetails7 = By.cssSelector("a[href='/product_details/7']");
    public static final By itemDetails8 = By.cssSelector("a[href='/product_details/8']");
    public static final By itemDetails9 = By.cssSelector("a[href='/product_details/11']");
    public static final By itemDetails10 = By.cssSelector("a[href='/product_details/12']");
    public static final By itemDetails11 = By.cssSelector("a[href='/product_details/13']");
    public static final By itemDetails12 = By.cssSelector("a[href='/product_details/14']");
    public static final By itemDetails13 = By.cssSelector("a[href='/product_details/15']");
    public static final By itemDetails14 = By.cssSelector("a[href='/product_details/16']");
    public static final By itemDetails15 = By.cssSelector("a[href='/product_details/18']");
    public static final By itemDetails16 = By.cssSelector("a[href='/product_details/19']");
    public static final By itemDetails17 = By.cssSelector("a[href='/product_details/20']");
    public static final By itemDetails18 = By.cssSelector("a[href='/product_details/21']");
    public static final By itemDetails19 = By.cssSelector("a[href='/product_details/22']");
    public static final By itemDetails20 = By.cssSelector("a[href='/product_details/23']");
    public static final By itemDetails21 = By.cssSelector("a[href='/product_details/24']");

    // Women
    public static final By womenFilter = By.xpath("//a[normalize-space()='Women']//i[@class='fa fa-plus']");
    public static final By dressFilter = By.xpath("//div[@id='Women']//a[contains(text(),'Dress')]");
    public static final By topsFilter = By.xpath("//a[normalize-space()='Tops']");
    public static final By sareeFilter = By.xpath("//a[normalize-space()='Saree']");

    // Men
    public static final By menFilter = By.xpath("//a[normalize-space()='Men']//i[@class='fa fa-plus']");
    public static final By tshirtsFilter = By.xpath("//a[normalize-space()='Tshirts']");
    public static final By jeansFilter = By.xpath("//a[normalize-space()='Jeans']");

    // Kids
    public static final By kidsFilter = By.xpath("//a[normalize-space()='Kids']//i[@class='fa fa-plus']");
    public static final By kidsDressFilter = By.xpath("//div[@id='Kids']//a[contains(text(),'Dress')]");
    public static final By kidsTopsAndShirts = By.xpath("//a[normalize-space()='Tops & Shirts']");

    // Brands
    public static final By firstBrandFilter = By.xpath("//a[@href='/brand_products/Polo']");
    public static final By secondBrandFilter = By.xpath("//a[@href='/brand_products/H&M']");
    public static final By thirdBrandFilter = By.xpath("//a[@href='/brand_products/Madame']");
    public static final By fourthBrandFilter = By.xpath("//a[@href='/brand_products/Mast & Harbour']");
    public static final By fifthBrandFilter = By.xpath("//a[@href='/brand_products/Babyhug']");
    public static final By sixthBrandFilter = By.xpath("//a[@href='/brand_products/Allen Solly Junior']");
    public static final By seventhBrandFilter = By.xpath("//a[@href='/brand_products/Kookie Kids']");
    public static final By eighthBrandFilter = By.xpath("//a[@href='/brand_products/Biba']");
}
