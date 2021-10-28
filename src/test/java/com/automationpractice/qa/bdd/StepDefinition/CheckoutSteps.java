package com.automationpractice.qa.bdd.StepDefinition;

import com.automationpractice.qa.base.TestBase;
import com.automationpractice.qa.pages.AccountPage;
import com.automationpractice.qa.pages.CheckoutPage;
import com.automationpractice.qa.pages.LoginPage;
import com.automationpractice.qa.pages.WomenStorePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CheckoutSteps extends TestBase {
    LoginPage loginPage;
    AccountPage accountPage;
    WomenStorePage womenStorePage;
    CheckoutPage checkoutPage;
    private boolean paymentVerified;

    public CheckoutSteps() {
        super();
    }

    @Given("^User is logged in and added items to the cart$")
    public void setupCart() throws Throwable
    {
        init();
        loginPage = new LoginPage();
        accountPage = loginPage.login(properties.getProperty("email_correct"), properties.getProperty("password_correct"));
        womenStorePage = accountPage.goToWomenStore();
        checkoutPage = womenStorePage.checkout();
    }

    @When("^User complete payment by check$")
    public void payByBank() throws Throwable
    {
        paymentVerified = checkoutPage.payByCheckBdd();
    }

    @When("^User complete payment by bank wire$")
    public void payByWire() throws Throwable
    {
        paymentVerified = checkoutPage.payByWireBdd();
    }

    @Then("^Invoice is displayed to the user$")
    public void verifyBankPayment() throws Throwable
    {
        Assert.assertTrue(paymentVerified);
        driver.quit();
    }
}
