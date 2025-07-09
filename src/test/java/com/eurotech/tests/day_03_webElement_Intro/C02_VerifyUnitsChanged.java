package com.eurotech.tests.day_03_webElement_Intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C02_VerifyUnitsChanged {
    public static void main(String[] args) throws InterruptedException {
        /**
         * Task
         * open chrome browser
         * go to "https://demoqa.com/login"
         * enter "test" into the username box
         * enter "Test.!123" into the password box
         * click on login button
         * VERIFY that url is changed as "https://demoqa.com/profile"
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/login");
        Thread.sleep(2000);

        WebElement userName = driver.findElement(By.id("userName"));
        //userName.click();
        userName.sendKeys("test");

        WebElement password = driver.findElement(By.id("password"));
        //WebElement passwordBox= driver.findElement(By.cssSelector("[placeholder=\"Password\"]"));
        //password.click();
        password.sendKeys("Test.!123");

        WebElement loginBtn = driver.findElement(By.id("login"));
        loginBtn.click();
        Thread.sleep(3000);

        String actuelUrl = driver.getCurrentUrl();
        String expectedUrl = "https://demoqa.com/profile";

        if (actuelUrl.equals(expectedUrl))
            System.out.println("passed");
        else
            System.out.println("failed");

        driver.quit();
    }
}
