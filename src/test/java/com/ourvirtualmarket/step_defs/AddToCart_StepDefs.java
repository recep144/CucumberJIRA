package com.ourvirtualmarket.step_defs;

import com.ourvirtualmarket.pages.CartProductsPage;
import com.ourvirtualmarket.pages.ShoppingCartPage;
import com.ourvirtualmarket.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class AddToCart_StepDefs {

    CartProductsPage cartProductsPage = new CartProductsPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @Then("When the user hovers mouse hover over {string} product, four small options is presented to the user into the red boxes that is having:")
    public void whenTheUserHoversMouseHoverOverProductFourSmallOptionsIsPresentedToTheUserIntoTheRedBoxesThatIsHaving(
            String product, List<String> optionsNames) {
        cartProductsPage.titleListControl(product, optionsNames);
    }

    @Then("The user should be able to click the Add to Cart icon of the {string} product")
    public void theUserShouldBeAbleToClickTheAddToCartIconOfTheProduct(String product) {
        cartProductsPage.clickTheSelectedProduct(product);
    }

    @And("A success message appears as: {string}")
    public void aSuccessMessageAppearsAs(String message) {
        cartProductsPage.messageOfTheSelectedProduct(message);
    }

    @Then("The user should be able to click the cirt ıtem that is at the middle-right")
    public void theUserShouldBeAbleToClickTheCirtItemThatIsAtTheMiddleRight() {
        cartProductsPage.clickToCartIcon();
    }

    @And("The number on the basket icon should show the added item number")
    public void theNumberOnTheBasketIconShouldShowTheAddedItemNumber() {
        System.out.println("cartProductsPage.getAddedItemNumber() = " + cartProductsPage.getAddedItemNumber());
        Assert.assertEquals(cartProductsPage.addedItemNumber, cartProductsPage.getAddedItemNumber());
    }

    @Then("The user should be able to hover the cirt ıtem that is at the middle-right")
    public void theUserShouldBeAbleToHoverTheCirtItemThatIsAtTheMiddleRight() {
        BrowserUtils.hover(cartProductsPage.cartIcon);
        BrowserUtils.waitFor(1);
    }

    @And("The user should be able to see  the pruducts added on the Base Page:")
    public void theUserShouldBeAbleToSeeThePruductsAddedOnTheBasePage(List<String> expectedPeoducts) {
        cartProductsPage.shoppingCartListControlOnBasePage(expectedPeoducts);
    }

    @And("The user should be able to click logout Type")
    public void theUserShouldBeAbleToClickLogoutType() {
        shoppingCartPage.deleteSelectedProductInTheCart();
        BrowserUtils.clickWithJS(cartProductsPage.loginOption);
    }

    @And("The user should be able to delete shopping cart and click logout Type")
    public void theUserShouldBeAbleToDeleteShoppingCartAndClickLogoutType() {
        shoppingCartPage.deleteSelectedProductInTheBasePage();
        BrowserUtils.clickWithJS(cartProductsPage.loginOption);
    }

    @When("The user should be able to delete the previous shopping cart")
    public void theUserShouldBeAbleToDeleteThePreviousShoppingCart() {
        shoppingCartPage.deleteSelectedProductInTheBasePage();
    }

}
