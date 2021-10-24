package com.automationpractice.qa.base;

import com.automationpractice.qa.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static Properties properties;
    public static WebDriverWait wait;

    public TestBase(){

        try {
            properties = new Properties();
            FileInputStream stream = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/automationpractice/qa/config/config.properties");
            properties.load(stream);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void init() {
        if(properties.getProperty("browser").equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/libs/chromedriver");
            driver = new ChromeDriver();
        } else if(properties.getProperty("browser").equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/libs/geckodriver");
            driver = new FirefoxDriver();
        }
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(properties.getProperty("url"));
        wait = new WebDriverWait(driver,30);

    }

}
