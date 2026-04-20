package com.eurotech.tests.day_15_properties_singleton;

import com.eurotech.utilities.Driver;
import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class C_04_SingletonDriverTest {

    @Test @Ignore
    public void test1(){
      //  WebDriver driver = WebDriverFactory.getDriver("chrome");
        WebDriver driver = Driver.get();
        driver.get("https://www.amazon.com.tr");
    }

    @Test @Ignore
    public void test2(){
       // WebDriver driver = WebDriverFactory.getDriver("chrome");
        WebDriver driver = Driver.get();
        driver.get("https://www.hepsiburada.com");
    }

    @Test
    public void test3(){
        WebDriver driver = Driver.get();
        driver.get("https://www.amazon.com.tr");
    }

    @Test
    public void test4() throws InterruptedException {
        Thread.sleep(2000);
        Driver.get().findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);

    }


}
