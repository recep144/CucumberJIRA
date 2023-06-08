package com.ourvirtualmarket.step_defs;

import com.ourvirtualmarket.pages.LoginPage;
import com.ourvirtualmarket.utilities.ConfigurationReader;
import com.ourvirtualmarket.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Login_stepDefs {
    LoginPage loginPage=new LoginPage();
    @Given("The user goes to homepage")
    public void theUserGoesToHomepage() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("The user closes pop-up")
    public void theUserClosesPopUp() {
        loginPage.popoupClose.click();

    }

    @When("The user logs in")
    public void theUserLogsIn() {
        loginPage.loginButton.click();
loginPage.login();
    }
}
