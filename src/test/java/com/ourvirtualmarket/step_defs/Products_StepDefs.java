package com.ourvirtualmarket.step_defs;

import com.ourvirtualmarket.pages.ProductsPage;
import com.ourvirtualmarket.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.remote.DriverCommand;

import java.util.Map;
public class Products_StepDefs {

    ProductsPage productsPage = new ProductsPage();

    @When("The user should be able to select {string} category")
    public void theUserShouldBeAbleToSelectFrom(String category) {
        productsPage.selectTheCategories(category);
    }

    @When("The user should be able to select {string} LED-backlit LCD TV \" product")
    public void the_user_should_be_able_to_select_led_backlit_lcd_tv_product(String product) {
        productsPage.selectedProduct(product);
    }

    @Then("The user Should be able to click ADD TO COMPARE type")
    public void theUserShouldBeAbleToClickADDTOCOMPAREType() {
        productsPage.clickAddToCompareType();
    }

    @And("The user should take success message: {string} LED-backlit LCD TV to your product comparison!\"")
    public void theUserShouldTakeSuccessMessageLEDBacklitLCDTVToYourProductComparison(String message) {
        String expectedMessage = message;
        String actualMessage = productsPage.messageSuccess.getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
        Driver.get().navigate().back();
    }

    @When("The user Should be able to click COMPARE type")
    public void theUserShouldBeAbleToClickCOMPAREType() {
        productsPage.compareTypeInTheProductPage();
    }


}