package com.expertzlab.facebook;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by gireeshbabu on 13/05/17.
 */
public class FacebookPageFactory {

    @FindBy(how = How.ID, using = "email")
    private WebElement userNameField;

    @FindBy(how = How.ID, using = "pass")
    private WebElement passwField;

    @FindBy(how = How.CSS, using = "input[value^='Log']")
    private WebElement logBtn;


    @Test
    public void gotoLoginFaceBook() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver","/Users/gireeshbabu/workspace/tools/chromedriver");
        System.setProperty("webdriver.gecko.driver","/Users/gireeshbabu/workspace/tools/geckodriver");
        WebDriver driver = new FirefoxDriver();
        //WebDriver driver = new ChromeDriver();
        driver.get("https://facebook.com");

        PageFactory.initElements(driver,this);
        userNameField.sendKeys("7907516512");
        passwField.sendKeys("test@1234");
        logBtn.click();

        Thread.sleep(15000);

        FaceBookHomePage homePage = new FaceBookHomePage(driver);
        homePage.gotoFriendListPage();
        Thread.sleep(15000);

        driver.quit();

    }

    private void waitUntilPageLoad(WebDriver driver) {
        (new WebDriverWait(driver,60,100)).until(
                new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driverObject){
                        return driverObject.getTitle().toLowerCase()
                                .startsWith("Facebook".toLowerCase());
                    }
                }
        );
    }
}
