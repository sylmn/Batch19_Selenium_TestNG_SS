package com.eurotech.tests.day_21_otherTopics;

import org.testng.annotations.Test;

public class getEnvMethod {
    /**
     * enviroment variablesta bulunan değişkenlere erişmek için kullanılır.
     */

    @Test
    public void test1(){
        String pass = System.getenv("paswordTest19");
        System.out.println("pass = " + pass);
    }
}
