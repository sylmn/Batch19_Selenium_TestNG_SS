package com.eurotech.tests.day_04_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C08_BasicLocatorReview {
    public static void main(String[] args) throws InterruptedException {

        /**
         * Task
         * open a chrome browser driver and navigate to https://www.demoblaze.com/
         * locate Sign up link by using id and get text of web element then print the text
         * locate BOTH OF previous and next link at the bottom of the page by using name and get text of web element then print the text
         * locate Samsung Galaxy S6 by using tagname and get text of web element then print the text
         * locate Product Store at the left top of the page by using class name and get text of web element then print the text
         * locate Nokia Lumia 1520 by using link text and get text of web element then print the text
         * locate Nexus 6 by using partial link text and get text of web element then print the text
         * close the driver
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("https://www.demoblaze.com/");

        Thread.sleep(1000);

        // locate with ID
        WebElement signin2 = driver.findElement(By.id("signin2"));
        System.out.println("signin2.getText() = " + signin2.getText());

        //locate with Name

        WebElement previousAndNext = driver.findElement(By.name("frm"));
        System.out.println("previousAndNext.getText() = " + previousAndNext.getText());

        //locate with tag name

        WebElement galaxyS6 = driver.findElement(By.tagName("h4"));
        System.out.println("galaxyS6.getText() = " + galaxyS6.getText());

        // locate with className
        WebElement productStore = driver.findElement(By.className("navbar-brand"));
        System.out.println("productStore.getText() = " + productStore.getText());

        //locate with LinkText
        WebElement nokia = driver.findElement(By.linkText("Nokia lumia 1520"));
        System.out.println("nokia.getText() = " + nokia.getText());

        //locate with PartialLinkText

        WebElement nexus = driver.findElement(By.partialLinkText("us 6"));
        System.out.println("nexus.getText() = " + nexus.getText());

        Thread.sleep(1000);

        driver.close();
    }
}
