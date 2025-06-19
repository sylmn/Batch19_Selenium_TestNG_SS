package com.eurotech.tests.day_04basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C02_ByName {
    public static void main(String[] args) throws InterruptedException {
        /**
        * [x] open chrome browser and navigate to https://testpages.herokuapp.com/styled/basic-html-form-test.html
        * [x] locate username input box by using name locator
        * [x] end a random name to the box
        * [x] clear the box
        * [x] send another name to the box
        * [x] get the second name which sent to the box and assign it to a string variable
        * [x] print the second name
        * [x] make verification
        * [x] close driver.
        */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
        Thread.sleep(2000);

        WebElement usernameTxtBox = driver.findElement(By.name("username"));
        Faker faker = new Faker();
        String name1 = faker.name().fullName();
        usernameTxtBox.sendKeys(name1);

        Thread.sleep(2000);
        usernameTxtBox.clear();
        String name2 = faker.name().fullName();
        System.out.println("name2 = " + name2);
        usernameTxtBox.sendKeys(name2);
        Thread.sleep(2000);

        String actual = usernameTxtBox.getAttribute("value");
        if (actual.equals(name2))
            System.out.println("passed");
        else
            System.out.println("failed");
        driver.close();



    }
}
