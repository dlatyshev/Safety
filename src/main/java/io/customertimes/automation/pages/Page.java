package io.customertimes.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Page {
    private String title;
    private String url;
    private WebDriver driver;
    private WebDriverWait explicitWait;

    public Page(String title, String url, WebDriver driver) {
        this.title = title;
        this.url = url;
        this.driver = driver;
        explicitWait = new WebDriverWait(driver, 20);
    }

    protected boolean isOpened(){
        boolean result = false;

        try {
            result = explicitWait.until(ExpectedConditions.urlContains(url));
        }
        catch (Exception ex){
            ex.printStackTrace();
            result = false;
        }
        return result;
    }

    protected String url(){
        return url;
    }

    protected String title(){
        return title;
    }

    protected WebDriver driver(){
        return driver;
    }

    protected WebDriverWait explicitWait(){
        return explicitWait;
    }
}
