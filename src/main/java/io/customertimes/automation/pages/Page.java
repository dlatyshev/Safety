package io.customertimes.automation.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;
import java.util.Set;


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
        waitForVisibilityOf(locator, 10);
        find(locator).click();
    }

    protected void type(String text, By locator){
        waitForVisibilityOf(locator, 10);
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

    protected Alert switchToAlert() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }

    protected  void switchToWindowWithTitle(String expectedTitle){
        String firstWindow = driver.getWindowHandle();

        Set<String> allWindows = driver.getWindowHandles();

        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(firstWindow)) {
                driver.switchTo().window(windowHandle);
                if (getTitle().equals(expectedTitle)) {
                    break;
                }
            }
        }
    }

    protected void switchToFrame(By frameLocator){
        driver.switchTo().frame(find(frameLocator));
    }

    protected void pressKey(By locator, Keys key){
        find(locator).sendKeys(key);
    }

    protected void pressKeyWithActions(Keys key){
        log.info("Pressing " + key.name() + " using Actions class");
        Actions action = new Actions(driver);
        action.sendKeys(key).build().perform();
    }

    protected void performDragAndDrop(By from, By to){
        Actions action = new Actions(driver);
        action.dragAndDrop(find(from), find(to)).build().perform();
        // Might not work with html5
    }

    public void scrollToBottom() {
        log.info("Scrolling to the bottom of the page");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public String getCurrentPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentPageSource(){
        return driver.getPageSource();
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
