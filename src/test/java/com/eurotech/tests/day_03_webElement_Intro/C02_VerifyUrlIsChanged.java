package com.eurotech.tests.day_03_webElement_Intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C02_VerifyUrlIsChanged {
    public static void main(String[] args) throws InterruptedException {
        /**
         * Task
         * open chrome browser
         * go to "https://demoqa.com/login"
         * enter "test" into the username box
         * enter "Test.!123" into the password box
         * click on login button
         * VERIFY that url is changed as "https://demoqa.com/profile" (expected)
         */


        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://demoqa.com/login");

        Thread.sleep(2000);

        // locate username box
        WebElement usernameBox = driver.findElement(By.id("userName"));

        // send value to username box
        usernameBox.sendKeys("test");

        Thread.sleep(1000);

        // locate password box
        //   WebElement passwordBox = driver.findElement(By.id("password"));       // id locator
        WebElement passwordBox = driver.findElement(By.cssSelector("[placeholder='Password']")); //css locator

        //send value to password box
        passwordBox.sendKeys("Test.!123");

        Thread.sleep(1000);

        // locate login button and pu it in a webElement bucket
        WebElement loginBtn = driver.findElement(By.id("login"));

        // click on login button through click() method
        loginBtn.click();
        System.out.println("URL = " + driver.getCurrentUrl());

        Thread.sleep(3000);

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl="https://demoqa.com/profile";

        if (actualUrl.equals(expectedUrl)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }

        driver.close();
    }
}
