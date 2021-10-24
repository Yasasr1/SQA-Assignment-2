package com.automationpractice.qa.testcases;

import com.automationpractice.qa.base.TestBase;
import com.automationpractice.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class CheckoutTest extends TestBase {
    LoginPage loginPage;
    AccountPage accountPage;
    WomenStorePage womenStorePage;
    CheckoutPage checkoutPage;

    public CheckoutTest() {
        super();
    }

    @BeforeTest
    public void setup() {
        init();
        loginPage = new LoginPage();
        accountPage = loginPage.login(properties.getProperty("email_correct"), properties.getProperty("password_correct"));
        womenStorePage = accountPage.goToWomenStore();
        checkoutPage = womenStorePage.checkout();
    }

    @Test (priority=1)
    public void checkoutPageValidationTest() {
        boolean flag = checkoutPage.validateCheckoutPage();
        Assert.assertTrue(flag);
    }

    @Test (priority=2) void verifyTotalCostTest() {
        boolean flag = checkoutPage.verifyTotalCost();
        Assert.assertTrue(flag);
    }

    @Test (priority=3) void plusOneItemTest() {
        boolean flag = checkoutPage.plusOneItem();
        Assert.assertTrue(flag);
    }

    @Test (priority=4) void minusOneItemTest() {
        boolean flag = checkoutPage.minusOneItem();
        Assert.assertTrue(flag);
    }

    @Test (priority=5) void proceedWithoutAgreeingWarningTest() {
        boolean flag = checkoutPage.proceedWithoutAgreeingWarning();
        Assert.assertTrue(flag);
    }

    @Test (priority=6) void payByWireTest() {
        boolean flag = checkoutPage.payByWire();
        Assert.assertTrue(flag);
    }

    @Test (priority=7) void confirmTest() {
        boolean flag = checkoutPage.confirm();
        Assert.assertTrue(flag);
    }

    @AfterTest
    public void cleanup() {
        driver.quit();
    }
}