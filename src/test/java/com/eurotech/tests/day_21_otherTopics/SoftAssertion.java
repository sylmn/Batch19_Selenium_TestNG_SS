package com.eurotech.tests.day_21_otherTopics;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {

    @Test
    public void test1(){
        System.out.println("Test Başladı");

        Assert.assertEquals(1,1);
        Assert.assertEquals(1,2);
        Assert.assertEquals(1,1);

        System.out.println("Test Bitti");
    }

    @Test
    public void test2(){
        SoftAssert softAssert = new SoftAssert();

        System.out.println("Test Başladı");

        softAssert.assertEquals(1,1);
        softAssert.assertEquals(1,2);
        softAssert.assertEquals(1,1);
        softAssert.assertEquals("Ahmet","Ali");

        System.out.println("Test Bitti");

        softAssert.assertAll("giriş formu doldurma testi");
    }
}
/**
 * Soft assertion: Normal assertte hata aldıktan sonraki assertleri test edemeyiz, ancak etmek istediğimiz
 * durumlarda soft assertion kullanabiliriz. Bu assertion tipinde bütün assertler biriktirilir, hatalı assertion olsa da kod
 * exception fırlatmaz ve execution devam eder. En son assertAll() metodunda geriye dönük olarak bütün assertionlar
 * değerlendirilir ve varsa hatalar, bu satır çalıştıktan sonra log kayıtlarında görünür ve hata fırlatılır.
 */