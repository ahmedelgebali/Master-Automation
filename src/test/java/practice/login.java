package practice;

import org.testng.annotations.Test;

public class login {

    @Test(priority = 1, groups = "sanity")
    void loginWithGoogle(){
        System.out.println("this is login with google method");
    }
    @Test(priority = 3, groups = "smoke")
    void loginWithFacebook(){
        System.out.println("this is login with facebook method");
    }
    @Test(priority = 2, groups = "sanity")
    void loginWithIcloud(){
        System.out.println("this is login with icloud method");
    }
    @Test(priority = 4, groups = "smoke")
    void loginWithTwitter(){
        System.out.println("this is login with twitter method");
    }

    @Test(priority = 5,dependsOnMethods = "loginWithGoogle", groups = "sanity")
    void openApp(){
        System.out.println("this is openApp method");
    }
    @Test(priority = 6,dependsOnGroups = "sanity", groups = "regression")
    void search(){
        System.out.println("this is search method");
    }
    @Test(priority = 7, dependsOnMethods = "search",groups = "regression")
    void advSearch(){
        System.out.println("this is advSearch method");
    }
}
