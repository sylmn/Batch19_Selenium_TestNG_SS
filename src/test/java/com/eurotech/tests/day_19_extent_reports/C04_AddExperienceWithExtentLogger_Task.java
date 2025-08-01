package com.eurotech.tests.day_19_extent_reports;

import com.eurotech.pages.AddExperiencePage;
import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.pages.UserProfilePage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C04_AddExperienceWithExtentLogger_Task extends TestBase {
    @Test
    public void addExperienceTest() {
        /**
         1-navigate to https://sdettest.eurotechstudy.eu/login
         2-Make login
         3-Assert successful login with username
         4-Navigate to My Profile with related method
         5-Verify that User Profile page is displayed
         6-Navigate to Add Experience tab with related method
         7-Verify that add experience page is displayed
         8-Fill the form with non-parameterized method (using actions class is optional)
         9-Verify that added experience record can be seen at user profile page...
         (assert with job title)
         10-Delete last added experience record
         */

        extentLogger = report.createTest("TC005 Add Experience Part Information Test");
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        UserProfilePage userProfilePage = new UserProfilePage();
        AddExperiencePage addExperiencePage = new AddExperiencePage();

        extentLogger.info("Open " + ConfigurationReader.get("browser") + " browser");
        extentLogger.info("Navigate to " + ConfigurationReader.get("url"));
        extentLogger.info("Make login");
        loginPage.login();

        extentLogger.info("Assert successful login with username");
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(dashboardPage.userName)).isDisplayed());
        String actualName = dashboardPage.userName.getText();
        String expectedName = ConfigurationReader.get("userName");
        Assert.assertEquals(actualName, expectedName);

        extentLogger.info("Navigate to My Profile with related method");
        dashboardPage.navigateToTabs(ConfigurationReader.get("userName"), "My Profile");

        extentLogger.info("Verify that User Profile page is displayed");
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(userProfilePage.userProfilePageTitle)).isDisplayed());
        String actualHeader = userProfilePage.profileDetailsHeader.getText();
        String expectedHeader = "Profile Details";
        Assert.assertEquals(actualHeader, expectedHeader);

        extentLogger.info("Navigate to Add Experience tab with related method");
        userProfilePage.navigateUserProfileTabs("Add Experience");

        extentLogger.info("Verify that add experience page is displayed");
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(addExperiencePage.jobTitleHdr)).isDisplayed());
        String actualTextInAddExp = addExperiencePage.jobTitleHdr.getText();
        String expectedTextInAddExp = "Job Title *";
        Assert.assertEquals(actualTextInAddExp, expectedTextInAddExp);

        extentLogger.info("Fill the form with non-parameterized method");
        addExperiencePage.fillExperienceForm();

        extentLogger.info("Verify that added experience record can be seen at user profile page");
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(userProfilePage.profileDetailsHeader)).isDisplayed());
        String actualJobTitleTextInProfAdd = userProfilePage.jobTitleInProfilePage.getText();
        String expectedJobTitleTextInProfAdd = "SDET";
        Assert.assertEquals(actualJobTitleTextInProfAdd, expectedJobTitleTextInProfAdd);

        extentLogger.info("Delete last added experience record");
        userProfilePage.deleteLastAddedRecord("SDET");
    }
}
