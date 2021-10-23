package com.automationpractice.qa.testcases;

import com.automationpractice.qa.base.TestBase;
import com.automationpractice.qa.pages.AccountPage;
import com.automationpractice.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    AccountPage accountPage;

    public LoginPageTest() {
        super();
    }

    @BeforeTest
    public void setup() {
        init();
        loginPage = new LoginPage();
    }

    @Test
    public void loginPageValidationTest() {
        boolean flag = loginPage.validateLoginPage();
        Assert.assertTrue(flag);
    }

    @Test void loginTest() {
        accountPage = loginPage.login(properties.getProperty("email_correct"), properties.getProperty("password_correct"));
        boolean flag = accountPage.validateAccountPage();
        Assert.assertTrue(flag);
    }

    @AfterTest
    public void cleanup() {
        driver.quit();
    }
}
