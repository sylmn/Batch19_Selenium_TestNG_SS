package com.eurotech.tests.day_04_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C06_ByLinkText {
    public static void main(String[] args) throws InterruptedException {
        /**
         * open chrome browser and navigate to http://www.eurotech.study/
         * accept cookies if any
         * locate Login button web element by using link text locator
         * get the text of web element and print it
         * click to the web element
         * close driver.
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://www.eurotech.study/");

        Thread.sleep(2000);

        //accept cookies if any  lazy way
        driver.findElement(By.id("rcc-confirm-button")).click();


        WebElement loginBtn = driver.findElement(By.linkText("Login"));

        String loginBtnText = loginBtn.getText();

        System.out.println("loginBtnText = " + loginBtnText);

        Thread.sleep(2000);

        loginBtn.click();
        Thread.sleep(2000);

        driver.close();

    }
}
