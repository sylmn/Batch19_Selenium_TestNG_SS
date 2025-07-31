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

        extentLogger = report.createTest("TC004 Positive Login Test");

        extentLogger.info("navigate to "+ConfigurationReader.get("url"));
        extentLogger.info("login with valid credentials");
        LoginPage loginPage=new LoginPage();
        loginPage.login("leeroyjenkins@email.com","1234.Asdf");

        extentLogger.info("verify that the user's name is seen on dashboard page");
        DashboardPage dashboardPage=new DashboardPage();
        String actualUserName=dashboardPage.userName.getText();
        String expectedUserName= ConfigurationReader.get("userName");
        Assert.assertEquals(actualUserName,expectedUserName, "should be same");

        extentLogger.pass("Passed..!");

    }

    @Test
    public void wrongPasswordTest() {
        /**
         * navigate to https://sdettest.eurotechstudy.eu/login
         * type in correct username
         * type in wrong password
         * verify that user cannot login
         * and takes the warning message: "Password is incorrect. Please check"
         */

        extentLogger = report.createTest("TC008 Negative Login Test (Wrong Password)");

        extentLogger.info("navigate to " + ConfigurationReader.get("url"));
        LoginPage loginPage=new LoginPage();

        extentLogger.info("type in correct username");
        loginPage.emailBox.sendKeys(ConfigurationReader.get("userEmail"));

        extentLogger.info("type in wrong password");
        loginPage.passwordBox.sendKeys("wrongPassword");

        extentLogger.info("click on login button");
        loginPage.loginBtn.click();

        extentLogger.info("and takes the warning message: Password is incorrect. Please check");
        String actualMessage=loginPage.wrongCrendtialMessage.getText();
        String expectedMessage="Password is incorrect. Please check";
        Assert.assertEquals(actualMessage,expectedMessage,"the message should be same.");

        extentLogger.pass("Passed.");

    }
}
