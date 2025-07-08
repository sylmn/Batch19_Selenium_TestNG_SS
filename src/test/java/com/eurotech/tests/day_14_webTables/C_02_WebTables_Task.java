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



    }
}
