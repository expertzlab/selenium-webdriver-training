package com.expertzlab.testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

/**
 * Created by gireeshbabu on 03/05/17.
 */

public class CalculatorTest {

    Calculator calculator;

    @BeforeTest
    public void setup(){
        calculator = new Calculator();
    }

   @Test(priority = 20)
    public void sumCalculatorTest(){

       Assert.assertEquals( calculator.sum(2,4) , 6);
    }

    @Test(priority = 10)
    public void doubleCalculatorTest(){

      Assert.assertEquals( calculator.doubleNumber(5),10);
    }

}
