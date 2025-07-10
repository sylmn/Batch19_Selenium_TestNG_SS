package com.eurotech.tests.day_15_properties_singleton;

import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class C_05_LoginTest extends TestBase {
    /**
     * navigate to https://sdettest.eurotechstudy.eu
     * enter the webpage with valid credentials
     */
//    WebDriver driver;
//
//    @BeforeMethod
//    public void setUp(){
//        driver= Driver.get();
//        driver.get(ConfigurationReader.get("url"));
//
//    }
//
//    @AfterMethod
//    public void tearDown() throws InterruptedException {
//        Thread.sleep(2000);
//        Driver.closeDriver();
//    }



    @Test
    public void loginTest() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.id("email")).sendKeys(ConfigurationReader.get("userEmail"));
        Thread.sleep(1000);
        driver.findElement(By.id("yourPassword")).sendKeys(ConfigurationReader.get("password"));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button")).click();
    }


}
