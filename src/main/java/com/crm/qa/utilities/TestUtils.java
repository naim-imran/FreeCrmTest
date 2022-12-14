package com.crm.qa.utilities;

import com.crm.qa.initialComponents.InitialSetups;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestUtils extends InitialSetups {

    FileInputStream fs;
    Workbook workBook;
    Sheet workSheet;

    public void switchToFrameCRM() {
        driver.switchTo().frame("mainpanel");
    }

    public Object[][] getTestData(String sheetName, String excelFilePath) {
        try {
            fs = new FileInputStream(System.getProperty("user.dir") + excelFilePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            workBook = WorkbookFactory.create(fs);
        } catch (EncryptedDocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        workSheet = workBook.getSheet(sheetName);
        Object[][] data = new Object[workSheet.getLastRowNum()][workSheet.getRow(0).getLastCellNum()];

        for (int i = 0; i < workSheet.getLastRowNum(); i++) {
            for (int j = 0; j < workSheet.getRow(0).getLastCellNum(); j++) {
                data[i][j] = workSheet.getRow(i + 1).getCell(j).toString();
            }
        }
        return data;

    }

}
