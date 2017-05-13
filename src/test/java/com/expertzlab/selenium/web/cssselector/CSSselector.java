package com.expertzlab.selenium.web.cssselector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * Created by gireeshbabu on 13/05/17.
 */
public class CSSselector {


        private void searchForDivText(final String searchString){

            System.setProperty("webdriver.gecko.driver","/Users/gireeshbabu/workspace/tools/geckodriver");
            WebDriver driver = new FirefoxDriver();
            driver.get("http://localhost:8082/frame.html");

            WebElement divElement = driver.findElement(By.cssSelector("div#first-para"));

            System.out.println("The div contnet is: " + divElement.getText());


            (new WebDriverWait(driver,60,100)).until(
                    new ExpectedCondition<Boolean>() {
                        public Boolean apply(WebDriver driverObject){
                            return driverObject.getTitle().toLowerCase()
                                    .startsWith(searchString.toLowerCase());
                        }
                    }
            );

            driver.quit();
        }

        @Test
        public void gogleCheeseExample(){
            searchForDivText("Expertzlab");
        }
    }
