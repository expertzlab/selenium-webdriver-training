package com.expertzlab.facebook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import sun.jvm.hotspot.debugger.Page;

/**
 * Created by gireeshbabu on 13/05/17.
 */
public class FaceBookHomePage extends PageFactory {

    @FindBy(how = How.CSS, using = "a#findFriendsNav")
    private WebElement userNameField;

    public FaceBookHomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void gotoFriendListPage(){
        userNameField.click();
    }


}
