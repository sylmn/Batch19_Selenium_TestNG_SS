package com.eurotech.tests.day_04_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C09_BasicLocatorTask {
    public static void main(String[] args) throws InterruptedException {
        /** Class Task
         * go to the url - "https://www.browserstack.com/users/sign_up"
         * maximize the window
         * accept cookies if any ,
         * fill in the blanks with the faker class
         * click "Term of service" checkbox
         * and close the window
         *
         * hint: u can use any locator you want
         *
         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.browserstack.com/users/sign_up");

        Faker faker = new Faker();

        WebElement fullNameBox = driver.findElement(By.name("user[full_name]"));
        fullNameBox.sendKeys(faker.name().fullName());

        WebElement emailBox = driver.findElement(By.id("user_email_login"));
        emailBox.sendKeys(faker.internet().emailAddress());

        WebElement passwordBox = driver.findElement(By.id("user_password"));
        passwordBox.sendKeys(faker.internet().password(5,10,true));

        WebElement checkBoxElementTerms = driver.findElement(By.id("tnc_checkbox"));
        checkBoxElementTerms.click();

        Thread.sleep(3000);
        driver.close();


    }
}
