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
        Thread.sleep(2000);

        WebElement acceptButton = driver.findElement(By.id("truste-consent-button"));
        acceptButton.click();

        Faker faker = new Faker();
        String fullName = faker.name().fullName();
        String emailAddress = faker.internet().emailAddress();
        String password = faker.internet().password(8, 10);

        WebElement fullNameBox = driver.findElement(By.name("user[full_name]"));
        fullNameBox.sendKeys(faker.name().fullName());
        //related E-Mail address with fullness
        String firstName = faker.name().firstName().toLowerCase();
        String lastName = faker.name().lastName().toLowerCase();
        String emailRelatedAddress = firstName+"."+lastName+"@example.com";

        WebElement emailBox = driver.findElement(By.id("user_email_login"));
        emailBox.sendKeys(faker.internet().emailAddress());
        //related E-Mail address with fullness --> 2.Way
        String [] nameParts = fullName.toLowerCase().split(" ");
        String firstName2 = nameParts[0];
        String lastName2 = nameParts[nameParts.length-1];
        String emailAddress2= firstName2+"."+lastName2+"@example.com";

        WebElement passwordBox = driver.findElement(By.id("user_password"));
        passwordBox.sendKeys(faker.internet().password(5,10,true));
        WebElement fullNameButton = driver.findElement(By.id("user_full_name"));
        //WebElement fullNameButton = driver.findElement(By.cssSelector("[placeholder=\"Full name\"]"));

        WebElement checkBoxElementTerms = driver.findElement(By.id("tnc_checkbox"));
        checkBoxElementTerms.click();
        fullNameButton.sendKeys(firstName+" "+lastName);
        Thread.sleep(1000);
        WebElement emailButton = driver.findElement(By.id("user_email_login"));
        //emailButton.sendKeys(emailAddress);
        emailButton.sendKeys(emailRelatedAddress);
        Thread.sleep(5000);
        WebElement passwordButton = driver.findElement(By.id("user_password"));
        passwordButton.sendKeys(password);
        Thread.sleep(1000);

        Thread.sleep(3000);
        WebElement agreeButton = driver.findElement(By.id("tnc_checkbox"));
        agreeButton.click();
        Thread.sleep(1000);
        driver.close();


    }
}
