package com.expertzlab.selenium.web;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.Set;
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

        /*
        driver.manage().addCookie(new Cookie("session","abcd123"));

        Set<Cookie> cookieSet = driver.manage().getCookies();

        for(Cookie ck : cookieSet){
            System.out.println("Cookie Name -"+ ck.getName());
            System.out.println("Cookie Value -"+ ck.getValue());
        }
        */

        driver.manage().timeouts().setScriptTimeout(100, TimeUnit.SECONDS);
        ((JavascriptExecutor)driver).executeAsyncScript("console.log(\"The value of this filed\")");


        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        System.out.println("Page title is: " + driver.getTitle());
        driver.quit();
    }

}
