package com.ourvirtualmarket.step_defs;

import com.ourvirtualmarket.pages.LoginPage;
import com.ourvirtualmarket.pages.LogoutPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Logout_stepDefs {
    LoginPage loginPage=new LoginPage();
    LogoutPage logoutPage=new LogoutPage();
    @Then("Verify that the logout button isdisplayed")
    public void verifyThatTheLogoutButtonIsdisplayed() {
        Assert.assertTrue(loginPage.logoutButton.isDisplayed());

    }

    @When("The user clicks logout button")
    public void theUserClicksLogoutButton() {
        loginPage.logoutButton.click();
        
    }

    @Then("The user sees {string} and {string} message")
    public void theUserSeesAndMessage(String expectedMessage1, String expectedMessage2) {
        Assert.assertEquals(expectedMessage1,logoutPage.firstText.getText());
        Assert.assertEquals(expectedMessage2,logoutPage.secondText.getText());
    }
}
