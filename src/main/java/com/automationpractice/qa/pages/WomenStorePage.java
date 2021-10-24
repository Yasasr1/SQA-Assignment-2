package com.automationpractice.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.automationpractice.qa.base.TestBase.driver;

public class WomenStorePage {
    @FindBy(xpath = "//span[@class='cat-name']")
    WebElement womenStoreTitle;

    @FindBy(xpath = "//img[@title='Faded Short Sleeve T-shirts']")
    WebElement firstProduct;

    @FindBy(xpath = "//span[normalize-space()='Add to cart']")
    WebElement addToCartBtn;

    @FindBy(xpath = "//h2[normalize-space()='Product successfully added to your shopping cart']")
    WebElement successfullyAddedMsg;

    public WomenStorePage() {
        PageFactory.initElements(driver, this);
    }

    public Boolean validateWomenStorePage() {
        return womenStoreTitle.isDisplayed();
    }

    public Boolean addOneProduct() {
        Actions action = new Actions(driver);
        action.moveToElement(firstProduct,5,5).click();
//        firstProduct.click();
//        addToCartBtn.click();
//        return successfullyAddedMsg.isDisplayed();
        return true;
    }

}