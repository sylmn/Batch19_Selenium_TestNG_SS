package com.eurotech.tests.day_03_webElement_Intro;

import com.eurotech.utilities.WebDriverFactory;
import com.sun.security.jgss.GSSUtil;
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
         * VERIFY that url is not changed (https://demoqa.com/login)
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");

     //   driver.navigate().to("https://demoqa.com/login");

            driver.get("https://demoqa.com/login");

//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        Thread.sleep(2000);

        //expected url i kaydedelim
        String expectedUrl = driver.getCurrentUrl();

        System.out.println("expectedUrl = " + expectedUrl);

        // locate login button and pu it in a webElement bucket

        WebElement loginBtn = driver.findElement(By.id("login"));

        // click on login button through click() method
        loginBtn.click();

        //actual url i kaydedelim
        String actualUrl= driver.getCurrentUrl();


        // let us test it
        if (actualUrl.equals(expectedUrl)){
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        driver.close();
    }
}
