package practice;

import org.apache.poi.ss.formula.functions.T;
import org.testng.annotations.Test;

public class cart {
    @Test(dependsOnGroups = "sanity", groups = "functionality")
    void addItemToCart(){
        System.out.println("this is addItemToCart method");
    }
    @Test(dependsOnMethods = "addItemToCart", dependsOnGroups = "sanity", groups = "functionality")
    void removeItem(){
        System.out.println("this is removeItem method");
    }
    @Test( dependsOnMethods = {"addItemToCart", "removeItem"}, dependsOnGroups = "sanity", groups = "functionality")
    void reAddItemToCart(){
        System.out.println("this is reAddItemToCart method");
    }
    @Test(dependsOnMethods = {"addItemToCart" , "reAddItemToCart"}, dependsOnGroups = "sanity", groups = "functionality")
    void checkOut(){
        System.out.println("this is checkOut with icloud method");
    }
    @Test(dependsOnMethods = {"checkOut"}, dependsOnGroups = "sanity", groups = "functionality")
    void cancelOrder(){
        System.out.println("this is cancelOrder with twitter method");
    }

}

