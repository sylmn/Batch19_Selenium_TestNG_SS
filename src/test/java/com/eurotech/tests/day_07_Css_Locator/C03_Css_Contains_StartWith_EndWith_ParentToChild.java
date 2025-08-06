package com.eurotech.tests.day_07_Css_Locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C03_Css_Contains_StartWith_EndWith_ParentToChild {
    public static void main(String[] args) throws InterruptedException {
        /**
         * class task
         * navigate to http://www.eurotech.study/
         *  click cookies button css contains (*)
         *  click login button with css starts-with (^)
         *   send your email to email box with css ends-with ($)
         *  send your password to password box with css parent to child (>)
         *  click login btn with css parent to grandson (space)
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://www.eurotech.study/");

        Thread.sleep(2000);

        // click cookies button css contains (*)
        driver.findElement(By.cssSelector("[id*='confirm']")).click();

        Thread.sleep(2000);
        // click login button with css starts-with (^)
        driver.findElement(By.cssSelector("[class^='btn btn-l']")).click();

        Thread.sleep(2000);

        // send your email to email box with css ends-with ($)
        WebElement emailBox = driver.findElement(By.cssSelector("[placeholder$='Address']"));
        emailBox.sendKeys("lj@test.com");

        Thread.sleep(2000);

        // send your password to password box with css parent to child (>)
        WebElement passwordBox = driver.findElement(By.cssSelector("[class='form-group']>[type='password']"));
        passwordBox.sendKeys("1234.Asdf");

        Thread.sleep(2000);
        //click login btn with css parent to grandson (space)
        WebElement loginButton = driver.findElement(By.cssSelector("[class='form']         [type='submit']"));
        loginButton.click();

        Thread.sleep(2000);
        driver.close();
    }
}
