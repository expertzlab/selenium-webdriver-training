package com.expertzlab.selenium.web;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by gireesh on 03-04-2017.
 */
public class GetElementTest {

    private void googleExampleThatSearchesFor(final String searchString) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8081/frame.html");

        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

        //WebElement divElement = driver.findElement(By.cssSelector("first-para"));
        WebElement divElement = driver.findElement(By.className("first-para"));
        String value = divElement.getText();
        System.out.println("Element value ="+ value);
        Assert.assertEquals(value,"This is from Expertzlab");

        ((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = arguments[1]", divElement, "Welcome to Exepertzlab");

        /*

        (new WebDriverWait(driver,60)).until(
                new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driverObject){
                        return driverObject.getTitle().toLowerCase()
                                .startsWith(searchString.toLowerCase());
                    }
                }
        );
        */

        WebElement linkText = driver.findElement(By.linkText("Go to Google"));
        linkText.click();

        Thread.sleep(5000);

        System.out.println("Second Page title is: " +driver.getTitle());
        driver.quit();
    }

    @Test
    public void gogleCheeseExample() throws InterruptedException{
        googleExampleThatSearchesFor("Expertzlab - for programming courses");
    }
}
