package io.customertimes.automation;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import io.customertimes.automation.pages.HomePage;
import io.customertimes.automation.pages.LoginPage;
import io.customertimes.automation.utilities.TestUtilities;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginSteps extends TestUtilities {
    private LoginPage loginPage;
    private HomePage homePage;

    @Given("^user opened the \"([^\"]*)\"$")
    public void userOpenedTheBrowser(String browser) {
        setUp(browser);
        loginPage = new LoginPage(driver, log);
    }
    @Given("user opened the login page")
    public void user_opened_the_login_page() {
        loginPage.openPage();
    }
    @When("^user entered \"([^\"]*)\" and \"([^\"]*)\" and clicked login button$")
    public void userEnteredAndAndClickLoginButton(String login, String password) {
       homePage = loginPage.logIn(login, password);
    }
    @Then("Safety home page was opened")
    public void safety_home_page_was_opened() {
        Assert.assertTrue(homePage.isOpened());
    }

    @Then("^browser was closed$")
    public void browserWasClosed(){
        tearDown();
    }
    // Just another test to check pull requests
}