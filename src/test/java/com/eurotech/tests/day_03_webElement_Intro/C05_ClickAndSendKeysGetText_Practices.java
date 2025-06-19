package com.eurotech.tests.day_03_webElement_Intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C05_ClickAndSendKeysGetText_Practices {
    public static void main(String[] args) throws InterruptedException {
        /**
        * HOMEWORK
        * [x] Open chore browser
        * [x] navigate to https://www.amazon.com/
        * [x] write "Java" to the search bar
        * [x] click search button
        * [x] get result for text
        * [x] verify that the text contains "Java"
        */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.de/");
        Thread.sleep(2000);

        WebElement searchBar= driver.findElement(By.cssSelector("[id=\"twotabsearchtextbox\"]"));
        searchBar.sendKeys("Java");

        WebElement searchSubmtBtn = driver.findElement(By.id("nav-search-submit-button"));
        searchSubmtBtn.click();

        WebElement resultText = driver.findElement(By.xpath("//span[contains(text(),'Ergebnissen')]"));
        System.out.println("resultText.getText() = " + resultText.getText());

        WebElement keywordJava = driver.findElement(By.cssSelector("[class=\"a-color-state a-text-bold\"]"));
        Thread.sleep(2000);
        String wordJava=keywordJava.getText();
        System.out.println("wordJava = " + wordJava);
        Thread.sleep(2000);
        if (wordJava.contains("Java")){
            System.out.println("passed");
        }else {
            System.out.println("failed");
        }
        driver.quit();


    }
}
