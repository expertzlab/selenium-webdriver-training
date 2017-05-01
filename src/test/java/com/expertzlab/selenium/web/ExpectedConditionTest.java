package com.expertzlab.selenium.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * Created by gireeshbabu on 01/05/17.
 */
public class ExpectedConditionTest {

    @Test
    public void expectedConditionsTest(){
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.gofreelab.com");

        (new WebDriverWait(driver,60)).until(
                ExpectedConditions.visibilityOfElementLocated(By.id("container"))
        );
        System.out.println("Page title is: " + driver.getTitle());
        driver.quit();

    }
}
