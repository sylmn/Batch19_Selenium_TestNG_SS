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

public class C_02_WebTables_Task {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    public void getSingleCellInOneRow() {

        /**
         * Task-1
         * navigate to https://webdriveruniversity.com/Data-Table/index.html
         * get the third cell of first row --> 45  and make verification
         * get the second cell of second row --> Jackson and make verification
         */
        driver.get("https://webdriveruniversity.com/Data-Table/index.html");
        //get the third cell of first row --> 45
        WebElement thirdCellOfFirstRow = driver.findElement(By.xpath("(//table[@id='t01']//td/..)[1]/td[3]"));
        String actualData = thirdCellOfFirstRow.getText();
        String expectedData = "45";
        Assert.assertEquals(actualData, expectedData);

        //get the second cell of second row --> Jackson
        WebElement secondCellOfSecondRow = driver.findElement(By.xpath("(//table[@id='t01']//td/..)[2]/td[2]"));
        String actualData_2 = secondCellOfSecondRow.getText();
        String expectedData_2 = "Jackson";
        Assert.assertEquals(actualData_2, expectedData_2);

    }

    @Test
    public void printAllCellsByIndex() {
        /**
         * Task-2
         * navigate to https://webdriveruniversity.com/Data-Table/index.html
         * get the data of specific cell by using row and column numbers
         * write separate methods for this purpose
         * print whole table data by using this method (except column headers)
         */

        driver.get("https://webdriveruniversity.com/Data-Table/index.html");

        //we would like to write a code that it will print all cells one by one
        int rowNumber = getNumberOfRows();
        int columnNumber = getNumberOfColumns();

        for (int i = 1; i <= rowNumber; i++) {
            for (int j = 1; j <= columnNumber; j++) {
                System.out.print(getSpecificCell(i, j) + " ");
            }
            System.out.println();
        }
    }
    private int getNumberOfRows() {
        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='t01']//td/.."));
        int rowNumber = allRowsWithoutHeader.size();
        return rowNumber;
    }

    private int getNumberOfColumns() {
        List<WebElement> elements = driver.findElements(By.xpath("//table[@id='t01']//th"));
        int columnNumber = elements.size();
        return columnNumber;
    }

    private String getSpecificCell(int row, int column) {
        String xPath = "(//table[@id='t01']//td/..)[" + row + "]/td[" + column + "]";
        WebElement cell = driver.findElement(By.xpath(xPath));
        return cell.getText();
    }
}
