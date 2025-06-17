package com.eurotech.tests.day_04_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C01_ById {
    public static void main(String[] args) throws InterruptedException {
        /**
         * open chrome browser and navigate to http://www.eurotech.study/
         * accept cookies if any
         * locate DevEx web element by using id locator
         * get the text of web element and print it
         * make verification
         * expectedText = "DevEx";
         * close driver.
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://www.eurotech.study/");

        Thread.sleep(2000);

        //accept cookies if any  lazy way
        driver.findElement(By.id("rcc-confirm-button")).click();


        //locate DevEx web element by using id locator
        WebElement devExElement = driver.findElement(By.id("landingpage-innercontainer-h1"));

        //get the text of web element and print it
        String devExElementText = devExElement.getText();

        System.out.println("devExElementText = " + devExElementText);

        String expectedText = "DevEx";


        //make verification
        if (devExElementText.equals(expectedText)){
            System.out.println("pass");
        }else {
            System.out.println("fail");
        }


        //close driver
        driver.close();

    }
}


/**
 * 1. id ler coğunlukla unique olur ancak yine de kontrol etmek gerekir
 * 2. başına ctrl + f ile # işareti konularak kontrol edilebilir
 * 3. Eğer id varsa başka birşeye bakma
 * 4. nadiren dinamik olabilir
refresh yapıldığında id değişiyorsa dinamiktir

 * //  https://the-internet.herokuapp.com/challenging_dom     dinamik ıd örnek

 */
