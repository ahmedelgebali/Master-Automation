package practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class dependencies {
    SoftAssert softAssert;
    String actual1 = "0";
    String actual2 = "y";
    String actual3 = "y";
    String actual4 = "y";


    //soft assertions
    @Test (dependsOnMethods = "test2")
    void test1(){
        softAssert = new SoftAssert();
        String expected = "0";
        System.out.println("test 1 --> "+expected);
        softAssert.assertEquals(actual1, expected);
        System.out.println("an operator after assertion.. ");
    }
    @Test (dependsOnMethods = "test3")
    void test2(){
        softAssert = new SoftAssert();
        String expected = "y";
        System.out.println("test 2 --> " +expected);
        softAssert.assertEquals(actual2, expected);
        System.out.println("an operator after assertion.. ");

    }
    @Test (dependsOnMethods = "test4")
    void test3(){
        softAssert = new SoftAssert();
        String expected = "y";
        System.out.println("test 3 --> " +expected);
        softAssert.assertEquals(actual3, expected);
        System.out.println("an operator after assertion.. ");

    }
    @Test ()
    void test4(){
        softAssert = new SoftAssert();
        String expected = "y";
        System.out.println("test 4 --> " +expected);
        softAssert.assertEquals(actual4, expected);
        System.out.println("an operator after assertion.. ");

    }

}
