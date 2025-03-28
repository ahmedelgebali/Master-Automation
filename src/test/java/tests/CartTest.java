package tests;
public class CartTest extends BaseTest {
  /*
    SoftAssert softAssert = new SoftAssert();

    private String  theTendedItemNumber = "1";
    private String numOfQuantityNeeded = "10";
    private Cart cart;
    Products product;



    @Test(priority = 3, dependsOnMethods = "navigateToCart")
    public void performActionOnItems() {
        navigateToProductDetails();
        changeQuantity(numOfQuantityNeeded);
        verifyQuantityChange();
        validateItemPrice();
        validateTotalPrice();
    }



    //helper methods

    public void navigateToProductDetails() {
        try {
            // Ensure itemPaths is initialized and not empty
            if (itemPaths == null || itemPaths.isEmpty()) {
                throw new IllegalStateException("Item paths list is empty. Ensure addItemsToCartFromProductsPage was called successfully.");
            }

            // Navigate to the first product's details page
            String firstItemPath = itemPaths.get(0);
            System.out.println("Navigating to product details for item path: " + firstItemPath);
            cart.clickProduct(firstItemPath);

            // Wait for the product details page to load (add explicit wait if necessary)
            By quantityPath = cart.getItemQuantityLocator(theTendedItemNumber); // Get the quantity locator for the intended item
            boolean isElementPresent = driver.findElements(quantityPath).size() > 0;

            if (isElementPresent) {
                // Retrieve quantity and perform assertions
                String quantity = driver.findElement(quantityPath).getText();
                System.out.println("Quantity displayed on product details page: " + quantity);
                softAssert.assertTrue(true, "Quantity field is displayed on the product details page.");
            } else {
                // Log and handle when the quantity field is missing
                System.err.println("Quantity field not found for item number: " + theTendedItemNumber);
                softAssert.fail("Quantity field is missing on the product details page.");
            }
        } catch (Exception e) {
            // Catch unexpected errors and handle them
            System.err.println("Error while navigating to product details: " + e.getMessage());
            e.printStackTrace();
            softAssert.fail("Failed to navigate to product details due to an exception.");
        }
    }



//    public void navigateToProductDetails() {
//        // navigate to product details page
//        cart.clickProduct(itemPaths.getFirst());
//        By quantityPath = cart.getItemQuantityLocator(theTendedItemNumber); //get quantity path
//        String quantity = driver.findElement(quantityPath).getText();
//        System.out.println("Quantity: " + quantity);
//        softAssert.assertTrue(true);
//    }

    public void changeQuantity(String quantity) {
        // change the quantity of the item in the cart
        cart.changeQuantity(quantity);
        driver.navigate().back();
        driver.navigate().refresh();
    }

public void verifyQuantityChange() {
        // verify the quantity change was successful
        By quantityPath = cart.getItemQuantityLocator(theTendedItemNumber);
        String quantity = driver.findElement(quantityPath).getText();
        System.out.println("Quantity after change: " + quantity);
        softAssert.assertEquals(quantity, "11", "Item quantity should be updated");
    }

    public void validateItemPrice() {
        // Validate the item price
        By itemPrice = cart.getItemPriceLocator(theTendedItemNumber);
        String price = driver.findElement(itemPrice).getText();
        softAssert.assertNotNull(itemPrice, "Item price should not be null");
        System.out.println("Item price: " + price);
    }

    public void validateTotalPrice() {
        // Validate the total price
        By totalPrice = cart.getItemTotalPriceLocator(theTendedItemNumber);
        softAssert.assertNotNull(totalPrice, "Total price should not be null.");
    }


   */
}
