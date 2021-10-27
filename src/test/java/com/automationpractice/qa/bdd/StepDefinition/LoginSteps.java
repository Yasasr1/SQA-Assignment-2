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
        init();
        loginPage = new LoginPage();

    }

    @When("^Enter the correct email and password and click login$")
    public void login() throws Throwable
    {
        accountPage = loginPage.login(properties.getProperty("email_correct"), properties.getProperty("password_correct"));

    }

    @When("^Enter the incorrect email and password and click login$")
    public void loginFail() throws Throwable
    {
        loginPage.loginFail(properties.getProperty("email_incorrect"), properties.getProperty("password_incorrect"));
    }

    @Then("^User loging fails$")
    public void verifyLoginFail() throws Throwable
    {
        boolean flag =  loginPage.getAuthenticationFailed();
        Assert.assertTrue(flag);
        driver.quit();
    }

    @Then("^User logged into the website$")
    public void verifyLogin() throws Throwable
    {
        boolean flag = accountPage.validateAccountPage();
        loginPage.logout();
        Assert.assertTrue(flag);
        driver.quit();
    }
}
