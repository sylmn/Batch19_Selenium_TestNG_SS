package com.eurotech.tests.day_05_06_xPath;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C_01_AbsoluteXpath {
    public static void main(String[] args) throws InterruptedException {
        /**
         * open a chrome browser and navigate to "https://demoqa.com/automation-practice-form"
         * locate current address input area with absolute xPath
         * send "Manheim/Kolonya" to the address box area
         * then take the value of address box area
         * verify that both addresses are same
         * close driver
         */

        //open a chrome browser and navigate to "https://demoqa.com/automation-practice-form"
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/automation-practice-form");

        //locate current address input area with absolute xPath
        WebElement addressBox = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[9]/div[2]/textarea"));

       //send "Manheim/Kolonya" to the address box area
        addressBox.sendKeys("Manheim/Kolonya");

        //then take the value of address box area
        String actualAddress = addressBox.getAttribute("value");
        String expectedAddress = "Manheim/Kolonya";

        if (actualAddress.equals(expectedAddress))
            System.out.println("Pass..");
        else
            System.out.println("Fail..!!");

        Thread.sleep(2000);
        driver.close();

    }
}
