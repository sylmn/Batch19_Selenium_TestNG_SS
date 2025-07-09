package com.eurotech.tests.day_03_webElement_Intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_VerifyUrlIsNotChanged {
    public static void main(String[] args) throws InterruptedException {
        /**
         * Task
         * open chrome browser
         * go to https://demoqa.com/login
         * click on login button
         * VERIFY that url is not changed
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/login");
        Thread.sleep(2000);
        String expectedUrl = driver.getCurrentUrl();
        System.out.println("expectedUrl = " + expectedUrl);

        //get the login button and put in the webelement bucket
        WebElement loginBtn = driver.findElement(By.id("login"));
        loginBtn.click();
        String actuelUrl = driver.getCurrentUrl();

        if (actuelUrl.equals(expectedUrl)) {
            System.out.println("passed...!");
        } else {
            System.out.println("failed...!!!");
        }
        driver.quit();
    }
}
