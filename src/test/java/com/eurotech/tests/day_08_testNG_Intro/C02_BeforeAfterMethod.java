package com.eurotech.tests.day_08_testNG_Intro;

import org.testng.annotations.*;

public class C02_BeforeAfterMethod {

    @Test(priority = 3)
    public void test1() {
        System.out.println("Test1");
    }

    @Test(enabled = false) //@Ignore
    public void test2() {
        System.out.println("Test2");
    }

    @Test(priority = 1)
    public void test3() {
        System.out.println("Test3");
    }

    @Test(priority = 2) //priority girilmez ise default 0 olarak ilk o calisir
    public void test4() {
        System.out.println("Test4");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After class");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After test");
    }
}
