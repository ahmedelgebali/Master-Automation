package practice;

import org.testng.annotations.Test;

public class signup {
    
    @Test(priority = 1, groups = {"sanity", "smoke"})
    void signupWithGoogle(){
        System.out.println("this is signup with google method");
    }
    @Test(priority = 3, groups = "regression")
    void signupWithFacebook(){
        System.out.println("this is signup with facebook method");
    }
    @Test(priority = 2, groups = {"regression","smoke"})
    void signupWithIcloud(){
        System.out.println("this is signup with icloud method");
    }
    @Test(priority = 4, groups = {"regression", "smoke"})
    void signupWithTwitter(){
        System.out.println("this is signup with twitter method");
    }
    @Test(priority = 5, dependsOnGroups = {"regression", "smoke"})
    void openAppAfterSignup(){
        System.out.println("this is openAppAfterSignup method");
    }
}
