package io.customertimes.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends Page {

    public MainPage(WebDriver driver) {
        super("Home | Salesforce", "https://iqvia-safety--dev1.lightning.force.com/lightning/page/home", driver);
        PageFactory.initElements(driver(), this);
    }

    @Override
    public boolean isOpened() {
        return super.isOpened();
    }
}
