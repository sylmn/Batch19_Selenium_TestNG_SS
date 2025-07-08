package com.eurotech.tests.day_15_properties_singleton;

public class C_02_SingletonDemo {

    private C_02_SingletonDemo(){}
    //private constructor sayesinde bu classtan obje (instance) üretilemez.

    private static String driver;

    public static String getDriver(){
        if (driver == null){
            System.out.println("driver boştur, lütfen ona değer atayınız");
            driver = "firefox";
        }else{
            System.out.println("driver boş değildir, size nevcut driver'ı dönüyorum.");
        }

        return driver;
    }
}
