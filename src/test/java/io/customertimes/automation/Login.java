package io.customertimes.automation;

import io.customertimes.automation.pages.LoginPage;
import io.customertimes.automation.pages.MainPage;
import io.customertimes.automation.utilities.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

class Login extends Base {
    private WebDriver driver = new ChromeDriver();
    private LoginPage loginPage = new LoginPage(driver);

    protected void goTo(){
        loginPage.goTo();
    }

    protected MainPage logIn(String login, String password){
        LoginPage loginPage = new LoginPage(driver);
        return loginPage.logIn(login, password);
    }



}
