package com.expertzlab.selenium.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * Created by gireesh on 03-04-2017.
 */
public class BasicTest {

    private void googleExampleThatSearchesFor(final String searchString){

        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.google.com");

        WebElement searchField = driver.findElement(By.name("q"));
        searchField.clear();
        searchField.sendKeys(searchString);
        searchField.submit();
        System.out.println("First Page title is: " + driver.getTitle());


        (new WebDriverWait(driver,60,100)).until(
                new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driverObject){
                        return driverObject.getTitle().toLowerCase()
                                .startsWith(searchString.toLowerCase());
                    }
                }
        );


        System.out.println("Second Page title is: " +driver.getTitle());
        driver.quit();
    }

    @Test
    public void gogleCheeseExample(){
        googleExampleThatSearchesFor("kochi spring training!");
    }
}
