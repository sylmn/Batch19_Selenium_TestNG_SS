package com.eurotech.tests.day_14_webTables;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C_01_WebTables {
    WebDriver driver;


    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/tables");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void printWholeTable() {
        /**
         * use xpath only
         */

        /**
         * navigate to https://the-internet.herokuapp.com/tables
         * get the whole data from table (including column headers)
         * verify that the table contains fbach@yahoo.com
         * and print all table datas
         */

        // driver.get("https://the-internet.herokuapp.com/tables");  bütün testlerde bu url kullanıldığı için
        // before'a alındı.

        WebElement table = driver.findElement(By.xpath("//table[@id='table1']"));

        String wholeTable = table.getText();

        System.out.println(wholeTable);

        String expectedText = "fbach@yahoo.com";

        Assert.assertTrue(wholeTable.contains(expectedText));

    }

    @Test
    public void getAllColumnHeaders() {
        /**
         * navigate to https://the-internet.herokuapp.com/tables
         * get the column headers (as a one string)
         * verify that the column headers contains First Name
         * and print all headers' name
         */

        WebElement columnHeaders = driver.findElement(By.xpath("//table[@id='table1']/thead/tr"));

        String columnHeadersText = columnHeaders.getText();

        String expectedText = "First Name";

        Assert.assertTrue(columnHeadersText.contains(expectedText));

        System.out.println("columnHeadersText = " + columnHeadersText);
    }

    @Test
    public void getColumnHeadersOneByOne() {
        /**
         * navigate to https://the-internet.herokuapp.com/tables
         * get all web elements of column names  to a list (one by one)
         * print all column names
         */

        List<WebElement> columnHeaders = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));

        columnHeaders.forEach(header -> System.out.println(header.getText()));

        System.out.println("-------------------------");

        for (WebElement columnHeader : columnHeaders) {
            System.out.println(columnHeader.getText());
        }

        System.out.println("columnHeaders.get(1).getText() = " + columnHeaders.get(1).getText());
    }

    @Test
    public void getSingleRow() {
        /**
         * navigate to https://the-internet.herokuapp.com/tables
         * get the second row info and print it
         * get all row and print them
         * get 3. row dynamically and print them
         */

        WebElement secondRow = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]"));
        System.out.println("secondRow.getText() = " + secondRow.getText());

        System.out.println("----------------------");

        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

        for (WebElement singleRow : allRows) {
            System.out.println(singleRow.getText());
        }

        int row = 3;
        String dynamicallyRowText = dataOfRow(row);

        System.out.println("dynamicallyRowText = " + dynamicallyRowText);
    }

    @Test
    public void getAllCellsInOneRow(){
        /**
         * navigate to https://the-internet.herokuapp.com/tables
         * get the second row info cell by cell and print it
         */

        List<WebElement> secondRowCells = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[2]/td"));

        for (WebElement rowCell : secondRowCells) {
            System.out.println("rowCell.getText() = " + rowCell.getText());
        }

        //due
        System.out.println("due = " + secondRowCells.get(3).getText());
    }

    @Test
    public void getSingleCellDataWithRowAndColumn(){
        /**  CLASS TASK
         * navigate to https://the-internet.herokuapp.com/tables
         * get the data of specific cell by using row and column numbers
         */

        ////table[@id='table1']/tbody/tr[4]/td[5]
        
        int numberOfColumns = getNumberOfColumns();
        int numberOfRows = getNumberOfRows();

        System.out.println("numberOfColumns = " + numberOfColumns);
        System.out.println("numberOfRows = " + numberOfRows);

        String dataOfAnyCell = dataOfCell(3,4);
        System.out.println("dataOfAnyCell = " + dataOfAnyCell);

        //bütün tablo

        for (int i = 1; i <=numberOfRows ; i++) {
            for (int j = 1; j <=numberOfColumns ; j++) {
                System.out.print(dataOfCell(i, j)+ " - ");
            }
            System.out.println();
        }
    }

    private String dataOfCell(int row, int column) {
        String xPathOfAnyCell = "//table[@id='table1']/tbody/tr["+row+"]/td["+column+"]";
        WebElement anyCell = driver.findElement(By.xpath(xPathOfAnyCell));
        return anyCell.getText();
    }

    private int getNumberOfRows() {
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        return rows.size();
    }

    private int getNumberOfColumns() {
        List<WebElement> columns = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
        return columns.size();
    }


    private String dataOfRow(int rowNumber) {
        String eachRowXPath = "//table[@id='table1']/tbody/tr["+rowNumber+"]";
        return driver.findElement(By.xpath(eachRowXPath)).getText();
    }
}
