package io.customertimes.automation.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page {
    private By appTitle = By.xpath("//span[@title='Safety - Intake']");

    public HomePage(WebDriver driver, Logger log) {
        super(driver,log,"Home | Salesforce", "https://iqvia-safety--dev1.lightning.force.com/lightning/page/home");
    }

    @Override
    public boolean isOpened() {
        return find(appTitle).isDisplayed();
    }
}
