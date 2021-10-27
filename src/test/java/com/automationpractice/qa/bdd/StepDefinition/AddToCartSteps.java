package com.automationpractice.qa.bdd.StepDefinition;

import com.automationpractice.qa.base.TestBase;
import com.automationpractice.qa.pages.AccountPage;
import com.automationpractice.qa.pages.LoginPage;
import com.automationpractice.qa.pages.WomenStorePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AddToCartSteps extends TestBase {
    LoginPage loginPage;
    AccountPage accountPage;
    WomenStorePage womenStorePage;
    Boolean cartVerified;

    public AddToCartSteps() {
        super();
    }

    @Given("^User is logged into the website$")
    public void login() throws Throwable
    {
        init();
        loginPage = new LoginPage();
        accountPage = loginPage.login(properties.getProperty("email_correct"), properties.getProperty("password_correct"));
        womenStorePage = accountPage.goToWomenStore();
    }

    @When("^User select product and press add to cart button$")
    public void addToCart() throws Throwable
    {
        cartVerified = womenStorePage.addOneProduct();
    }

    @Then("^Product is added to the cart$")
    public void verifyCart() throws Throwable
    {
        Assert.assertTrue(cartVerified);
        driver.quit();
    }
}
