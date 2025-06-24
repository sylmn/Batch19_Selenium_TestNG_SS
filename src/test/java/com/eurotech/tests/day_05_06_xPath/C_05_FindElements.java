package com.eurotech.tests.day_05_06_xPath;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class C_05_FindElements {
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

        for (WebElement label : labels ) {
            System.out.println(label.getText());
        }

        // beşinci sırada Date of Birth olduğunu test et
        String actualFifthLabel = labels.get(3).getText();

        System.out.println("actualFifthLabel = " + actualFifthLabel);

        String expectedFifthLabel = "Date of Birth";

        if (actualFifthLabel.equals(expectedFifthLabel))
            System.out.println("pass");
        else
            System.out.println("Fail");


        System.out.println("Sonuncu = "+labels.get(labels.size() - 1).getText());




        // beşinci sırada Date of Birth olduğunu test et
        WebElement fifthElement = driver.findElement(By.xpath("(//label[@class='form-label'])[4]"));
        String actualFifthElement_2 = fifthElement.getText();
        String expectedFifthElement_2= "Date of Birth";

        if (actualFifthElement_2.equals(expectedFifthElement_2))
            System.out.println("pass");
        else
            System.out.println("Fail");

        driver.close();


    }
}
