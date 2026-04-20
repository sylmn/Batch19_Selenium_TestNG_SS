package com.eurotech.tests.day_05_06_xPath;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C03_RelativeXPath_Contains_StartsWith {
    public static void main(String[] args) throws InterruptedException {
        /**
         * Task
         * open chrome browser
         * go to http://www.eurotech.study/
         * click I understand button and accept cookies (use xPath-contains text)
         * locate login button (use xPath - known attribute (class) )
         * click login button
         * locate email address input box (use xPath -starts-with (id))
         * send "abc" into email address input box
         * locate second login button (use xPath - * -> use star in xPath formula )
         * click Login button
         * get the message which appears on the email input box and print the message
         * VERIFY that the message contains "Please include an '@' in the email address."
         * close browser.
         */

        //* open chrome browser
        //* go to http://www.eurotech.study/
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://www.eurotech.study/");

        WebElement cookiesBtn = driver.findElement(By.xpath("//button[contains(text(),'I under')]"));
        cookiesBtn.click();

        Thread.sleep(2000);

        //* locate login button (use xPath - known attribute (class) )
        //* click login button
        WebElement loginBtn = driver.findElement(By.xpath("//a[@class='btn btn-light']"));
        loginBtn.click();

        //* locate email address input box (use xPath -starts-with (id))
        //* send "abc" into email address input box
        WebElement emailBox = driver.findElement(By.xpath("//input[starts-with(@id,'loginpage-i')]"));
        emailBox.sendKeys("abc");

        //* locate second login button (use xPath - * -> use star in xPath formula )
        //* click Login button
        WebElement secondLoginBtn = driver.findElement(By.xpath("//*[@*='Login']"));
        secondLoginBtn.click();

        //* get the message which appears on the email input box and print the message
        //* VERIFY that the message contains "Please include an '@' in the email address."

        String actualMessage = emailBox.getAttribute("validationMessage");
        String expectedMessage = "Please include an '@' in the email address.";

        if (actualMessage.contains(expectedMessage))
            System.out.println("Pass");
        else
            System.out.println("Fail..");

        Thread.sleep(2000);

        driver.close();
    }
}
