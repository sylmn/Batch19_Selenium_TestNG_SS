package com.eurotech.tests.day_03_webElement_Intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C05_ClickAndSendKeysGetText_Practice {
    public static void main(String[] args) {
        /**
         *      HOMEWORK
         * Open chore browser
         * navigate to https://www.amazon.com/
         * write "Java" to the search bar
         * click search button
         * get result for text
         * verify that the text contains "Java"
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");
        driver.navigate().refresh();
        driver.navigate().refresh();




        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java");
        driver.findElement(By.id("nav-search-submit-button")).click();



        WebElement result=driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        System.out.println("text = "+result.getText());

        if(result.getText().contains("Java")){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        driver.close();
    }
}
