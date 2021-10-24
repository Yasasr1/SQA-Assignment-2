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

    @Test
    public void checkoutPageValidationTest() {
        boolean flag = checkoutPage.validateCheckoutPage();
        Assert.assertTrue(flag);
    }

    @Test void unsuccessfulLoginNoEmailTest() {
        boolean flag = checkoutPage.verifyTotalCost();
        Assert.assertTrue(flag);
    }

    @AfterTest
    public void cleanup() {
        driver.quit();
    }
}
