package com.eurotech.tests.day_15_properties_singleton;

import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C_06_LoginTest_2 extends TestBase {
    @Test
    public void loginTest() throws InterruptedException {
        /**
         * go to eurotechstudy login page
         * login with your credentials
         * validate that you are on the dashboard with url
         * https://sdettest.eurotechstudy.eu/index
         */


        driver.findElement(By.id("email")).sendKeys(ConfigurationReader.get("userEmail"));
        driver.findElement(By.id("yourPassword")).sendKeys(ConfigurationReader.get("password"));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Leeroy']")));

        Thread.sleep(1000);
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://sdettest.eurotechstudy.eu/index";

        Assert.assertEquals(actualUrl,expectedUrl);
    }
    @Test
    public void loginTest_2(){
        /**
         * go to eurotechstudy login page
         * login with your credentials
         * validate that you are on the dashboard with page title is:
         * Dashboard - EuroTech Lab - aFm
         */


        driver.findElement(By.id("email")).sendKeys(ConfigurationReader.get("userEmail"));
        driver.findElement(By.id("yourPassword")).sendKeys(ConfigurationReader.get("password"));
        driver.findElement(By.xpath("//button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Leeroy']")));

        String actualTitle = driver.getTitle();
        String expectedTitle = "Dashboard - EuroTech Lab - aFm";

        Assert.assertEquals(actualTitle,expectedTitle);
    }
    public void loginTest_3_Task(){
        /** TASK
         * go to eurotechstudy login page
         * login with your credentials
         * validate that you are on the dashboard with page email is :
         * leeroyjenkins@email.com
         */


        driver.findElement(By.id("email")).sendKeys(ConfigurationReader.get("userEmail"));
        driver.findElement(By.id("yourPassword")).sendKeys(ConfigurationReader.get("password"));
        driver.findElement(By.xpath("//button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Leeroy']")));

        String actualUserName = driver.findElement(By.xpath("(//div[@class=\"col-lg-9 col-md-8\"])[5]")).getText();
        String expectedUserName = ConfigurationReader.get("userEmail");

        Assert.assertEquals(actualUserName,expectedUserName);


    }
}
