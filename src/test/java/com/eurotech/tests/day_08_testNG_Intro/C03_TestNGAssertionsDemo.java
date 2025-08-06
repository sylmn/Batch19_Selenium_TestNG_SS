package com.eurotech.tests.day_08_testNG_Intro;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class C03_TestNGAssertionsDemo {

    @BeforeMethod
    public void setup() {
        System.out.println("********open browser***********");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("********close browser***********");
    }

    @Test
    public void test1() {
        System.out.println("First Assertion");
        Assert.assertEquals("Ayse3", "Ayse");
        System.out.println("second assertion");
        Assert.assertEquals("Alper", "Alper");
    }

    @Test
    public void test2() {
        System.out.println("third assertion");
        Assert.assertEquals("url", "url");
        int i = 5 / 0;
    }

    @Test
    public void test3() {
        System.out.println("fourth assertion");
        Assert.assertEquals(150, 150);

    }

    @Test
    public void test4() {
        String str = "Eurotech";
        String str2 = "Euro";
        Assert.assertTrue(str.startsWith(str2));
        String str3 = "aaaaaa@aaa.com";
        Assert.assertTrue(str3.contains("@"));
        Assert.assertTrue(str3.contains("@"), "Verify that mail contains @");
        //mesaj kismi assertion gecmez ise yazdirir.
    }

    @Test
    public void test5() {
        String str = "eurotech";
        Assert.assertFalse(str.contains("@"));

        Assert.assertFalse(1 < 0);
    }

    @Test
    public void test6() {
        String str = "Leeroy";
        String str2 = "";   //empty
        String str3 = " ";   //blank
        String str4 = null;   //null
        String str5;          //

        Assert.assertNull(str4);
        Assert.assertNotNull(str3);

    }
}
