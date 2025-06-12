package com.eurotech.tests.day_02_webdrivers_basics;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class C04_CallWebDriverFactory {
    public static void main(String[] args) {
        /**
         * set up a chrome driver with WebDriverFactory
         * navigate to https://tr-tr.facebook.com/
         * verify that the url is correct
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://tr-tr.facebook.com/");
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://tr-tr.facebook.com/";

        //test
        if (actualUrl.equals(expectedUrl)){
            System.out.println("Passed..!");
        }else {
            System.out.println("failed..!");
        }
        driver.quit();
    }
}
