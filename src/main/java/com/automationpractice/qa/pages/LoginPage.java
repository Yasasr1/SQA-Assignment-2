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

    @FindBy(xpath = "//li[normalize-space()='An email address required.']")
    WebElement noEmail;

    @FindBy(xpath = "//li[normalize-space()='Invalid email address.']")
    WebElement invalidEmail;

    @FindBy(xpath = "//li[normalize-space()='Password is required.']")
    WebElement noPassword;

    @FindBy(xpath = "//li[normalize-space()='Invalid password.']")
    WebElement invalidPassword;

    @FindBy(xpath = "//li[normalize-space()='Authentication failed.']")
    WebElement authenticationFail;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public Boolean validateLoginPage() {
        return loginBtn.isDisplayed();
    }

    public Boolean validateNoEmail(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginBtn.click();
        return noEmail.isDisplayed();
    }

    public Boolean validateInvalidEmail(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginBtn.click();
        return invalidEmail.isDisplayed();
    }

    public Boolean validateIncorrectEmail(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginBtn.click();
        return authenticationFail.isDisplayed();
    }

    public Boolean validateNoPassword(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginBtn.click();
        return noPassword.isDisplayed();
    }

    public Boolean validateInvalidPassword(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginBtn.click();
        return invalidPassword.isDisplayed();
    }

    public Boolean validateIncorrectPassword(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginBtn.click();
        return authenticationFail.isDisplayed();
    }


    public AccountPage login(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginBtn.click();
        return new AccountPage();
    }
}
