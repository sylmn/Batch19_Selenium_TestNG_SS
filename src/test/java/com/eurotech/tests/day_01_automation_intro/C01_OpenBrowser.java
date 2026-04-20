package com.eurotech.tests.day_01_automation_intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_OpenBrowser {
    public static void main(String[] args) {
        //1. selenium'u chrome ile konuşacak hale getireceğiz.
        //2. bir driver objesi üreteceğiz.
        //3. driver --> boş bir browser temsil eder.

        WebDriver driver = new ChromeDriver();  //polymorphic bir tanımlama

        //amazon web sayfasına gidelim
        driver.get("https://www.amazon.com.tr");

        //amazon web sitesinin page title'ı alalım

        String actualTitle = driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);

        String expectedTitle = "Amazon.com.tr: Elektronik, bilgisayar, akıllı telefon, kitap, oyuncak, " +
                "yapı market, ev, mutfak, oyun konsolları ürünleri ve daha fazlası için internet " +
                "alışveriş sitesi";

        if (actualTitle.equals(expectedTitle))
            System.out.println("Pass...!");
        else
            System.out.println("Failed....!!!!");

    }
}
