package com.eurotech.tests.day_04_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C02_ByName {
    public static void main(String[] args) throws InterruptedException {
        /**
         * open chrome browser and navigate to https://testpages.herokuapp.com/styled/basic-html-form-test.html
         * locate username input box by using name locator
         * send a random name to the box
         * clear the box
         * send another name to the box
         * get the second name which sent to the box and assign it to a string variable
         * print the second name
         * make verification
         * close driver.
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

        Thread.sleep(3000);

        //locate username input box by using name locator
        WebElement usernameBox = driver.findElement(By.name("username"));

        Faker faker = new Faker();
        String name1= faker.name().fullName();

        usernameBox.sendKeys(name1);

        Thread.sleep(2000);

        usernameBox.clear();

        String name2= faker.name().fullName();
        usernameBox.sendKeys(name2);

        Thread.sleep(2000);

        String actual = usernameBox.getAttribute("name");

        if (actual.equals(name2)){
            System.out.println("pass");
        }else {
            System.out.println("fail");
        }
        driver.close();
    }
}

/**
 * 1. name ler id ler gibi dinamik olmaz
 * 2. ancak birden fazla web elementin name attribute değeri aynı olabilir. Bu durumda
 * name ile locate ederisek selenium her zaman ilk web elemente gide ve işlem yapar
 */
