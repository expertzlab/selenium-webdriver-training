package com.expertzlab.selenium.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by gireeshbabu on 01/05/17.
 */
public class PageLoadTimeoutEx {

    @Test
    public void pageLoadTimeoutTest(){
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.google.com");

        WebElement searchField = driver.findElement(By.name("q"));
        searchField.clear();
        searchField.sendKeys("cold virus");

        System.out.println("Page title is: " + driver.getTitle());
        searchField.submit();

        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.quit();
    }

}
