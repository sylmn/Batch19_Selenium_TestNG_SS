package com.eurotech.tests.day_03_webElement_Intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C03_VerifyUsernameIsCorrect {
    public static void main(String[] args) throws InterruptedException {
/**
 * Task
 * open chrome browser
 * go to "https://demoqa.com/login"
 * enter "test" into the username box
 * VERIFY that "test" is displayed in the username box
 * enter "Test.!123" into the password box
 * click on login button
 * VERIFY that username is "test"
 */

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("https://demoqa.com/login");

        String expectedText="test";

        WebElement usernameBox = driver.findElement(By.id("userName"));
        usernameBox.sendKeys("test");

        Thread.sleep(1000);

        // getAttribute() bize seçili olan element attribute leri hakkında bilgi verir
        // eğer sendKeys() söz konusuysa, gönderilen değeri verir

        String actualText=usernameBox.getAttribute("value");
        System.out.println("actualText = " + actualText);

        System.out.println("usernameBox.getAttribute(\"id\") = " + usernameBox.getAttribute("id"));
        System.out.println("usernameBox.getAttribute(\"placeholder\") = " + usernameBox.getAttribute("placeholder"));
        System.out.println("usernameBox.getAttribute(\"type\") = " + usernameBox.getAttribute("type"));
        System.out.println("usernameBox.getAttribute(\"class\") = " + usernameBox.getAttribute("class"));

        if (actualText.equals(expectedText)){
            System.out.println("pass");
        }else {
            System.out.println("fail");
        }

        // locate password box
        WebElement passwordBox = driver.findElement(By.cssSelector("[placeholder='Password']")); //css locator

        //send value to password box
        passwordBox.sendKeys("Test.!123");

        Thread.sleep(1000);

        // locate login button and pu it in a webElement bucket
        WebElement loginBtn = driver.findElement(By.id("login"));

        loginBtn.click();

        Thread.sleep(3000);

        // locate username value
        WebElement usernameText = driver.findElement(By.id("userName-value"));

        // getText() methodu yazıları almak için kullanılır
        String actualUsernameText = usernameText.getText();
        String expectedUsernameText="test";

        if (actualUsernameText.equals(expectedUsernameText)){
            System.out.println("pass");
        }else {
            System.out.println("fail");
        }

        driver.close();

    }
}
