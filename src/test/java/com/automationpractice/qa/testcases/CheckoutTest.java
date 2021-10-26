package com.automationpractice.qa.testcases;

import com.automationpractice.qa.base.TestBase;
import com.automationpractice.qa.pages.*;
import com.automationpractice.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class CheckoutTest extends TestBase {
    LoginPage loginPage;
    AccountPage accountPage;
    WomenStorePage womenStorePage;
    CheckoutPage checkoutPage;
    AddressPage addressPage;

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

    @Test (priority=5) void updateAddressTest() {
        addressPage = checkoutPage.goToAddressPage();
        checkoutPage = addressPage.updateAddress();
        boolean flag = checkoutPage.verifyAddress();
        Assert.assertTrue(flag);
    }

    @Test (priority=6) void proceedWithoutAgreeingWarningTest() {
        boolean flag = checkoutPage.proceedWithoutAgreeingWarning();
        Assert.assertTrue(flag);
    }

    @Test (priority=7) void payByWireTest() {
        boolean flag = checkoutPage.payByWire();
        Assert.assertTrue(flag);
    }

    @Test (priority=8) void goBackTest() {
        boolean flag = checkoutPage.goBack();
        Assert.assertTrue(flag);
    }

    @Test (priority=9) void payByBankTest() {
        boolean flag = checkoutPage.payByCheck();
        Assert.assertTrue(flag);
    }

    @Test (priority=10) void confirmTest() {
        boolean flag = checkoutPage.confirm();
        Assert.assertTrue(flag);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if(ITestResult.FAILURE==result.getStatus()) {
            String testName = result.getName();
            try {
                TestUtil.takeScreenshot(driver, System.getProperty("user.dir") + TestUtil.SCREENSHOT_PATH + testName + ".png");
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    @AfterTest
    public void cleanup() {
        driver.quit();
    }
}
