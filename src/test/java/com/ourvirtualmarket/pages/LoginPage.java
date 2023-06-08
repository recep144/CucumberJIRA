package com.ourvirtualmarket.pages;

import com.ourvirtualmarket.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{


    @FindBy(xpath = "//button[@title='Close']")
    public WebElement popoupClose;

@FindBy(css = "#email")
    public WebElement emailInputBox;

@FindBy(css = "#pass")
    public WebElement passwordInputBox;
@FindBy(css = "#send2")
    public WebElement login;

public void login(){
    emailInputBox.sendKeys(ConfigurationReader.get("email"));
    passwordInputBox.sendKeys(ConfigurationReader.get("password"));
    login.click();
}
}
