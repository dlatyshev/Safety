package io.customertimes.automation.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Page {

    public HomePage(WebDriver driver, Logger log) {
        super(driver,log,"Home | Salesforce", "https://iqvia-safety--dev1.lightning.force.com/lightning/page/home");
    }



}
