package com.ourvirtualmarket.pages;

import com.ourvirtualmarket.utilities.BrowserUtils;
import com.ourvirtualmarket.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage extends BasePage {

    @FindBy(xpath = "//div[@class='container']/div/span")
    public WebElement allCategoryButton;
    @FindBy(xpath = "//i[@class='fa fa-retweet']")
    public WebElement addToCompareType;
    @FindBy(xpath = "//div[contains(text(),'Success: You have added ')]")
    public WebElement messageSuccess;
    @FindBy(xpath = "//a[@class='top-link-compare']/i")
    public WebElement compareType;


    public void selectTheCategories(String category) {
        WebElement product = Driver.get().findElement(By.xpath("//span/strong[text()=" +
                "'" + category + "']"));
        BrowserUtils.hover(allCategoryButton);
        BrowserUtils.clickWithJS(product);
    }

    public void selectedProduct(String productName){
        WebElement product = Driver.get().findElement(By.xpath("//div[@class='products-list row" +
                " nopadding-xs so-filter-gird']//a[contains(text(),'"+productName+"')]"));
        BrowserUtils.clickWithJS(product);
    }
    public void clickAddToCompareType(){
        BrowserUtils.clickWithJS(addToCompareType);

    }
    public void compareTypeInTheProductPage(){
        BrowserUtils.clickWithJS(compareType);
    }







}
