package com.automationpractice.qa.bdd.StepDefinition;

import com.automationpractice.qa.base.TestBase;
import com.automationpractice.qa.pages.AccountPage;
import com.automationpractice.qa.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps extends TestBase {
    LoginPage loginPage;
    AccountPage accountPage;

    public LoginSteps() {
        super();
    }

    @Given("^Open the web browser and launch the website$")
    public void setup() throws Throwable
    {
        System.out.println("This Step open the browser and launch the application.");
        init();
        loginPage = new LoginPage();

    }

    @When("^Enter the email and password and click login$")
    public void login() throws Throwable
    {
        System.out.println("This step enter the Username and Password on the login page.");
        accountPage = loginPage.login(properties.getProperty("email_correct"), properties.getProperty("password_correct"));

    }

    @Then("^User logged into the website$")
    public void verify_login() throws Throwable
    {
        System.out.println("This step verifies the login");
        boolean flag = accountPage.validateAccountPage();
        loginPage.logout();
        Assert.assertTrue(flag);
        driver.quit();
    }
}
