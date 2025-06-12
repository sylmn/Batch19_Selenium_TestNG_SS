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
        System.out.println(title);

        //maximize window
       // driver.manage().window().maximize();

        //fullscreen
        //driver.manage().window().fullscreen();

        //window'un position alma
        //27,4px=1cm
        Point position = driver.manage().window().getPosition();
        System.out.println("position = " + position);

        //window un positioni set etme
        driver.manage().window().setPosition(new Point(-1000,150));
        driver.manage().window().maximize();

        //windowun ebatlarini alma
        int width = driver.manage().window().getSize().width;
        System.out.println("width = " + width);

        int height = driver.manage().window().getSize().height;
        System.out.println("height = " + height);
        Dimension size = driver.manage().window().getSize();
        System.out.println("size = " + size);


        //pencerenin ebatlarini ayarlama
        driver.manage().window().setSize(new Dimension(520,1000));
        size=driver.manage().window().getSize();
        System.out.println("size = " + size);
    }
}
