package com.eurotech.tests.day_02_webdrivers_basics;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_Example1 {
    public static void main(String[] args) throws InterruptedException {
        /**
            * Set up a Chrome (veya Firefox) driver
            * Go to https://www.google.com
            * Print the title of the page
            * Go to https://www.wikipedia.org
            * Print the current URL
            * Navigate back to Google
            * Navigate forward to Wikipedia
            * Refresh the page
            * Close the browser
        */
        WebDriver driver =new ChromeDriver();
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        Thread.sleep(2000);

        System.out.println("driver.getTitle() = " + driver.getTitle());
        driver.get("https://www.wikipedia.org");
        Thread.sleep(2000);
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        driver.navigate().back();
        Thread.sleep(2000);

        driver.navigate().forward();
        Thread.sleep(2000);

        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.quit();
    }
}
