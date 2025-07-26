package com.eurotech.tests.day_05_06_xPath;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C03_RelativeXpath_Contains_StartsWith {
    public static void main(String[] args) throws InterruptedException {
        /** Task
         * [x] open chrome browser
         * [x] go to http://www.eurotech.study/
         * [x] click I understand button and accept cookies (use xPath-contains text)
         * [x] locate login button (use xPath - known attribute (class) )
         * [x] click login button
         * [x] locate email address input box (use xPath -starts-with (id))
         * [x] send "abc" into email address input box
         * [x] locate second login button (use xPath - * -> use star in xPath formula )
         * [x] click Login button
         * [x] get the message which appears on the email input box and print the message
         * [x] VERIFY that the message contains "Please include an '@' in the email address."
         * [x] close browser.
         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://www.eurotech.study/");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[contains(text(),'I ')]")).click();

        //locate login button (use xPath - known attribute (class) )
        WebElement loginBtn = driver.findElement(By.xpath("//a[@class='btn btn-light']"));
        loginBtn.click();

        Thread.sleep(1000);

        //locate email address input box (use xPath -starts-with (id))
        WebElement eMailBox = driver.findElement(By.xpath("//input[starts-with(@id,'loginpage-i')]"));
        eMailBox.sendKeys("abc");

        //locate second login button (use xPath - * -> use star in xPath formula )
        WebElement secondLoginBtn = driver.findElement(By.xpath("//*[starts-with(@type,'submit')]"));
        secondLoginBtn.click();
        Thread.sleep(2000);

        //get the message which appears on the email input box and print the message
        String actualSignInMessage = eMailBox.getAttribute("validationMessage");
        System.out.println("actualSignInMessage = " + actualSignInMessage);
        String expectedSignInMessage= "Lütfen e-posta adresine bir \"@\" işareti ekleyin. \"abc\" adresinde \"@\" eksik.";
        if (actualSignInMessage.equals(expectedSignInMessage))
            System.out.println("passed");
        else
            System.out.println("failed");

        driver.close();

    }
}
