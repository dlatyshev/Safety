package io.customertimes.automation;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.customertimes.automation.pages.HomePage;
import io.customertimes.automation.pages.LoginPage;
import io.customertimes.automation.utilities.Base;
import org.testng.Assert;


@CucumberOptions(features = "src/test/resources/",
        plugin = {"pretty"})
public class RunCucumberTest extends AbstractTestNGCucumberTests{

}