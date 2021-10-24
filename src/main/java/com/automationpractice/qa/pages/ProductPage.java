package com.automationpractice.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.automationpractice.qa.base.TestBase.driver;
import static com.automationpractice.qa.base.TestBase.wait;

public class ProductPage {
    @FindBy(xpath = "//input[@id='quantity_wanted']")
    WebElement qntField;

    @FindBy(xpath = "//span[normalize-space()='Add to cart']")
    WebElement addToCartBtn;

    @FindBy(xpath = "//span[@id='layer_cart_product_quantity'][text()=\"2\"]")
    WebElement qntNumber2;

    @FindBy(xpath = "//a[@id='color_14']")
    WebElement blueColorBtn;

    @FindBy(xpath = "//span[@id='layer_cart_product_attributes'][text()=\"Blue, S\"]")
    WebElement blueColorTag;

    public ProductPage() {
        PageFactory.initElements(driver, this);
    }

    public Boolean addMultipleItems() {
        qntField.clear();
        qntField.sendKeys("2");
        addToCartBtn.click();
        wait.until(ExpectedConditions.visibilityOf(qntNumber2));
        return qntNumber2.isDisplayed();
    }

    public Boolean changeColor() {
        blueColorBtn.click();
        addToCartBtn.click();
        wait.until(ExpectedConditions.visibilityOf(blueColorTag));
        return blueColorTag.isDisplayed();
    }

}
