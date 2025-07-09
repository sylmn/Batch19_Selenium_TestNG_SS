package com.eurotech.tests.day_03_webElement_Intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C04_GetAttribute_Practice {
    public static void main(String[] args) throws InterruptedException {

        /** Task
         * [x] open chrome browser
         * [x] go to http://www.eurotech.study/
         * [x] click I understand button and accept cookies
         * [x]take the value of the attributes (class and href) of the login button and print the values.
         * [x]click login button
         * [x]send "sdfsdsd" into email address input box
         * [x]click Login button
         * [x]get the message which appears on the email input box
         * [x]VERIFY that the message contains "Please include an '@' in the email address."
         * Lütfen e-posta adresine bir "@" işareti ekleyin. "sdfsdsd" adresinde "@" eksik.
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://www.eurotech.study/");
        Thread.sleep(2000);

        WebElement buttonUnderstand = driver.findElement(By.id("rcc-confirm-button"));
        buttonUnderstand.click();

        WebElement buttonLogin = driver.findElement(By.cssSelector("[class=\"btn btn-light\"]"));
        System.out.println("class Atribute = " + buttonLogin.getAttribute("class"));
        System.out.println("href Atribute = " + buttonLogin.getAttribute("href"));
        buttonLogin.click();
        Thread.sleep(3000);

        WebElement emailBox = driver.findElement(By.id("loginpage-input-email"));
        emailBox.sendKeys("sdfsdsd");

        WebElement buttonLogin2 = driver.findElement(By.id("loginpage-form-btn"));
        buttonLogin2.click();

        String validationMessage = emailBox.getAttribute("validationMessage");
        System.out.println("validationMessage = " + validationMessage);
        Thread.sleep(2000);
        String expectedMessage = "Lütfen e-posta adresine bir \"@\" işareti ekleyin. \"sdfsdsd\" adresinde \"@\" eksik.";

        if (validationMessage.equals(expectedMessage))
            System.out.println("passed");
        else
            System.out.println("failed");

        driver.quit();
    }
}
