package com.eurotech.tests.day_01_automation_intro;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class C02_WindowMethods {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.eurotechstudy.com/en/index");

        String title = driver.getTitle();
        System.out.println("title = " + title);

        //maximize window
     //   driver.manage().window().maximize();
        //fullscreen
    //    driver.manage().window().fullscreen();

        //window'un position alma

        Point position = driver.manage().window().getPosition();
        System.out.println("position = " + position);

        //window'un position ayarlama (set)
        driver.manage().window().setPosition(new Point(500,350));

        Point position1 = driver.manage().window().getPosition();
        System.out.println("position1 = " + position1);

        //window'u soldaki ekrana nasıl alırım
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();

        //windowun ebatlarını alalım (en - yükseklik)
        int width = driver.manage().window().getSize().width;
        System.out.println("width = " + width);
        int height = driver.manage().window().getSize().height;
        System.out.println("height = " + height);
        Dimension size = driver.manage().window().getSize();
        System.out.println("size = " + size);

        //pencerenin ebatlarını ayarlama
        driver.manage().window().setSize(new Dimension(520,1000));

        size = driver.manage().window().getSize();
        System.out.println("size = " + size);

    }
}
