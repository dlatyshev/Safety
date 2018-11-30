package io.customertimes.automation.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Page {

    //Fields
    private By loginLocator = By.id("username");
    private By passwordLocator = By.id("password");
    private By loginBtnLocator = By.id("Login");

    // Constructor

    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log, "Login | Salesforce", "https://test.salesforce.com/");
    }

    //Methods
    public void openPage(){
        openUrl(url);
    }
    public HomePage logIn(String login, String password){
       type(login, loginLocator);
       type(password, passwordLocator);
       click(loginBtnLocator);
       return new HomePage(driver, log);
    }

    @Override
    public boolean isOpened() {
        return find(loginBtnLocator).isDisplayed();
    }

    @Override
    public String getCurrentUrl() {
        return super.getCurrentUrl();
    }
}
