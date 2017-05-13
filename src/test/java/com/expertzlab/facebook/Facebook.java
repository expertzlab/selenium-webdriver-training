package com.expertzlab.facebook;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by gireeshbabu on 13/05/17.
 */
public class Facebook {

    By userNameLocator = By.id("email");
    By passLocator = By.id("pass");
    By loginBtnLocator = By.cssSelector("input[value^='Log']");
    By postBox = By.id("composer_text_input_box");

    @Test
    public void gotoLoginFaceBook(){
        System.setProperty("webdriver.chrome.driver","/Users/gireeshbabu/workspace/tools/chromedriver");
        //WebDriver driver = new FirefoxDriver();
        WebDriver driver = new ChromeDriver();
        driver.get("https://facebook.com");

        setValueAs(driver, userNameLocator, "7907516512");
        setValueAs(driver, passLocator, "test@1234");

        WebElement loginBtn = driver.findElement(loginBtnLocator);
        loginBtn.click();

        (new WebDriverWait(driver,60,100)).until(
                new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driverObject){
                        return driverObject.getTitle().toLowerCase()
                                .startsWith("".toLowerCase());
                    }
                }
        );


    }

    private void setValueAs(WebDriver driver, By userNameLocator, String s) {
        WebElement email = driver.findElement(userNameLocator);
        email.sendKeys(s);
    }
}
