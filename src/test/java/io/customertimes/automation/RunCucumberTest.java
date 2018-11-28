package io.customertimes.automation;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.customertimes.automation.utilities.Base;
import org.openqa.selenium.WebDriver;

@CucumberOptions(features = "src/test/resources/",
plugin = {"pretty"}, glue = "steps")
public class RunCucumberTest extends AbstractTestNGCucumberTests {

}