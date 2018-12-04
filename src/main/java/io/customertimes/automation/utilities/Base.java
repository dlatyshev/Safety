package io.customertimes.automation.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;


public class Base  {
    protected WebDriver driver;
    protected Logger log;

    public void setUp(String browser) {
        log = LogManager.getLogger(getClass().getName());
        BrowserDriverFactory factory = new BrowserDriverFactory(browser, log);
        driver = factory.createDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public void maximizeWindow(WebDriver driver){
        driver.manage().window().maximize();
    }

    // Hello
    public void tearDown() {
        log.info("Close driver");
        // Close browser
        driver.quit();
    }
}
