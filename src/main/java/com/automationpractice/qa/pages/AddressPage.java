package com.automationpractice.qa.pages;

import com.automationpractice.qa.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.ArrayList;

import static com.automationpractice.qa.base.TestBase.driver;

public class AddressPage {
    @FindBy(xpath = "//input[@id='firstname']")
    WebElement nameField;

    @FindBy(xpath = "//input[@id='lastname']")
    WebElement name2Field;

    @FindBy(xpath = "//input[@id='company']")
    WebElement companyField;

    @FindBy(xpath = "//span[normalize-space()='Save']")
    WebElement saveBtn;

    public AddressPage() {
        PageFactory.initElements(driver, this);
    }

    public CheckoutPage updateAddress() {
        ArrayList<String> words;
        try {
            String filePath = System.getProperty("user.dir") + "/src/main/java/com/automationpractice/qa/testdata/";
            words = TestUtil.readExcel(filePath, "data.xlsx", "Sheet1");
            nameField.clear();
            name2Field.clear();
            companyField.clear();
            nameField.sendKeys(words.get(0));
            name2Field.sendKeys(words.get(1));
            companyField.sendKeys(words.get(2));
            saveBtn.click();
        } catch (IOException e) {
            System.out.println(e);
        }

        return new CheckoutPage();
    }
}
