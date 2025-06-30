package com.eurotech.tests.day_05_06_xPath;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C_09_XpathHomework {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        /**
         * go to https://www.automationexercise.com/
         * locate viewProduct button with product name
         */

       driver= WebDriverFactory.getDriver("chrome");
       driver.get("https://www.automationexercise.com/");
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

    private static void viewProduct(String product){
        WebElement productView=driver.findElement(By.xpath("//p[text()='"+product+"']/ancestor::div[@class=\"product-image-wrapper\"]//li/a"));
        productView.click();
    }
}
