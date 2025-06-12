package com.eurotech.tests.day_01_automation_intro;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;

public class C03_JavaFakerDemo {
    public static void main(String[] args) {

        //mock - sahte data üretmek için kullanılır
        Faker faker = new Faker();

        //sahte isim
        String fullName = faker.name().fullName();
        System.out.println("fullName = " + fullName);

        //sahte şehir
        String city = faker.address().city();
        System.out.println("city = " + city);

        //kredi kartı
        String creditCard = faker.finance().creditCard();
        System.out.println("creditCard = " + creditCard);

        String creditCard1 = faker.finance().creditCard(CreditCardType.MASTERCARD);
        System.out.println("creditCard1 = " + creditCard1);

        //email
        String emailAddress = faker.internet().emailAddress();
        System.out.println("emailAddress = " + emailAddress);

        //password
        String password = faker.internet().password();
        System.out.println("password = " + password);

        //password - istenen özelliklerde
        String password1 = faker.internet().password(8, 16, true, true, true);
        System.out.println("password1 = " + password1);

    }
}
