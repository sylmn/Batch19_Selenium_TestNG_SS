package com.eurotech.tests.day_04basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class C08_BasicLocatorRwiew {
    public static void main(String[] args) throws InterruptedException {

        /** Task
        * [x] open a chrome browser driver and navigate to https://www.demoblaze.com/
        * [x] locate Sign up link by using id and get text of web element then print the text
        * [x] locate BOTH OF previous and next link at the bottom of the page by using name
             and get text of web element then print the text
        * [x] locate Samsung Galaxy S6 by using tagname and get text of web element then print the text
        * [x] locate Product Store at the left top of the page by using class name and
             get text of web element then print the text
        * [x] locate Nokia Lumia 1520 by using link text and get text of web element then print the text
        * [x] locate Nexus 6 by using partial link text and get text of web element then print the text
        * [x] close the driver
        */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.demoblaze.com/");
        Thread.sleep(2000);

        WebElement signUpButton = driver.findElement(By.id("signin2"));
        String textSignUp = signUpButton.getText();
        System.out.println("textSignUp = " + textSignUp);

        WebElement prevButton = driver.findElement(By.id("prev2"));
        WebElement nextButton = driver.findElement(By.id("next2"));
        String textPrev = prevButton.getText();
        String textNext = nextButton.getText();
        System.out.println("textPrev = " + textPrev);
        System.out.println("textNext = " + textNext);
        Thread.sleep(2000);

        List<WebElement> tagNamesList = driver.findElements(By.tagName("h4"));
        for (WebElement tag: tagNamesList) {
            if (tag.getText().contains("Samsung galaxy s6")){
                System.out.println("tag.getText() = " + tag.getText());
                break;
            }
        }
        WebElement productStoreText = driver.findElement(By.className("navbar-brand"));
        System.out.println("productStoreText = " + productStoreText.getText());

        Thread.sleep(1000);
        WebElement nokiaLumia = driver.findElement(By.linkText("Nokia lumia 1520"));
        System.out.println("nokiaLumia = " + nokiaLumia.getText());

        Thread.sleep(1000);
        WebElement nexus6 = driver.findElement(By.partialLinkText("Nexus "));
        System.out.println("nexus6.getText() = " + nexus6.getText());

        driver.close();
    }
}
