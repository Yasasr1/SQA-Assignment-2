package com.automationpractice.qa.util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;


import java.io.File;

public class TestUtil {
    public static int PAGE_LOAD_TIMEOUT = 120;
    public static int IMPLICIT_WAIT = 30;
    public static String SCREENSHOT_PATH = "/src/main/java/com/automationpractice/qa/testdata/";

    public static void takeScreenshot(WebDriver webdriver, String fileWithPath) throws Exception {
        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(fileWithPath);
        FileUtils.copyFile(SrcFile, DestFile);

    }
}
