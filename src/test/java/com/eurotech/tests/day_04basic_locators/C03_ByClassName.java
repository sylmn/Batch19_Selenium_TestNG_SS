package com.eurotech.tests.day_04basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C03_ByClassName {
    public static void main(String[] args) throws InterruptedException {

        /**
        * open chrome browser and navigate to http://www.eurotech.study/
        * accept cookies if any
        * locate main paragraph web element by using class name locator
        * get the text of web element and print it
        * close driver.
        */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://www.eurotech.study/");
        Thread.sleep(2000);

        WebElement buttonUnderstant = driver.findElement(By.id("rcc-confirm-button"));
        buttonUnderstant.click();
        WebElement mainParagraph = driver.findElement(By.className("lead"));

        String text = mainParagraph.getText();
        System.out.println("text = " + text);
        driver.close();
    }
}
