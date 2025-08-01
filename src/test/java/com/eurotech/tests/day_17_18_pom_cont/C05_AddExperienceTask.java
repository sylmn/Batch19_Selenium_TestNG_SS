package com.eurotech.tests.day_17_18_pom_cont;

import com.eurotech.pages.AddExperiencePage;
import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.pages.UserProfilePage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C05_AddExperienceTask extends TestBase {

    @Test
    public void addExperienceTest(){
        /**
         1-navigate to https://sdettest.eurotechstudy.eu/login
         2-make login
         3-Assert successful login with user name
         4-Navigate to My Profile with related method
         5-Verify that User Profile page is displayed
         6-Navigate to Add Experience tab with related method
         7-Verify that add experince page is displayed
         8-Fill the form with non-parameterized method (using actions class is optional)
         9-Verify that added experience record can be seen at user profile page... (assert with job title)
         10-Delete last added experience record

         important note: every student should use own credentials, otherwise the test case will fail....
         */

        LoginPage loginPage=new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        UserProfilePage userProfilePage = new UserProfilePage();
        AddExperiencePage addExperiencePage=new AddExperiencePage();
        loginPage.login();

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(dashboardPage.userName)).isDisplayed());
        String actualName = dashboardPage.userName.getText();
        String expectedName = ConfigurationReader.get("userName");
        Assert.assertEquals(actualName,expectedName);

        dashboardPage.navigateToTabs(ConfigurationReader.get("userName"),"My Profile");
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(userProfilePage.userProfilePageTitle)).isDisplayed());
        String actualHeader = userProfilePage.profileDetailsHeader.getText();
        String expectedHeader= "Profile Details";
        Assert.assertEquals(actualHeader,expectedHeader);

        userProfilePage.navigateUserProfileTabs("Add Experience");
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(addExperiencePage.jobTitleHdr)).isDisplayed());
        String actualTextInAddExp=addExperiencePage.jobTitleHdr.getText();
        String expectedTextInAddExp = "Job Title *";
        Assert.assertEquals(actualTextInAddExp,expectedTextInAddExp);
        addExperiencePage.fillExperienceForm();

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(userProfilePage.profileDetailsHeader)).isDisplayed());

        String actualJobTitleTextInProfAdd=userProfilePage.jobTitleInProfilePage.getText();
        String expectedJobTitleTextInProfAdd = "SDET";
        Assert.assertEquals(actualJobTitleTextInProfAdd,expectedJobTitleTextInProfAdd);

        userProfilePage.deleteLastAddedRecord("SDET");

    }
}
