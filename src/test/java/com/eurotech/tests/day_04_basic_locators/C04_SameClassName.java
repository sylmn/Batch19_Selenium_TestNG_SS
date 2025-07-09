package com.eurotech.tests.day_04_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C04_SameClassName {
    public static void main(String[] args) throws InterruptedException {

/**
 * open chrome browser and navigate to https://demoqa.com/text-box
 * locate Full Name label web element by using class name locator
 * get the text of web element and print it
 * close driver.
 */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/text-box");
        Thread.sleep(2000);

        WebElement fullName = driver.findElement(By.className("form-label"));
        String text = fullName.getText();
        System.out.println("text = " + text);
driver.close();
    }
}
