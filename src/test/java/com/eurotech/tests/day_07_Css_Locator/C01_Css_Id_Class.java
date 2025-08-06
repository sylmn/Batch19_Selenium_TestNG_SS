package com.eurotech.tests.day_07_Css_Locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C01_Css_Id_Class {
    public static void main(String[] args) throws InterruptedException {
        /**
         * navigate to http://www.eurotech.study/
         * click cookies button with css id
         * click Sign Up button css class
         * send "Ahmet" to name box by css id with tag
         * click register button by css class with tag
         * close driver
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://www.eurotech.study/");

        Thread.sleep(2000);

        // click cookies button with css id
        WebElement cookiesButton= driver.findElement(By.cssSelector("#rcc-confirm-button"));
        cookiesButton.click();

        Thread.sleep(2000);

        // click Sign Up button css class
        // with lazy way
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();

        Thread.sleep(2000);

        // send "Ahmet" to name box by css id with tag
        WebElement nameBox=driver.findElement(By.cssSelector("input#signuppage-form-name-input"));
        nameBox.sendKeys("Ahmet");
        Thread.sleep(2000);

        // click register button by css class with tag
        WebElement registerButton=driver.findElement(By.cssSelector("input.btn.btn-primary"));
        registerButton.click();

        Thread.sleep(3000);
        driver.quit();
    }
}
