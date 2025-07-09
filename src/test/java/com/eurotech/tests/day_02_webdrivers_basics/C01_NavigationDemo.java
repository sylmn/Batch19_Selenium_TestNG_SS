package com.eurotech.tests.day_02_webdrivers_basics;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class C01_NavigationDemo {
    public static void main(String[] args) {
        /**
         * set up a firefox(chrome) driver
         * navigate to https://www.facebook.com/
         * then navigate to https://testrelic.com/
         * then navigate back
         * then navigate forward
         * then refresh page
         * then close driver
         */
        // set up a firefox (chrome) driver
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().setPosition(new Point(1000, 0));
        driver.manage().window().maximize();

        //navigate to https://www.facebook.com/
        driver.navigate().to("https://www.facebook.com/");

        // Thread.sleep(2000);

        //then navigate to https://testrelic.com/
        driver.get("https://testrelic.com/");

        //then navigate back
        driver.navigate().back();
        // Thread.sleep(2000);

        //then navigate forward
        driver.navigate().forward();
        // Thread.sleep(2000);

        //then refresh page
        driver.navigate().refresh();
        // Thread.sleep(2000);

        //then close driver
        driver.close();

    }

}
