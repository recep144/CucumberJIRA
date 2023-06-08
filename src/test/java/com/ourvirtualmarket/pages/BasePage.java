package com.ourvirtualmarket.pages;

import com.ourvirtualmarket.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//a[text()='Login ']")
    public WebElement loginButton;

    @FindBy(xpath = "//a[text()=' Logout ']")
    public WebElement logoutButton;


}
