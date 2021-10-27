package com.automationpractice.qa.bdd.TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="Features",glue={"com.automationpractice.qa.bdd.StepDefinition"})
public class Runner {
}
