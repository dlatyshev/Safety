package io.customertimes.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Page {

    //Fields

    @FindBy(id = "username")
    private WebElement loginField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "Login")
    private WebElement loginBtn;

    // Constructor

    public LoginPage(WebDriver driver) {
        super("Login | Salesforce", "https://test.salesforce.com/", driver);
        PageFactory.initElements(driver(), this);
    }

    //Methods
    public void goTo(){
        driver().get(super.url());
    }

    public MainPage logIn(String login, String password){
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        loginBtn.click();
        return new MainPage(driver());
    }




}
