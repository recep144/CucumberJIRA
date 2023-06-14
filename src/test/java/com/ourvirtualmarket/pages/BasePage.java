package com.ourvirtualmarket.pages;

import com.ourvirtualmarket.utilities.BrowserUtils;
import com.ourvirtualmarket.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//a[text()='Login ']")
    public WebElement loginButton;

    @FindBy(xpath = "//a[text()=' Logout ']")
    public WebElement logoutButton;

    public void shoppingCartListControlOnBasePage(List<String> expectedProductList) {
        List<String> actualProductList = new ArrayList();
        int rowSize = getNumberOfRowsOnBasePage();
        for (int i = 1; i <= rowSize; i++) {
            actualProductList.add(getRowAndColumnNumbersThatIsGıvenOnBasePage(i, 2).getText());
        }
        System.out.println("actualProductList = " + actualProductList);
        System.out.println("expectedProductList = " + expectedProductList);
        Assert.assertEquals(expectedProductList, actualProductList);

    }

    private WebElement getRowAndColumnNumbersThatIsGıvenOnBasePage(int row, int column) {
        return Driver.get().findElement(By.xpath("" +
                "(//div[@id='cart']//tbody/tr)[" + row + "]/td[" + column + "]"));

    }

    private int getNumberOfRowsOnBasePage() {
        List<WebElement> allRollsWithoutHeader = Driver.get().findElements(By.xpath("" +
                "//div[@id='cart']//tbody/tr"));
        int numberOfRows = allRollsWithoutHeader.size();
        return numberOfRows;
    }

    private WebElement deleteButtonOnTheBasePage(int row, int column) {
        return Driver.get().findElement(By.xpath("" +
                "(//div[@id='cart']//tbody/tr)[" + row + "]/td[" + column + "]//i"));
    }

    public void deleteSelectedProductInTheBasePage() {
        int rowSize = getNumberOfRowsOnBasePage();
        for (int i = 1; i <= rowSize; i++) {
            if (rowSize >= 0) {
                BrowserUtils.waitFor(1);
                deleteButtonOnTheBasePage(1, 5).click();
                BrowserUtils.waitFor(1);
                CartProductsPage.addedItemNumber--;
            } else {
                break;
            }
        }

    }



}
