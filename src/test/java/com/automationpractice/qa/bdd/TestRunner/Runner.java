package com.automationpractice.qa.bdd.TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features="Features/",glue={"com.automationpractice.qa.bdd.StepDefinition"},
        plugin = { "pretty:target/cucumber-htmlreport.text", "json:target/cucumber/cucumber.json" }, monochrome = true)
public class Runner extends AbstractTestNGCucumberTests{
}



//plugin = { "json:target/cucumber.json", "pretty", "html:target/cucumber-reports" }