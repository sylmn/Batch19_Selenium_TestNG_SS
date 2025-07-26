package com.eurotech.tests.day_05_06_xPath;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C02_RelativeXpath_Attribute_Text {
    public static void main(String[] args) throws InterruptedException {
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

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com.tr/");
        Thread.sleep(2000);
        WebElement kabulEtButton = driver.findElement(By.xpath("//input[@id='sp-cc-accept']"));
        kabulEtButton.click();
        WebElement searchBox = driver.findElement(By.xpath("//input[@role='searchbox']"));

        searchBox.sendKeys("Selenium");
        Thread.sleep(2000);
        WebElement searchclick = driver.findElement(By.xpath("//input[@value='Git']"));
        searchclick.click();
        WebElement resultText = driver.findElement(By.xpath("//span[text()='\"Selenium\"']"));
        //WebElement resultText = driver.findElement(By.xpath("//span[.='\"Selenium\"']"));
        System.out.println("resultText.getText() = " + resultText.getText());
        Thread.sleep(2000);

        driver.close();
    }
}
