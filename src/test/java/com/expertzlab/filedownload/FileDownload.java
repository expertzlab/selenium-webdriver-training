package com.expertzlab.filedownload;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by gireeshbabu on 24/05/17.
 */
public class FileDownload {

    @BeforeTest
    public void setup() throws URISyntaxException {
        File file = new File(new URI("file:///Users/gireeshbabu/Desktop/workbook.xlsx"));
        file.delete();
    }

    public FirefoxProfile getFirefoxProfile() {
        // Changing default file downloading location  path using the FirefoxProfile.setpreference method.
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("browser.download.folderList", 0);
        firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
        firefoxProfile.setPreference("browser.download.dir", "Users/gireshbabu/workspace/work");
        //path = [location to save the downloaded files]
        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        // if you want to excel file means - 'application/vnd.ms-excel', or CSV means - 'text/csv'
        //firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","text/csv");
        return firefoxProfile;
    }

    @Test
    public void downloadFile() throws URISyntaxException, IOException {
        System.setProperty("webdriver.gecko.driver","/Users/gireeshbabu/workspace/tools/geckodriver");
        WebDriver wd = new FirefoxDriver(getFirefoxProfile());
        try {
            wd.get("http://localhost/index.html");
            wd.findElement(By.id("downloadLink")).click();
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Firefox Browser not available or Root url unavailable");
        }

        File file = new File(new URI("file:///Users/gireeshbabu/Desktop/workbook.xlsx"));
        FileInputStream fis = new FileInputStream(file);
        Assert.assertTrue(fis.read() > 0);

    }
}

