package com.eurotech.tests.day_07_Css_Locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C02_AttributeValue_MultipleAttributeValue {
    public static void main(String[] args) throws InterruptedException {
        /**
         * navigate to http://www.eurotech.study/
         * click cookies button with one css attribute value
         * take DevEx text and print with css multiple attribute value (and)
         * take main text and print with css multiple attribute value (or)
         * close driver
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://www.eurotech.study/");

        Thread.sleep(2000);

        //click cookies button with one css attribute value
        // lazy way
        driver.findElement(By.cssSelector("button[aria-label='Accept cookies']")).click();

        Thread.sleep(2000);
        // take DevEx text and print with css multiple attribute value (and)
        WebElement devExText=driver.findElement(By.cssSelector("[id='landingpage-innercontainer-h1'][class='x-large']"));
        System.out.println("devExText = " + devExText.getText());


        Thread.sleep(2000);
        //take main text and print with css multiple attribute value (or)
        WebElement mainText=driver.findElement(By.cssSelector("[id='landingpage-innercontainer-p'],[class='lead']"));
        System.out.println("mainText = " + mainText.getText());

        Thread.sleep(2000);

        driver.close();
    }


}
