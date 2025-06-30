package com.eurotech.tests.day_05_06_xPath;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C_07_ReleativeXpath {
    public static void main(String[] args) throws InterruptedException {
        /**
         * task
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
        driver.navigate().to("https://demoqa.com/automation-practice-form");


        //locate first name input box with xPath (parent-child relations)
        //         * send "Ayşegül" to the input box
        WebElement nameBox = driver.findElement(By.xpath("//button[@id='submit']/ancestor::form//input[@placeholder='First Name']"));
        nameBox.sendKeys("Ayşegül");

        Thread.sleep(2000);

        //locate sports checkbox with xPath (parent-child relations)
        //         * click to the checkbox
        WebElement sportCheckBox = driver.findElement(By.xpath("//h5/following-sibling::form//input[@id='hobbies-checkbox-1']/.."));
        sportCheckBox.click();
        Thread.sleep(2000);

        // ancestor ilgili locator ın ataları içinde isteneni arar !!!
        WebElement studentRegistForm = driver.findElement(By.xpath("//label[text()='Select picture']/ancestor::form/preceding-sibling::h5"));
        String studentRgsFormText = studentRegistForm.getText();
        System.out.println(studentRgsFormText);

        Thread.sleep(2000);

        driver.close();

    }
}
