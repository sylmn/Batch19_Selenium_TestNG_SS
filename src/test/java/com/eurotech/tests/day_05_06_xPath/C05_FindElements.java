package com.eurotech.tests.day_05_06_xPath;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class C05_FindElements {
    public static void main(String[] args) throws InterruptedException {
        /**
         * open chrome
         * go to https://demoqa.com/automation-practice-form
         * take all form labels to a web element list
         * then print labels texts
         * close driver
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/automation-practice-form");
        Thread.sleep(2000);

        List<WebElement> labels = driver.findElements(By.xpath("//label[@class='form-label']"));
        for (WebElement label:labels) {
            System.out.println(label.getText());
        }
        //besinci sirada Date of Birth oldugunu test et
        String actualFifthLabel = labels.get(3).getText();
        String expectedFifthLAbel = "Date of Birth";

        if (actualFifthLabel.equals(expectedFifthLAbel))
            System.out.println("passed");
        else
            System.out.println("failed");

        System.out.println("Sonuncu = "+labels.get(labels.size() - 1).getText());


        //liste atmadan dogrudan webelementin yerini tarif ederek

        WebElement fifthElement = driver.findElement(By.xpath("(//label[@class='form-label'])[4]"));
        String actualFifthElement = fifthElement.getText();
        String expectedFifthElement = "Date of Birth";

        if (actualFifthElement.equals(expectedFifthElement))
            System.out.println("passed");
        else
            System.out.println("failed");

        driver.close();
    }
}
