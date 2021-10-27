package com.automationpractice.qa.pages;

import com.automationpractice.qa.util.TestUtil;
import org.checkerframework.framework.qual.FieldInvariant;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.webaudio.WebAudio;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;

import static com.automationpractice.qa.base.TestBase.driver;
import static com.automationpractice.qa.base.TestBase.wait;

public class CheckoutPage {

    @FindBy(xpath = "//h1[@id='cart_title']")
    WebElement cartTitle;

    @FindBy(xpath = "//span[@id='total_price'][text()=\"$18.51\"]")
    WebElement totalPrice;

    @FindBy(xpath = "//i[@class='icon-plus']")
    WebElement plusBtn;

    @FindBy(xpath = "//a[@id='cart_quantity_down_1_1_0_591283']//span")
    WebElement minusBtn;

    @FindBy(xpath = "//i[@class='icon-trash']")
    WebElement trashBtn;

    @FindBy(xpath = "//span[@id='total_price'][text()=\"$35.02\"]")
    WebElement totalPrice2;

    @FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
    WebElement proceedBtn;

    @FindBy(xpath = "//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")
    WebElement proceedBtn2;

    @FindBy(xpath = "//label[@for='cgv']")
    WebElement agreeToTerms;

    @FindBy(xpath = "//p[@class='fancybox-error']")
    WebElement agreeWarning;

    @FindBy(xpath = "//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
    WebElement proceedBtn3;

    @FindBy(xpath = "//a[@title='Close']")
    WebElement warningCloseBtn;

    @FindBy(xpath = "//a[@title='Pay by bank wire']//span[contains(text(),'(order processing will be longer)')]")
    WebElement payByWireBtn;

    @FindBy(xpath = "//a[@title='Pay by check.']")
    WebElement payByCheckBtn;

    @FindBy(xpath = "//span[normalize-space()='I confirm my order']")
    WebElement confirmBtn;

    @FindBy(xpath = "//p[@class='alert alert-success']")
    WebElement orderCompleteMsg;

    @FindBy(xpath = "//strong[contains(text(),'You have chosen to pay by bank wire. Here is a sho')]")
    WebElement orderSummaryTitleForWire;

    @FindBy(xpath = "//strong[contains(text(),'You have chosen to pay by check. Here is a short s')]")
    WebElement orderSummaryTitleForCheck;

    @FindBy(xpath = "//li[@class='step_done step_done_last four']//a[1]")
    WebElement shippingBtn;

    @FindBy(xpath = "//h1[@class='page-heading']")
    WebElement shippingTitle;

    @FindBy(xpath = "//ul[@id='address_delivery']//span[contains(text(),'Update')]")
    WebElement updateAddress;

    @FindBy(xpath = "//ul[@id='address_delivery']//li[@class='address_firstname address_lastname']")
    WebElement addressName;

    @FindBy(xpath = "//ul[@id='address_delivery']//li[@class='address_company']")
    WebElement addressCompany;

    public CheckoutPage() {
        PageFactory.initElements(driver, this);
    }

    public Boolean validateCheckoutPage() {
        return cartTitle.isDisplayed();
    }

    public Boolean verifyTotalCost() {
        return totalPrice.isDisplayed();
    }

    public Boolean plusOneItem() {
        plusBtn.click();
        wait.until(ExpectedConditions.visibilityOf(totalPrice2));
        return totalPrice2.isDisplayed();
    }

    public Boolean minusOneItem() {
        minusBtn.click();
        wait.until(ExpectedConditions.visibilityOf(totalPrice));
        return totalPrice.isDisplayed();
    }

    public AddressPage goToAddressPage() {
        wait.until(ExpectedConditions.visibilityOf(proceedBtn));
        proceedBtn.click();
        wait.until(ExpectedConditions.visibilityOf(updateAddress));
        updateAddress.click();
        return new AddressPage();
    }


    public Boolean verifyAddress() {
        ArrayList<String> words = new ArrayList<String>();
        try {
            String filePath = System.getProperty("user.dir") + "/src/main/java/com/automationpractice/qa/testdata/";
            words = TestUtil.readExcel(filePath, "data.xlsx", "Sheet1");

        } catch (IOException e) {
            System.out.println(e);
        }
        if (addressName.getText().equals(words.get(0) + " " + words.get(1)) && addressCompany.getText().equals(words.get(2))) {
            return true;
        } else {
            return false;
        }

    }

    public Boolean proceedWithoutAgreeingWarning() {
        wait.until(ExpectedConditions.visibilityOf(proceedBtn2));
        proceedBtn2.click();
        wait.until(ExpectedConditions.visibilityOf(proceedBtn3));
        proceedBtn3.click();
        wait.until(ExpectedConditions.visibilityOf(agreeWarning));
        return agreeWarning.isDisplayed();
    }

    public Boolean payByWire() {
        wait.until(ExpectedConditions.visibilityOf(warningCloseBtn));
        warningCloseBtn.click();
        wait.until(ExpectedConditions.visibilityOf(agreeToTerms));
        agreeToTerms.click();
        wait.until(ExpectedConditions.visibilityOf(proceedBtn3));
        proceedBtn3.click();
        wait.until(ExpectedConditions.visibilityOf(payByWireBtn));
        payByWireBtn.click();
        wait.until(ExpectedConditions.visibilityOf(orderSummaryTitleForWire));
        return orderSummaryTitleForWire.isDisplayed();
    }

    public Boolean goBack() {
        shippingBtn.click();
        wait.until(ExpectedConditions.visibilityOf(shippingTitle));
        return shippingTitle.isDisplayed();
    }

    public Boolean payByCheck() {
        wait.until(ExpectedConditions.visibilityOf(agreeToTerms));
        agreeToTerms.click();
        wait.until(ExpectedConditions.visibilityOf(proceedBtn3));
        proceedBtn3.click();
        wait.until(ExpectedConditions.visibilityOf(payByCheckBtn));
        payByCheckBtn.click();
        wait.until(ExpectedConditions.visibilityOf(orderSummaryTitleForCheck));
        return orderSummaryTitleForCheck.isDisplayed();
    }

    public boolean payByCheckBdd() {
        wait.until(ExpectedConditions.visibilityOf(proceedBtn));
        proceedBtn.click();
        wait.until(ExpectedConditions.visibilityOf(proceedBtn2));
        proceedBtn2.click();
        wait.until(ExpectedConditions.visibilityOf(agreeToTerms));
        agreeToTerms.click();
        wait.until(ExpectedConditions.visibilityOf(proceedBtn3));
        proceedBtn3.click();
        wait.until(ExpectedConditions.visibilityOf(payByCheckBtn));
        payByCheckBtn.click();
        wait.until(ExpectedConditions.visibilityOf(orderSummaryTitleForCheck));
        return orderSummaryTitleForCheck.isDisplayed();
    }

    public boolean payByWireBdd() {
        wait.until(ExpectedConditions.visibilityOf(proceedBtn));
        proceedBtn.click();
        wait.until(ExpectedConditions.visibilityOf(proceedBtn2));
        proceedBtn2.click();
        wait.until(ExpectedConditions.visibilityOf(agreeToTerms));
        agreeToTerms.click();
        wait.until(ExpectedConditions.visibilityOf(proceedBtn3));
        proceedBtn3.click();
        wait.until(ExpectedConditions.visibilityOf(payByWireBtn));
        payByWireBtn.click();
        wait.until(ExpectedConditions.visibilityOf(orderSummaryTitleForWire));
        return orderSummaryTitleForWire.isDisplayed();
    }

    public Boolean confirm() {
        wait.until(ExpectedConditions.visibilityOf(confirmBtn));
        confirmBtn.click();
        wait.until(ExpectedConditions.visibilityOf(orderCompleteMsg));
        return orderCompleteMsg.isDisplayed();
    }
}
