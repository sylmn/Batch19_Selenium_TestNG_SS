package com.eurotech.tests.day_05_06_xPath;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C07_RelativeXPath {
    public static void main(String[] args) throws InterruptedException {
        /** Task
         * navigate to https://demoqa.com/automation-practice-form
         * locate first name input box with xPath (parent-child relations)
         * send "Ayşegül" to the input box
         * locate sports checkbox with xPath (parent-child relations)
         * click to the checkbox
         * locate Student Registration Form element by xPath (parent-child relations)
         * get the text of web element and print it
         * close the driver
         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/automation-practice-form");

        //locate first name input box with xPath (parent-child relations)
        WebElement firstNameBox = driver.findElement(By.xpath("//button[@id='submit']//ancestor::form//input[@placeholder='First Name']"));
        firstNameBox.sendKeys("Ayşegül");

        Thread.sleep(2000);

        //locate sports checkbox with xPath (parent-child relations) and click to the checkbox

        //Bu ileriki bir konu ama sportCheckBox görünmüyor ve ekranin asagi kaydirilmasi gerekiyor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500);");

        WebElement sportCheckBox = driver.findElement(By.xpath("//h5/following-sibling::form//input[@id='hobbies-checkbox-1']/.."));
        sportCheckBox.click();
        Thread.sleep(2000);

        //locate Student Registration Form element by xPath (parent-child relations)
        //get the text of web element and print it

        WebElement studentText = driver.findElement(By.xpath("//label[text()='Select picture']//ancestor::form/..//h5[text()='Student Registration Form']"));
        System.out.println("studentText.getText() = " + studentText.getText());
        Thread.sleep(2000);

        driver.close();

    }
}
