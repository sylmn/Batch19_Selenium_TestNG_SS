package com.eurotech.tests.day_20_DDF;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ExcelDemo {
    //excel dosya yolu
    //çalışacağım sheet adı
    //satır no
    //sütun no

    String readFromExcelCell(String path, String sheetName, int row, int column) throws IOException {
        FileInputStream fis = new FileInputStream(path);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet(sheetName);
        String cellValue = sheet.getRow(row).getCell(column).getStringCellValue();

        return cellValue;

    }

    @Test
    public void test1() throws IOException {
        String excelCellValue = readFromExcelCell("src/test/resources/LoginList.xlsx", "Test", 3, 1);
        System.out.println("excelCellValue = " + excelCellValue);
    }
}
