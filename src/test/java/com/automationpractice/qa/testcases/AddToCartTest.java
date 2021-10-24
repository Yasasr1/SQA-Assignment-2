package com.automationpractice.qa.testcases;

import com.automationpractice.qa.base.TestBase;
import com.automationpractice.qa.pages.AccountPage;
import com.automationpractice.qa.pages.LoginPage;
import com.automationpractice.qa.pages.WomenStorePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddToCartTest extends TestBase {
    LoginPage loginPage;
    AccountPage accountPage;
    WomenStorePage womenStorePage;

    public AddToCartTest() {
        super();
    }

    @BeforeTest
    public void setup() {
        init();
        loginPage = new LoginPage();
        accountPage = loginPage.login(properties.getProperty("email_correct"), properties.getProperty("password_correct"));
        womenStorePage = accountPage.goToWomenStore();
    }

    @Test
    public void womenStorePageValidationTest() {
        boolean flag = womenStorePage.validateWomenStorePage();
        Assert.assertTrue(flag);
    }

    @Test void addOneProductTest() {
        boolean flag = womenStorePage.addOneProduct();
        Assert.assertTrue(flag);
    }

    @Test void addMultipleProductTest() {
        boolean flag = womenStorePage.addMultipleProduct();
        Assert.assertTrue(flag);
    }

    @AfterTest
    public void cleanup() {
        driver.quit();
    }
}
