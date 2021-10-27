package com.automationpractice.qa.util;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

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

    public static ArrayList<String> readExcel(String filePath, String fileName, String sheetName) throws IOException {
        ArrayList<String> wordList = new ArrayList<String>();
        File file = new File(filePath + fileName);
        FileInputStream inputStream = new FileInputStream(file);
        Workbook automationPracticeWorkbook = null;
        String fileExtensionName = fileName.substring(fileName.indexOf("."));

        if (fileExtensionName.equals(".xlsx")) {
            automationPracticeWorkbook = new XSSFWorkbook(inputStream);

        } else if (fileExtensionName.equals(".xls")) {
            automationPracticeWorkbook = new HSSFWorkbook(inputStream);

        }

        assert automationPracticeWorkbook != null;
        Sheet automationPracticeSheet = automationPracticeWorkbook.getSheet(sheetName);
        int rowCount = automationPracticeSheet.getLastRowNum() - automationPracticeSheet.getFirstRowNum();

        for (int i = 1; i < rowCount + 1; i++) {
            Row row = automationPracticeSheet.getRow(i);
            for (int j = 0; j < row.getLastCellNum(); j++) {
                wordList.add(row.getCell(j).getStringCellValue());
            }
        }
        return wordList;
    }
}
