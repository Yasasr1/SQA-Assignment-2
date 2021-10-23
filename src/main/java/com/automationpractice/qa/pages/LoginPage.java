package com.automationpractice.qa.pages;

import com.automationpractice.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    @FindBy(xpath = "//span[normalize-space()='Sign in']")
    WebElement loginBtn;

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@id='passwd']")
    WebElement passwordField;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public Boolean validateLoginPage() {
        return loginBtn.isDisplayed();
    }

    public AccountPage login(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginBtn.click();
        return new AccountPage();
    }
}
