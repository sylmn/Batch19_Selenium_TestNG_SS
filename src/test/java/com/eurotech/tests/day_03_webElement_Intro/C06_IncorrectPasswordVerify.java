package com.eurotech.tests.day_03_webElement_Intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C06_IncorrectPasswordVerify {
    public static void main(String[] args) throws InterruptedException {
        /**
         * Chrome tarayıcısını aç.
         * https://www.saucedemo.com/ adresine git.
         * Kullanıcı adı kutusuna standard_user yaz.
         * Şifre kutusuna yanlış bir şifre yaz (örneğin wrong_password).
         * "Login" butonuna tıkla.
         * Ekranda görünen hata mesajını bul.
         * Hata mesajının "Username and password do not match" ifadesini içerdiğini doğrula.
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);

        WebElement boxUserName = driver.findElement(By.id("user-name"));
        boxUserName.sendKeys("standard_user");

        WebElement boxPassword = driver.findElement(By.id("password"));
        boxPassword.sendKeys("wrong_password");

        Thread.sleep(2000);

        WebElement buttonLogin = driver.findElement(By.id("login-button"));
        buttonLogin.click();

        WebElement errorMsg = driver.findElement(By.cssSelector("[data-test=\"error\"]"));
        Thread.sleep(2000);
        System.out.println("errorMsg.getText() = " + errorMsg.getText());
        String message = errorMsg.getText();
        System.out.println("message = " + message);

        String expectedMsg = "Username and password do not match";

        if (message.contains(expectedMsg))
            System.out.println("passed");
        else
            System.out.println("failed");

        driver.quit();


    }
}
