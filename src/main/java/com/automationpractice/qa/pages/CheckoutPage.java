package com.automationpractice.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.automationpractice.qa.base.TestBase.driver;
import static com.automationpractice.qa.base.TestBase.wait;

public class CheckoutPage {

    @FindBy(xpath = "//h1[@id='cart_title']")
    WebElement cartTitle;

    @FindBy(xpath = "//span[@id='total_price'][text()=\"$18.51\"]")
    WebElement totalPrice;

    @FindBy(xpath = "//i[@class='icon-plus']")
    WebElement plusBtn;

    @FindBy(xpath = "//span[@id='total_price'][text()=\"$35.02\"]")
    WebElement totalPrice2;

    public CheckoutPage() {
        PageFactory.initElements(driver, this);
    }

    public Boolean validateCheckoutPage() {
        return cartTitle.isDisplayed();
    }

    public Boolean verifyTotalCost() {
        return totalPrice.isDisplayed();
    }

    public Boolean plusOneItem(){
        plusBtn.click();
        wait.until(ExpectedConditions.visibilityOf(totalPrice2));
        return totalPrice2.isDisplayed();
    }


}
