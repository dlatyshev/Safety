package io.customertimes.automation;

import io.customertimes.automation.pages.LoginPage;
import io.customertimes.automation.pages.MainPage;
import io.customertimes.automation.utilities.TestUtilities;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;

public abstract class Login extends TestUtilities {
    private LoginPage loginPage = new LoginPage(driver);

    protected void goTo(){
        loginPage.goTo();
    }

    protected MainPage logIn(String login, String password){
        LoginPage loginPage = new LoginPage(driver);
        return loginPage.logIn(login, password);
    }



}
