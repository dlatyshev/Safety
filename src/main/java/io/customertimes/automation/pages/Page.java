package io.customertimes.automation.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public abstract class Page {
    protected WebDriver driver;
    protected Logger log;
    protected String title;
    protected String url;


    public Page(WebDriver driver, Logger log, String title, String url) {
        this.driver = driver;
        this.log = log;
        this.title = title;
        this.url = url;
    }

    public abstract boolean isOpened();

    protected void openUrl(String url){
        driver.get(url);
    }

    protected WebElement find(By locator){
        return driver.findElement(locator);
    }

    protected List<WebElement> findAll(By locator){
        return driver.findElements(locator);
    }
    protected void click(By locator){
        waitForVisibilityOf(locator, 5);
        find(locator).click();
    }

    protected void type(String text, By locator){
        waitForVisibilityOf(locator, 5);
        find(locator).sendKeys(text);
    }

    private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutIsSeconds){
        timeOutIsSeconds = timeOutIsSeconds != null ? timeOutIsSeconds : 30;
        WebDriverWait wait = new WebDriverWait(driver, timeOutIsSeconds);
        wait.until(condition);
    }

    protected void waitForVisibilityOf(By locator, Integer ... timeOutInSeconds){
        int attempts = 0;
        while(attempts < 2){
            try{
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator), (timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
                break;
            } catch (StaleElementReferenceException e){
                e.printStackTrace();
            }
            attempts++;

        }
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}
