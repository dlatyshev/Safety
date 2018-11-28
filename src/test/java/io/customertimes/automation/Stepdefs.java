package io.customertimes.automation;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import io.customertimes.automation.Login;
import org.testng.Assert;
import org.testng.annotations.Parameters;

public class Stepdefs extends Login{
    private boolean mainPageIsOpened;

    @Given("user entered the login page")
    public void user_entered_the_login_page() {
        goTo();
    }

    @Parameters({"login", "password"})
    @When("user entered valid credentials and click login button")
    public void user_entered_valid_credentials_and_click_login_button(String login, String password) {
        mainPageIsOpened = logIn(login, password).isOpened();
    }

    @Then("Safety main page is opened")
    public void safety_main_page_is_opened() {
        Assert.assertTrue(mainPageIsOpened);
    }
}