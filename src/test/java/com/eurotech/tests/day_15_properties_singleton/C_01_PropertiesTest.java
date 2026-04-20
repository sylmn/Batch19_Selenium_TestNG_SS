package com.eurotech.tests.day_15_properties_singleton;

import com.eurotech.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class C_01_PropertiesTest {

    @Test
    public void test1(){
        String browser = ConfigurationReader.get("browser");
        System.out.println("browser = " + browser);
    }
}
