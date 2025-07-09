package com.eurotech.tests.day_02_webdrivers_basics;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_GetMethods {
    public static void main(String[] args) {
        /**
         * set up a chrome driver
         * navigate to https://www.hepsiburada.com/
         * get title and get url get page source code
         * verify that title, url and Page source codes  contain "hepsiburada"
         */
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();

        driver.get("https://www.hepsiburada.com/");

        //basligi alalim
        String actuelTitle = driver.getTitle();

        //url alalim
        String actualUrl = driver.getCurrentUrl();

        //source kodu alalim
        String actualPageSource = driver.getPageSource();

        //test
        //verify yapalim

        if (actuelTitle.toLowerCase().contains("hepsiburada") && actualUrl.toLowerCase().contains("hepsiburada")
                && actualPageSource.toLowerCase().contains("hepsiburada")) {
            System.out.println("Passed...!");
        } else {
            System.out.println("Failed...!!!");
        }

        System.out.println("actualUrl = " + actualUrl);
        System.out.println("actuelTitle = " + actuelTitle);
        //System.out.println("actualPageSource = " + actualPageSource);
        driver.quit();
    }
}
