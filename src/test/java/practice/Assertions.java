package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertions {

    SoftAssert softAssert;
    String actual1 = "0";
    String actual2 = "y";

   //soft assertions
   @Test
   void test3(){
       softAssert = new SoftAssert();
       String expected = "1";
       System.out.println("test 3 --> "+expected);
       softAssert.assertEquals(actual1, expected);
       System.out.println("an operator after assertion.. ");
   }
    @Test
    void test4(){
       softAssert = new SoftAssert();
        String expected = "y";
        System.out.println("test 4 --> " +expected);
        softAssert.assertEquals(actual2, expected);
        System.out.println("an operator after assertion.. ");

    }








    //hard assertions
//    @Test
    void test1(){
        String expected = "1";
        System.out.println("test 1 --> "+expected);
        Assert.assertEquals(actual1, expected);
        System.out.println("an operator after assertion.. ");
    }
//    @Test
    void test2(){
        String expected = "y";
        System.out.println("test 2 --> " +expected);
        Assert.assertEquals(actual2, expected);
        System.out.println("an operator after assertion.. ");

    }
}
