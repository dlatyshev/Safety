package io.customertimes.automation;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/resources/",
        plugin = {"pretty"})
public class RunCucumberTest extends AbstractTestNGCucumberTests{

}