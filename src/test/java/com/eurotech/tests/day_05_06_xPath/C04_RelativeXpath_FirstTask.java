package com.eurotech.tests.day_05_06_xPath;

import com.eurotech.utilities.WebDriverFactory;
import com.mifmif.common.regex.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C04_RelativeXpath_FirstTask {
    public static void main(String[] args) throws InterruptedException {
        /**
         * open chrome browser and go to http://www.eurotech.study/
         * click I understand button and accept cookies (use xPath with attribute feature)
         * locate Sign Up link (use xPath with text feature)
         * click the Sign Up link
         * locate Sign In link (use xPath with text feature)
         * get the text of element and print it
         * verify that the text is "Sign In"
         * close browser.
         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://www.eurotech.study/");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@id='rcc-confirm-button']")).click();
        Thread.sleep(2000);
        WebElement signUpBtn = driver.findElement(By.xpath("//a[text()='Sign Up']"));
        signUpBtn.click();

        WebElement signInBtn = driver.findElement(By.xpath("//a[text()='Sign In']"));
        System.out.println("signInBtn.getText() = " + signInBtn.getText());
        String expectedText= "Sign In";
        String actualText=signInBtn.getText();
        if (actualText.equals(expectedText))
            System.out.println("passed");
        else
            System.out.println("failed");

        driver.close();

    }
}
