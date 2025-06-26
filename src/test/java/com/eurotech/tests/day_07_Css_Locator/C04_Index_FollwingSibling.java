package com.eurotech.tests.day_07_Css_Locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C04_Index_FollwingSibling {
    public static void main(String[] args) throws InterruptedException {
        /**
         * navigate to https://demoqa.com/automation-practice-form
         * send "hasan@hasan.com" to email box with css index
         * send "Bağcılar/İstanbul" to current address box with css sibling
         * close driver
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/automation-practice-form");
        Thread.sleep(2000);

        // send "hasan@hasan.com" to email box with css index
        WebElement emailBox = driver.findElement(By.cssSelector("[id='userEmail-wrapper']>div:nth-child(2)>input"));
        emailBox.sendKeys("hasan@hasan.com");

        Thread.sleep(2000);

        //send "Bağcılar/İstanbul" to current address box with css sibling
        WebElement addressBox = driver.findElement(By.cssSelector("form>div#currentAddress-wrapper>div~div>[placeholder='Current Address']"));
        addressBox.sendKeys("Bağcılar/İstanbul");

        Thread.sleep(2000);
        driver.close();
    }
}
