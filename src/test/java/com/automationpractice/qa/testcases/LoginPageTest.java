package com.automationpractice.qa.testcases;

import com.automationpractice.qa.base.TestBase;
import com.automationpractice.qa.pages.AccountPage;
import com.automationpractice.qa.pages.LoginPage;
import com.automationpractice.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.ITestResult;
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

    @Test void unsuccessfulLoginNoEmailTest() {
        boolean flag = loginPage.validateNoEmail("", properties.getProperty("password_correct"));
        Assert.assertTrue(flag);
    }

    @Test void unsuccessfulLoginInvalidEmailTest() {
        boolean flag = loginPage.validateInvalidEmail(properties.getProperty("email_invalid"), properties.getProperty("password_correct"));
        Assert.assertTrue(flag);
    }

    @Test void unsuccessfulLoginIncorrectEmailTest() {
        boolean flag = loginPage.validateIncorrectEmail(properties.getProperty("email_incorrect"), properties.getProperty("password_correct"));
        Assert.assertTrue(flag);
    }

    @Test void unsuccessfulLoginNoPasswordTest() {
        boolean flag = loginPage.validateNoPassword(properties.getProperty("email_correct"), "");
        Assert.assertTrue(flag);
    }

    @Test void unsuccessfulLoginInvalidPasswordTest() {
        boolean flag = loginPage.validateInvalidPassword(properties.getProperty("email_correct"), properties.getProperty("password_invalid"));
        Assert.assertTrue(flag);
    }

    @Test void unsuccessfulLoginIncorrectPasswordTest() {
        boolean flag = loginPage.validateIncorrectPassword(properties.getProperty("email_correct"), properties.getProperty("password_incorrect"));
        Assert.assertTrue(flag);
    }

    @Test void successfulLoginTest() {
        accountPage = loginPage.login(properties.getProperty("email_correct"), properties.getProperty("password_correct"));
        boolean flag = accountPage.validateAccountPage();
        loginPage.logout();
        Assert.assertTrue(flag);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        String testName = result.getName();
        if(ITestResult.FAILURE==result.getStatus()) {
            logger.error(testName + " failed");
            try {
                TestUtil.takeScreenshot(driver, System.getProperty("user.dir") + TestUtil.SCREENSHOT_PATH + testName + ".png");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else{
            logger.info(testName + " passed");
        }

    }

    @AfterTest
    public void cleanup() {
        driver.quit();
    }
}
