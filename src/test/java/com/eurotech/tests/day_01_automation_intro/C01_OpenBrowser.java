package com.eurotech.tests.day_01_automation_intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_OpenBrowser {
    public static void main(String[] args) {

        //1.Selenium'u Chrome ile konusacak hale getirecegiz
        //2.Bir Driver Objesi üretecegiz
        //3.Driver-->Bos bir browseri temsil eder

        WebDriver driver = new ChromeDriver(); //polymorfik bir tanimlama

        //navigate amazon web sayfasi
        driver.get("https://www.amazon.com.tr");

        // amazon web sitesinin page title'ini alalim
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        String expectedTitle = "Amazon.com.tr: Elektronik, bilgisayar, akıllı telefon, kitap, oyuncak, " +
                "yapı market, ev, mutfak, oyun konsolları ürünleri ve daha fazlası için internet alışveriş " +
                "sitesi";

        if (actualTitle.equals(expectedTitle))
            System.out.println("Pass...!");
        else
            System.out.println("Failed....!!!!");
    }
}
