package com.eurotech.tests.day_19_extent_reports;

import com.eurotech.pages.AddEducationPage;
import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.pages.UserProfilePage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C03_AddEducationWithExtentReport extends TestBase {
    @Test
    public void addEducationTest(){
        /**
         1-open chrome browser
         2-navigate to https://sdettest.eurotechstudy.eu/login by using configuration.properties
         3-login with parameterized/non-parameterized method
         4-Assert successful login with user name
         5-Navigate to My Profile with related method
         6-Verify that User Profile page is displayed
         7-Navigate to Add Education tab with related method
         8-Verify that add education page is displayed
         9-Fill the form with parameterized method (use actions class)
         10-Verify that added education record can be seen at user profile page... (assert with school name)
         11-Delete last added education record

         important note: every student should use own credentials, otherwise the test case will fail....
         */

        extentLogger = report.createTest("TC125 Add Education Test");

        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        UserProfilePage userProfilePage = new UserProfilePage();
        AddEducationPage addEducationPage = new AddEducationPage();

        extentLogger.info("open chrome browser");
        extentLogger.info("navigate to "+ConfigurationReader.get("url")+" by using configuration.properties");
        extentLogger.info("login with parameterized/non-parameterized method");
        loginPage.login();

        extentLogger.info("Assert successful login with user name");
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(dashboardPage.userName)).isDisplayed());
        String actualUserName = dashboardPage.userName.getText();
        String expectedUserName = ConfigurationReader.get("userName");
        Assert.assertEquals(actualUserName, expectedUserName);

        extentLogger.info("Navigate to My Profile with related method");
        dashboardPage.navigateToTabs(ConfigurationReader.get("userName"), "My Profile");

        extentLogger.info("Verify that User Profile page is displayed");
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(userProfilePage.userProfilePageTitle)).isDisplayed());

        extentLogger.info("Navigate to Add Education tab with related method");
        userProfilePage.navigateUserProfileTabs("Add Education");

        extentLogger.info("Verify that add education page is displayed");
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(addEducationPage.addEducationBtn)).isDisplayed());

        extentLogger.info("Fill the form with parameterized method (use actions class)");
        addEducationPage.fillingAddEducationForm("Uçanevler","Ortaokul","Sözel","10102017",
                "10102022","Hard program");

        extentLogger.info("Verify that added education record can be seen at user profile page... (assert with school name)");
        String lastAddedSchoolName = userProfilePage.lastAddedSchoolName("Uçanevler");
        String expectedSchoolName = "Uçanevler";
        Assert.assertEquals(lastAddedSchoolName, expectedSchoolName);

        extentLogger.info("Delete last added education record");
        userProfilePage.deleteLastAddedEducationRecord("Uçanevler");

        extentLogger.pass("Passed..");

    }
}
