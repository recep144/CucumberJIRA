package com.ourvirtualmarket.step_defs;


import com.ourvirtualmarket.pages.ShoppingCartPage;
import io.cucumber.java.en.And;

import java.util.List;

public class ShoppingCard_StepDefs {

    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @And("The user should be able to see  the pruducts added in the Shoping Cart page:")
    public void theUserShouldBeAbleToSeeThePruductsAddedInTheShopingCartPage(List<String> productNames) {

        shoppingCartPage.shoppingCartListControl(productNames);

        shoppingCartPage.verifyNumberOfItemsOnShoppingCartPage();

    }

    @And("The user should be able to see  the same pruducts added in the Shoping Cart page:")
    public void theUserShouldBeAbleToSeeTheSamePruductsAddedInTheShopingCartPage(List<String> productNames) {
        shoppingCartPage.shoppingCartListControl(productNames);
    }
}
