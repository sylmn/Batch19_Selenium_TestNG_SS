package com.eurotech.tests.day_02_webdriver_basics;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_CloseAndQuit {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();

        driver.get("https://www.eurotechstudy.com/en/index");

        driver.close();

        WebDriver driver1 = new ChromeDriver();
        driver1.manage().window().setPosition(new Point(-1000,0));
        driver1.manage().window().maximize();

        driver1.navigate().to("https://amazon.com.tr");

        driver1.quit();

        //kapanmış bir driver'ı tekrar kullanmak istersem.
        driver1 = new ChromeDriver();
        driver1.manage().window().setPosition(new Point(-1000,0));
        driver1.manage().window().maximize();
        driver1.get("https://www.eurotechstudy.com/en/index");

        driver1.quit();

    }
}
