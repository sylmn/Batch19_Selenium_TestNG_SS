package com.eurotech.tests.day_16_pom_1;

import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C02_NegativeLoginTest extends TestBase {

    @Test
    public void wrongPasswordTest() {
        /**
         * navigate to https://sdettest.eurotechstudy.eu/login
         * type in correct username
         * type in wrong password
         * verify that user cannot login
         * and takes the warning message: "Password is incorrect. Please check"
         */

        LoginPage loginPage=new LoginPage();

        loginPage.emailBox.sendKeys(ConfigurationReader.get("userEmail"));
        loginPage.passwordBox.sendKeys("wrongPassword");
        loginPage.loginBtn.click();

      //  loginPage.login(ConfigurationReader.get("userEmail"),"wrongPassword");

      //  String actualMessage=loginPage.wrongPasswordMessage.getText();
        String actualMessage=loginPage.wrongCrendtialMessage.getText();
        String expectedMessage="Password is incorrect. Please check";

        Assert.assertEquals(actualMessage,expectedMessage,"the message should be same.");

    }

    @Test
    public void wrongEmailTest() {
        /**
         * navigate to https://sdettest.eurotechstudy.eu/login
         * type in wrong username
         * type in correct password
         * verify that user cannot login
         * and takes the warning message: "Email address is incorrect. Please check"
         */

        LoginPage loginPage=new LoginPage();

        loginPage.login("wrongUserEmail",ConfigurationReader.get("password"));

        // verification
      //  String actualMessage=loginPage.wrongUserEmailMessage.getText();
        String actualMessage=loginPage.wrongCrendtialMessage.getText();
        String expectedMessage="Email address is incorrect. Please check";

        Assert.assertEquals(actualMessage,expectedMessage,"the message should be same.");
    }
}
