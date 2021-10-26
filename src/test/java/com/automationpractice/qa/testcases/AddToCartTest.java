package com.automationpractice.qa.testcases;

import com.automationpractice.qa.base.TestBase;
import com.automationpractice.qa.pages.AccountPage;
import com.automationpractice.qa.pages.LoginPage;
import com.automationpractice.qa.pages.ProductPage;
import com.automationpractice.qa.pages.WomenStorePage;
import com.automationpractice.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class AddToCartTest extends TestBase {
    LoginPage loginPage;
    AccountPage accountPage;
    WomenStorePage womenStorePage;
    ProductPage productPage;

    public AddToCartTest() {
        super();
    }

    @BeforeMethod
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

    @Test void addMultipleItemsTest() {
        productPage = womenStorePage.clickMore();
        boolean flag = productPage.addMultipleItems();
        Assert.assertTrue(flag);
    }

    @Test void changeColorTest() {
        productPage = womenStorePage.clickMore();
        boolean flag = productPage.changeColor();
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

    @AfterMethod
    public void cleanup() {
        driver.quit();
    }
}
