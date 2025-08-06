package com.eurotech.tests.day_12_waits;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class C_02_StaleElement {
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
    public void staleElement(){
        driver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html");
        WebElement title = driver.findElement(By.tagName("h1"));
        System.out.println("title.getText() = " + title.getText());

        driver.navigate().refresh();

        title = driver.findElement(By.tagName("h1"));  //tazeleme yapmak gerekir.
        System.out.println("title.getText() = " + title.getText());

    }
}
