package com.expertzlab.selenium.web;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by gireesh on 03-04-2017.
 */
public class BasicTest {

    private void googleExampleThatSearchesFor(final String searchString){

        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.google.com");

        //((JavascriptExecutor) driver).executeScript("alert('Hello');");
        driver.manage().timeouts().setScriptTimeout(50,TimeUnit.SECONDS);
        ((JavascriptExecutor) driver).executeScript("window.onload = function() {alert('Hello')}");
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.clear();
        searchField.sendKeys(searchString);

        System.out.println("Page title is: " + driver.getTitle());
        searchField.submit();

        (new WebDriverWait(driver,120)).until(
                new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driverObject){
                        return driverObject.getTitle().toLowerCase()
                                .startsWith(searchString.toLowerCase());
                    }
                }
        );
        System.out.println("Page title is: " +driver.getTitle());
        driver.quit();
    }

    @Test
    public void gogleCheeseExample(){
        googleExampleThatSearchesFor("Cheese!");
    }
}
