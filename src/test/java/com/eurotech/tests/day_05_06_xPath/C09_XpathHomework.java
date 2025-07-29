package com.eurotech.tests.day_05_06_xPath;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C09_XpathHomework {
    static WebDriver  driver;
    public static void main(String[] args) throws InterruptedException {
        /**
         * go to https://www.automationexercise.com/
         * locate viewProduct button with product name
         */
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.automationexercise.com/");
        Thread.sleep(2000);

        WebElement izinButon = driver.findElement(By.xpath("//p[text()='İzin ver']"));
        izinButon.click();
        Thread.sleep(2000);

        viewProduct("Blue Top");
        driver.navigate().back();

        Thread.sleep(2000);
        viewProduct("Men Tshirt");
        driver.navigate().back();
        Thread.sleep(2000);
        viewProduct("Sleeveless Dress");

        Thread.sleep(2000);
        driver.close();
    }


    private static void viewProduct(String productName){
        WebElement viewPrdBtn = driver.findElement(By.xpath("//p[text()='" + productName + "']/ancestor::div[@class='product-image-wrapper']//li/a"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView(true);"+"arguments[0].click();", viewPrdBtn);
    }
}
