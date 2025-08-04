package com.eurotech.tests.day_20_DDF;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C03_DataProviderDemo {

    @DataProvider
    public Object[][] notesData() {
        String[][] notes = {
                {"Hasan Kaya", "70", "85"},
                {"Aslı Sönmez", "100", "62"},
                {"Emime Akay", "88", "25"},
                {"Ramazan Tolu", "89", "80"}
        };

        return notes;
    }

    @Test(dataProvider = "notesData")
    public void notes(String name, String visaNote, String finalNote) {
        System.out.println(name + " : " + visaNote + " -> " + finalNote);
    }

    @DataProvider (name = "notlar")
    public Object[][] notesData_1() {
        Object[][] notes = {
                {"Hasan Kaya", 70, 85},
                {"Aslı Sönmez", 100, 62},
                {"Emime Akay", 88, 25},
                {"Ramazan Tolu", 89, 80}
        };

        return notes;
    }

    @Test(dataProvider = "notlar")
    public void notes_1(String name, int visaNote, int finalNote) {
        System.out.println(name + " : " + visaNote + " -> " + finalNote + " Yıl Sonu Notu : " + (visaNote*0.4 + finalNote*0.6));
    }
}
