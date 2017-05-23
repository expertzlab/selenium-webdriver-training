package com.expertzlab.drapndrop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by gireeshbabu on 13/05/17.
 */
public class ClickAndHold {

    @Test
    public void clicknHold() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/gireeshbabu/workspace/tools/chromedriver");
        //WebDriver driver = new FirefoxDriver();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://jqueryui.com/droppable/#default");
        driver.manage().window().maximize();

        Actions act = new Actions(driver);

        // Script for dragging an element and dropping it in another place
        WebElement iFrame = driver.findElement(By.tagName("iframe"));
        System.out.println(iFrame.getSize());
        driver.switchTo().frame(iFrame);

        WebElement From = driver.findElement(By.id("draggable"));
        System.out.println(From.getLocation());

        WebElement To = driver.findElement(By.id("droppable"));
        System.out.println(To.getLocation());

        act.moveToElement(From)
                .clickAndHold()
                .moveToElement(To)
                .moveByOffset(100,100)
                .perform();


    }
}
