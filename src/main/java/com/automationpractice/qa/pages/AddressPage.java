package com.automationpractice.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.automationpractice.qa.base.TestBase.driver;

public class AddressPage {
    @FindBy(xpath = "//input[@id='firstname']")
    WebElement nameField;

    @FindBy(xpath = "//input[@id='lastname']")
    WebElement name2Field;

    @FindBy(xpath = "//input[@id='company']")
    WebElement companyField;

    public AddressPage() {
        PageFactory.initElements(driver, this);
    }

    public CheckoutPage updateAddress(){
        nameField.clear();
        name2Field.clear();
        companyField.clear();
        nameField.sendKeys("name");
        name2Field.sendKeys("name");
        companyField.sendKeys("name");
        return new CheckoutPage();
    }
}
