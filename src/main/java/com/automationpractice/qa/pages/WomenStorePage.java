package com.automationpractice.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.automationpractice.qa.base.TestBase.driver;
import static com.automationpractice.qa.base.TestBase.wait;

public class WomenStorePage {
    @FindBy(xpath = "//span[@class='cat-name']")
    WebElement womenStoreTitle;

    @FindBy(xpath = "//img[@title='Faded Short Sleeve T-shirts']")
    WebElement firstProduct;

    @FindBy(xpath = "//li[@class='ajax_block_product first-in-line first-item-of-tablet-line first-item-of-mobile-line col-xs-12']//span[contains(text(),'Add to cart')]")
    WebElement addToCartBtn;

    @FindBy(xpath = "//li[@class='ajax_block_product last-item-of-tablet-line col-xs-12']//span[contains(text(),'Add to cart')]")
    WebElement addToCartBtn2;

    @FindBy(xpath = "//h2[normalize-space()='Product successfully added to your shopping cart']")
    WebElement successfullyAddedMsg;

    @FindBy(xpath = "//i[@class='icon-th-list']")
    WebElement listView;

    @FindBy(xpath = "//span[@title='Close window']")
    WebElement closeWindow;

    @FindBy(xpath = "//li[@class='ajax_block_product first-in-line first-item-of-tablet-line first-item-of-mobile-line col-xs-12']//span[contains(text(),'More')]")
    WebElement moreBtn;

    public WomenStorePage() {
        PageFactory.initElements(driver, this);
    }

    public Boolean validateWomenStorePage() {
        return womenStoreTitle.isDisplayed();
    }

    public Boolean addOneProduct() {
        listView.click();
        addToCartBtn.click();
        wait.until(ExpectedConditions.visibilityOf(successfullyAddedMsg));
        return successfullyAddedMsg.isDisplayed();
    }

    public Boolean addMultipleProduct() {
        listView.click();
        addToCartBtn.click();
        wait.until(ExpectedConditions.visibilityOf(closeWindow));
        closeWindow.click();
        addToCartBtn2.click();
        wait.until(ExpectedConditions.visibilityOf(successfullyAddedMsg));
        return successfullyAddedMsg.isDisplayed();
    }

    public ProductPage clickMore(){
        listView.click();
        moreBtn.click();
        return new ProductPage();
    }

}