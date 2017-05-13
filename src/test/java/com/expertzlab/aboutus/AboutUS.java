package com.expertzlab.aboutus;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by gireeshbabu on 12/05/17.
 */
public class AboutUS {

    @Test
    public void gotoAboutUsPage(){

        System.setProperty("webdriver.gecko.driver","/Users/gireeshbabu/workspace/tools/geckodriver");
        //Now you can Initialize marionette driver to launch firefox
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        WebDriver driver = new FirefoxDriver(capabilities);
        driver.get("https://icescrum.com");

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
               .withTimeout(15, TimeUnit.SECONDS)
               .pollingEvery(500, TimeUnit.MILLISECONDS)
               .ignoring(NoSuchElementException.class)
               .withMessage("Icescrum page not loaded");
        WebElement list = driver.findElement(By.id("menu-item-14609"));
        WebElement link = list.findElement(By.tagName("a"));
        link.click();

        WebElement header = driver.findElement(By.cssSelector(".col-md-offset-1.col-md-10.col-sm-12>h1"));
        WebElement h1 = header.findElement(By.tagName("h1"));
        //String text = header.getText();
        System.out.println("Text = "+header.getAttribute("class"));
        //Assert.assertEquals(text,"About us","The Heading About us does not exist");
    }
}
