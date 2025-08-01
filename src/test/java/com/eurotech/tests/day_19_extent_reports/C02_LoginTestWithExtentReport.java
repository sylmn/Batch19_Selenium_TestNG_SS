package com.eurotech.tests.day_19_extent_reports;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C02_LoginTestWithExtentReport extends TestBase {
    @Test
    public void positiveLoginTest_4() {
        /**
         * navigate to https://sdettest.eurotechstudy.eu/login
         * login with valid credentials
         * verify that the user's name is seen on dashboard page
         */
        extentLogger = report.createTest("TC002 Positive Login Test");

        extentLogger.info("navigate to https://sdettest.eurotechstudy.eu/login");
        extentLogger.info("login with valid credentials");
        LoginPage loginPage = new LoginPage();
        loginPage.login();

        extentLogger.info("verify that the user's name is seen on dashboard page");
        DashboardPage dashboardPage = new DashboardPage();
        String actualUserName = dashboardPage.userName.getText();
        String expectedUserName = ConfigurationReader.get("userName");
        Assert.assertEquals(actualUserName, expectedUserName, "solo");

        extentLogger.pass("Passed...!");

    }

    @Test
    public void wrongPasswordTest() {
        /**
         * Navigate to https://sdettest.eurotechstudy.eu/login
         * Type in correct username
         * Type in wrong password
         * Verify that user cannot log in
         * Takes the warning message: "Password is incorrect. Please check"
         */

        extentLogger = report.createTest("TC003 Negative Login Test (Wrong Password)");

        extentLogger.info("navigate to " + ConfigurationReader.get("url"));
        LoginPage loginPage = new LoginPage();

        extentLogger.info("type in correct username");
        loginPage.emailBox.sendKeys(ConfigurationReader.get("userEmail"));

        extentLogger.info("type in wrong password");
        loginPage.passwordBox.sendKeys("wrongPassword");

        extentLogger.info("click on login button");
        loginPage.loginBtn.click();

        extentLogger.info("passwort is incorrect");
        //  loginPage.login(ConfigurationReader.get("userEmail"),"wrongPassword");

        //  String actualMessage=loginPage.wrongPasswordMessage.getText();
        String actualMessage = loginPage.wrongCrendtialMessage.getText();
        String expectedMessage = "Password is incorrect. Please check";

        Assert.assertEquals(actualMessage, expectedMessage, "the message should be same.");
        extentLogger.pass("passed");
    }
}
