package com.automationpractice.qa.pages;

import com.automationpractice.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends TestBase {
    @FindBy(xpath = "//h1[@class='page-heading']")
    WebElement accountTitle;

    public AccountPage() {
        PageFactory.initElements(driver, this);
    }

    public Boolean validateAccountPage() {
        return accountTitle.isDisplayed();
    }
}
