package com.ourvirtualmarket.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage{
    @FindBy(xpath = "//p[contains(.,'safe')]")
    public WebElement firstText;

    @FindBy(xpath = "//p[contains(.,'restored')]")
    public WebElement secondText;
}
