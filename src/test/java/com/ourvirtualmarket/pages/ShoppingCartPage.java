package com.ourvirtualmarket.pages;

import com.ourvirtualmarket.utilities.BrowserUtils;
import com.ourvirtualmarket.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartPage extends BasePage {

    public void shoppingCartListControl(List<String> expectedProductList) {
        List<String> actualProductList = new ArrayList();
        int rowSize = getNumberOfRows();
        for (int i = 1; i <= rowSize; i++) {
            actualProductList.add(getRowAndColumnNumbersThatIsGıven(i, 2).getText());
        }
        System.out.println("actualProductList = " + actualProductList);
        System.out.println("expectedProductList = " + expectedProductList);
        Assert.assertEquals(expectedProductList, actualProductList);

    }

    private WebElement getRowAndColumnNumbersThatIsGıven(int row, int column) {
        return Driver.get().findElement(By.xpath("" +
                "(//table[@class='table table-bordered']/tbody)[1]/tr[" + row + "]/td[" + column + "]"));

    }

    private int getNumberOfRows() {
        List<WebElement> allRollsWithoutHeader = Driver.get().findElements(By.xpath("(" +
                "//table[@class='table table-bordered']/tbody)[1]/tr"));
        int numberOfRows = allRollsWithoutHeader.size();
        return numberOfRows;
    }


    private WebElement totalItemNumber(int row, int col) {
        return Driver.get().findElement(By.xpath("(//table[@class='table table-bordered']/tbody)[1]/tr" +
                "[" + row + "]/td[" + col + "]//input"));
    }

    public void verifyNumberOfItemsOnShoppingCartPage() {
        int actualProductList = 0;
        int rowSize = getNumberOfRows();
        for (int i = 1; i <= rowSize; i++) {
            actualProductList += Integer.parseInt(totalItemNumber(i, 4).getAttribute("value"));
        }

        int actualNumber = actualProductList;
        int expectedNumber = CartProductsPage.addedItemNumber;

        System.out.println("actualNumber = " + actualNumber);
        System.out.println("expectedNumber = " + expectedNumber);
        Assert.assertEquals(expectedNumber, actualNumber);
    }

    public void deleteSelectedProductInTheCart() {
        int rowSize = getNumberOfRows();
        for (int i = 1; i <= rowSize; i++) {
            if (rowSize >= 0) {
                deleteButtonOnTheShoppingCartPage(1, 4).click();
                BrowserUtils.waitFor(1);
                CartProductsPage.addedItemNumber--;
            } else {
                break;
            }
        }
    }

    private WebElement deleteButtonOnTheShoppingCartPage(int row, int column) {
        return Driver.get().findElement(By.xpath("" +
                "(//table[@class='table table-bordered']/tbody)[1]/tr[" + row + "]/td[" + column + "]//button[2]/i"));
    }


}
