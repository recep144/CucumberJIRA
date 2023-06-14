package com.ourvirtualmarket.pages;

import com.ourvirtualmarket.utilities.BrowserUtils;
import com.ourvirtualmarket.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CartProductsPage extends BasePage {

    public static int addedItemNumber = 0;
    @FindBy(xpath = "//div[@class='alert alert-success']")
    public WebElement successMessage;
    @FindBy(xpath = "//div[@class='alert alert-success']/button")
    public WebElement buttonForTheClosingSuccesMessage;
    @FindBy(xpath = "//i[@class='fa fa-shopping-bag']")
    public WebElement cartIcon;
    @FindBy(xpath = "//a[text()=' View Cart']")
    public WebElement viewCartButton;
    @FindBy(xpath = "//span[@class='items_cart']")
    public WebElement yourCartLink;
    @FindBy(xpath = "//a[@class='link-lg']")
    public WebElement loginOption;

    public void titleListControl(String product, List<String> expectedTitleList) {
        WebElement productName = Driver.get().findElement(By.xpath("//div[@class='products-list row" +
                " nopadding-xs so-filter-gird']//a[contains(text(),'" + product + "')]"));

        BrowserUtils.hover(productName);

        List<String> actualTitleNames = new ArrayList<>();

        for (int i = 1; i <= 4; i++) {
            WebElement title = Driver.get().findElement(By.xpath("(((//div[@class='products-list " +
                    "row nopadding-xs so-filter-gird']//a[contains(text(),'" + productName.getText() + "')])" +
                    "/../../../div/div/following-sibling::div/following-sibling::div/*)/span)[" + i + "]"));
            BrowserUtils.waitFor(1);
            BrowserUtils.hover(title);
            BrowserUtils.waitFor(1);
            actualTitleNames.add(title.getText());

        }
        System.out.println("actualTitleNames = " + actualTitleNames);
        System.out.println("expectedTitleList = " + expectedTitleList);
        Assert.assertEquals(expectedTitleList, actualTitleNames);
    }

    public void clickTheSelectedProduct(String product) {
        WebElement productName = Driver.get().findElement(By.xpath("//div[@class='products-list row" +
                " nopadding-xs so-filter-gird']//a[contains(text(),'" + product + "')]"));
        BrowserUtils.hover(productName);
        WebElement title = Driver.get().findElement(By.xpath("(((//div[@class='products-list " +
                "row nopadding-xs so-filter-gird']//a[contains(text(),'" + productName.getText() + "')])" +
                "/../../../div/div/following-sibling::div/following-sibling::div/*)/span)[1]"));
        BrowserUtils.waitFor(1);
        BrowserUtils.clickWithJS(title);
        addedItemNumber++;
    }

    public void messageOfTheSelectedProduct(String message) {
        String xButton = buttonForTheClosingSuccesMessage.getText();
        String fullMessage = successMessage.getText();
        fullMessage.trim();
        String actualMessage = fullMessage.replace(xButton, "");
        String expectedMessage = message;
        expectedMessage.trim();
        System.out.println("expectedMessage = " + expectedMessage);
        System.out.println("actualMessage = " + actualMessage);
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }


    public void clickToCartIcon() {
        BrowserUtils.hover(cartIcon);
        BrowserUtils.clickWithJS(viewCartButton);
    }

    public int getAddedItemNumber() {

        String addedItem = yourCartLink.getText();
        if (addedItem.length() == 0) return 0;
        return Integer.parseInt(addedItem);
    }


}
