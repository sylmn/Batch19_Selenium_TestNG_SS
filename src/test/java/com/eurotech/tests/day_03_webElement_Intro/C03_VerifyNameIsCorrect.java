package com.eurotech.tests.day_03_webElement_Intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C03_VerifyNameIsCorrect {
    public static void main(String[] args) throws InterruptedException {
        /**
         * Task
         * open chrome browser
         * go to "https://demoqa.com/login"
         * enter "test" into the username box
         * VERIFY that "test" is displayed in the username box
         * enter "Test.!123" into the password box
         * click on login button
         * VERIFY that username is "test"
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/login");
        String expectedText="test";
        WebElement userName = driver.findElement(By.id("userName"));
        userName.sendKeys("test");
        Thread.sleep(1000);
        String actualText = userName.getAttribute("value");
        if (actualText.equals(expectedText)) {
            System.out.println("Passed");
        }else{
            System.out.println("Failed");}

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Test.!123");

        WebElement loginBtn = driver.findElement(By.id("login"));
        loginBtn.click();
        Thread.sleep(4000);

        WebElement userNameText = driver.findElement(By.id("userName-value"));
        String actualUserNameText = userNameText.getText();
        String expectedUserNameText="test";

        if (actualUserNameText.equals(expectedUserNameText))
            System.out.println("Pass");
        else
            System.out.println("Fail");
        driver.close();
    }
}
