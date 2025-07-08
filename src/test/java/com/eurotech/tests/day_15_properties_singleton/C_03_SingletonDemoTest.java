package com.eurotech.tests.day_15_properties_singleton;

import org.testng.annotations.Test;

public class C_03_SingletonDemoTest {

    @Test
    public void test1(){
     //   C_02_SingletonDemo c02SingletonDemo = new C_02_SingletonDemo(); bu classtan obje üretilemez

        String driver = C_02_SingletonDemo.getDriver();
        System.out.println("driver = " + driver);

        System.out.println("----------------");

        String driver1 = C_02_SingletonDemo.getDriver();
        System.out.println("driver1 = " + driver1);
    }
}
