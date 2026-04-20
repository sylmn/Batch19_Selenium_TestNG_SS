package com.eurotech.tests.day_05_06_xPath;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C02_RelativeXpath_Attribute_Text {
    public static void main(String[] args) {
        /**
         * open chrome
         * navigate to https://www.amazon.com.tr/
         * accept cookies if any (use xPath formula with known attribute value)
         * locate search bar with xPath formula with known attribute value
         * send "Selenium" word to the search bar
         * locate search button with xPath formula with known attribute value
         * click search button
         * Get the search result by the formula of the text feature of Xpath (two ways)
         * get the text of web element and print it.
         * close driver.
         */

        //open chrome
        //navigate to https://www.amazon.com.tr/

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com.tr/");

        //accept cookies if any (use xPath formula with known attribute value)
        //lazy way
        driver.findElement(By.xpath("//input[@id='sp-cc-accept']")).click();

        //* locate search bar with xPath formula with known attribute value
        //* send "Selenium" word to the search bar
        WebElement searchBar = driver.findElement(By.xpath("//input[@role='searchbox']"));
        searchBar.sendKeys("Selenium");

        // locate search button with xPath formula with known attribute value
        // click search button
        WebElement searchBtn = driver.findElement(By.xpath("//input[@value='Git']"));
        searchBtn.click();

        //* Get the search result by the formula of the text feature of Xpath (two ways)
        //* get the text of web element and print it.
        WebElement searchResult1 = driver.findElement(By.xpath("//span[.='\"Selenium\"']"));
        WebElement searchResult2 = driver.findElement(By.xpath("//span[text()='\"Selenium\"']"));

        System.out.println("searchResult1.getText() = " + searchResult1.getText());
        System.out.println("searchResult2.getText() = " + searchResult2.getText());

        driver.close();


    }
}
