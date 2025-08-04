package com.eurotech.tests.day_20_DDF;

import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class C02_ExcelUtilDemo {

    @Test
    public void readExcelFile_1() {
        /**
         * Create an object from ExcelUtil class
         * it accepts two arguments
         * argument 1 : location of the excel file (path)
         * argument 2 : sheet that we want to open (sheetName)
         */

        ExcelUtil excelData = new ExcelUtil("src/test/resources/LoginList.xlsx", "Test");

        //satır sayısını alalım
        System.out.println("excelData.rowCount() = " + excelData.rowCount());
    }

    @Test
    public void readExcelFile_2() {
        /**
         * Create an object from ExcelUtil class
         * it accepts two arguments
         * argument 1 : location of the excel file (path)
         * argument 2 : sheet that we want to open (sheetName)
         */

        ExcelUtil excelData = new ExcelUtil(ConfigurationReader.get("excelPath"), "Test");

        //sütun sayısını alalım
        int columnCount = excelData.columnCount();
        System.out.println("columnCount = " + columnCount);

        System.out.println("--------------------------");

        //sütun adlarını alalım
        List<String> columnsNames = excelData.getColumnsNames();
        System.out.println("columnsNames = " + columnsNames);

        System.out.println("--------------------------");
        //bütün tabloyu iki boyutlu arraye alalım
        String[][] dataArray = excelData.getDataArray();
        System.out.println("Arrays.deepToString(dataArray) = " + Arrays.deepToString(dataArray));
        System.out.println("--------------------------");

        //ilk satır olmadan bilgileri iki boyutlu arraye alalım
        String[][] dataArrayWithoutFirstRow = excelData.getDataArrayWithoutFirstRow();
        System.out.println("Arrays.deepToString(dataArrayWithoutFirstRow) = " + Arrays.deepToString(dataArrayWithoutFirstRow));
        System.out.println("--------------------------");

        // iki boyutlu arrayde belirli bir datayı almak istersem
        System.out.println("dataArrayWithoutFirstRow[1][1] = " + dataArrayWithoutFirstRow[1][1]);
        System.out.println("--------------------------");

        //bütün tabloyu maplerden oluşan bir liste alalım
        List<Map<String, String>> dataList = excelData.getDataList();

        System.out.println("dataList = " + dataList);
        System.out.println("--------------------------");
        System.out.println("dataList.get(5).get(\"Last Name\") = " + dataList.get(5).get("Last Name"));
        System.out.println("dataList.get(9).get(\"City\") = " + dataList.get(9).get("City"));
        System.out.println("dataList.get(4).get(\"Company\") = " + dataList.get(4).get("Company"));
    }
}
