package com.eurotech.tests.day_04_basic_locators;

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

        //accept cookies if any  lazy way
        driver.findElement(By.id("rcc-confirm-button")).click();

        //locate main paragraph web element by using class name locator
        WebElement mainPragraph = driver.findElement(By.className("lead"));

        //get the text of web element and print it
        String text = mainPragraph.getText();

        System.out.println("text = " + text);


        driver.close();


    }
}

/**
 * 1. dinamik olmazlar
 * 2. çoğunlukla birden fazla web elementin class name attribute değeri aynı olabiir. selenium bu durumda ilkine gider
 * ve işlem yapar
 * 3. unique olup olmadığını dev tool da ctrl+f classname değerinin başına "." işareti koyarak anlazrız
 * 4. class name değeri genellikle içerisinde boşluk içerir. bu durumda by.classname ile kullanamayız --- css e başvurmak gerekir
 *
 */
