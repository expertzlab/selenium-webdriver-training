package com.expertzlab.selenium.web;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

/**
 * Created by gireeshbabu on 01/05/17.
 */
public class WaitUntilAngularProcess {

    @Test
    public void waitUntilAngularProcess(){

        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.gofreelab.com");

        (new WebDriverWait(driver,60)).until(
                angularHasFinishedProcessing()
        );
        System.out.println("Page title is: " + driver.getTitle());
        driver.quit();
    }

    public static ExpectedCondition<Boolean> angularHasFinishedProcessing(){
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                return Boolean.valueOf(((JavascriptExecutor) webDriver).executeScript(
                        "return (window.angular !== undefined) " +
                                "&& (angular.element(document).injector !== undefined)"+
                                " && (angular.element(document).injector().get('$http').pendingRequests.length === 0)").toString()
                );
            }
        };
    }
}
