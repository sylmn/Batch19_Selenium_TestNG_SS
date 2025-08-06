package com.eurotech.tests.day_09typeOfWebElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class C05_GetAttributeDemo {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        driver.close();
    }

    @Test
    public void getAttributeTest() throws InterruptedException {
        /**
         * navigate to https://demoqa.com/text-box
         * locate the form web element
         * use some of GET (getAttribute, getTagName, getLocation, getCssValue) methods with the element
         */

        driver.get("https://demoqa.com/text-box");

        WebElement formElement = driver.findElement(By.xpath("//form"));

        System.out.println("formElement.getAttribute(\"id\") = " + formElement.getAttribute("id"));
        System.out.println("-------------");
        System.out.println("formElement.getAttribute(\"innerHTML\") = " + formElement.getAttribute("innerHTML"));   //child elementleri ile birlikte döner (son child element ise boş döner)
        System.out.println("-------------");
        System.out.println("formElement.getAttribute(\"outerHTML\") = " + formElement.getAttribute("outerHTML"));  // child elementi yoksa sadece kendini döner
        System.out.println("-------------");
        System.out.println("formElement.getText() = " + formElement.getText());
        System.out.println("-------------");
        System.out.println("formElement.getLocation() = " + formElement.getLocation()); // x,y olarak elemenin koordinatını verir. Action class da kullanılabilir
        System.out.println("-------------");
        System.out.println("formElement.getCssValue(\"background\") = " + formElement.getCssValue("background"));  //style için görünüm değerlerini verir
        System.out.println("-------------");
        System.out.println("formElement.getCssValue(\"font\") = " + formElement.getCssValue("font"));           //style için görünüm değerlerini verir
        System.out.println("-------------");
        System.out.println("formElement.getCssValue(\"color\") = " + formElement.getCssValue("color"));         //style için görünüm değerlerini verir
        System.out.println("-------------");
        System.out.println("formElement.getRect().getDimension() = " + formElement.getRect().getDimension());       //webElement in boyutlarını verir
        System.out.println("-------------");
        System.out.println("formElement.getSize() = " + formElement.getSize());


    }


    @Test
    public void getAttribute_Task(){

        /**
         * navigate to https://demoqa.com/text-box
         * locate Full Name input box
         * use getAttribute method with the element
         * get type attribute value and print it
         * get autocomplete attribute value and print it
         * get name attribue value and print it (name attribute olmadığı için boş dönecektir. hata vermez..)
         * get innerHTML and print it (altında child veya grandchild element olmadığından boş döner..)
         * get outerHTML (sadece kendi tag bilgilerini döner..)
         * send Ahmet to the box and take the value (eğer bir text box'ına yazı gönderirsek.. bu gönderlen yazıyı
         * getAttribute("value") metodu ile alabiliriz..)
         * NOT: getAttribute metodu ile bir web elementin texti alınamaz.. onun için getText() metodu kullanılır..
         */
        driver.get("https://demoqa.com/text-box");

        WebElement fullName = driver.findElement(By.id("userName"));

        // istediğimiz attribute'a ait değeri almak için attribute name'i parametre olarak kullanırız..
        System.out.println("fullName.getAttribute(\"type\") = " + fullName.getAttribute("type"));
        System.out.println("fullName.getAttribute(\"autocomplete\") = " + fullName.getAttribute("autocomplete"));
        System.out.println("-----------------------------");
        //eğer elementte olmayan bir attribute'ün değerini almaya çalışırsak bize boş değer döndürür.
        //eğer elementte olan ama değeri olmayan bir attribute'ün değerini almaya çalışırsak bize true döndürür.
        System.out.println("fullName.getAttribute(\"name\") = " + fullName.getAttribute("name"));
        System.out.println("-----------------------------");

        // altında child ya da grnadchild'ı olmayan web elementler için "innerHTML" boş döner...
        System.out.println("fullName.getAttribute(\"innerHTML\") = " + fullName.getAttribute("innerHTML"));
        System.out.println("-----------------------------");

        // altında child ya da grnadchild'ı olmayan web elementler için "outerHTML" sadece kendi bilgilerini döner..
        System.out.println("fullName.getAttribute(\"outerHTML\") = " + fullName.getAttribute("outerHTML"));
        System.out.println("-----------------------------");

        fullName.sendKeys("Ahmet");
        //input box'a gönderdiğimiz text'i almak istersek "value" parametresini kullanırız...
        System.out.println("fullName.getAttribute(\"value\") = " + fullName.getAttribute("value"));
}

}
