package com.eurotech.tests.day_12_waits;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C_01_Waits {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

    @Test
    public void threadSleep() throws InterruptedException {
        /**
         * navigate to https://the-internet.herokuapp.com/dynamic_loading/2
         * click start button
         * verify that "Hello World!" is visible
         * use Thread.sleep()
         */

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        driver.findElement(By.cssSelector("#start>button")).click();
        Thread.sleep(12000);

        WebElement helloWorld = driver.findElement(By.xpath("//h4[text()='Hello World!']"));

        Assert.assertTrue(helloWorld.isDisplayed());
    }

    @Test
    public void implicitlyWait(){

        /**
         * navigate to https://the-internet.herokuapp.com/dynamic_loading/2
         * click start button
         * verify that "Hello World!" is visible
         */
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        driver.findElement(By.cssSelector("#start>button")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebElement helloWorld = driver.findElement(By.xpath("//h4[text()='Hello World!']"));

        Assert.assertTrue(helloWorld.isDisplayed());
    }

    @Test
    public void explicitlyWait(){
        /**
         * navigate to https://the-internet.herokuapp.com/dynamic_loading/1
         * click start button
         * verify that "Hello World!" is visible
         */

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("#start>button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(13));

        WebElement helloWorld = driver.findElement(By.xpath("//h4[text()='Hello World!']"));

        wait.until(ExpectedConditions.visibilityOf(helloWorld));

        Assert.assertTrue(helloWorld.isDisplayed());
    }

    @Test
    public void explicitlyWait_2(){
        /**
         * navigate to https://the-internet.herokuapp.com/dynamic_loading/2
         * click start button
         * verify that "Hello World!" is visible
         */

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        driver.findElement(By.cssSelector("#start>button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));

        WebElement helloWorld = driver.findElement(By.xpath("//h4[text()='Hello World!']"));

        Assert.assertTrue(helloWorld.isDisplayed());
    }

    @Test
    public void waitClassTask(){
        /**
         * Wait Task
         * navigate to https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html
         * locate all buttons to a web element list (start, one, two, three) (findElements)
         * Let's click the buttons respectively
         * after the click to  the last button : "All Buttons Clicked" message should be seen at the page.
         * Note: Do not use Thread.sleep(), just use dynamic waits
         *
         *  https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html sayfasına gidelim
         *  bütün butonları bir list'e alalım (start, one, two, three) (findElements)
         *  butonlara sırasıyla tıklayalım
         *  son butona tıklandıktan sonra "All Buttons Clicked" mesajının ekrana geldiğini text ile doğrulayalım.
         *  Not: Thread.sleep() metodunu kullanmayalım sadece dinamik yani akıllı wait kullanalım...
         */

        driver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("button"),4));

        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        System.out.println("buttons.size() = " + buttons.size());

        for(WebElement button : buttons){
            wait.until(ExpectedConditions.elementToBeClickable(button)).click();
        }

//        for (int i = 0; i < buttons.size(); i++) {
//            wait.until(ExpectedConditions.elementToBeClickable(buttons.get(i))).click();
//        }

        WebElement message = driver.findElement(By.cssSelector("#buttonmessage"));
        String actualText = message.getText();
        String expectedMessage = "All Buttons Clicked";

        Assert.assertEquals(actualText, expectedMessage);

        wait.until(ExpectedConditions.textToBe(By.cssSelector("#buttonmessage"), "Clickable Buttons"));

        System.out.println("message.getText() = " + message.getText());
    }
}
