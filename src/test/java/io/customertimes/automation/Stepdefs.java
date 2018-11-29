package io.customertimes.automation;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import io.customertimes.automation.Login;
import io.customertimes.automation.pages.LoginPage;
import io.customertimes.automation.pages.MainPage;
import io.customertimes.automation.utilities.Base;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Stepdefs extends Login {

    private boolean mainPageIsOpened;

    @Given("user entered the login page")
    public void user_entered_the_login_page() {
        goTo();
    }
    @When("^user entered \"([^\"]*)\" and \"([^\"]*)\" and click login button$")
    public void userEnteredAndAndClickLoginButton(String login, String password) {
        mainPageIsOpened = logIn(login, password).isOpened();
    }
    @Then("Safety main page is opened")
    public void safety_main_page_is_opened() {
        Assert.assertTrue(mainPageIsOpened);
    }

}