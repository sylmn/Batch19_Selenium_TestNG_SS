package com.eurotech.tests.day_17_18_pom_cont;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.EditProfilePage;
import com.eurotech.pages.LoginPage;
import com.eurotech.pages.UserProfilePage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class C03_EditProfileTest extends TestBase {

    @Test
    public void editProfile(){
        /**
         * Class Task
         * THIS TASK WILL BE IMPLEMENTED USING POM
         * which means we will have one test class for the test
         * and one corresponding page having all locators and actions for the page
         *
         * go to https://sdettest.eurotechstudy.eu/login
         * enter valid credentials (your credentials)
         * wait for usernames are displayed (both middle and right top)
         * go to Username (Leeroy) --> myProfile
         * wait for page title is displayed
         *** create a method that navigate you to specific module based on the given parameter
         * go to Edit Profile page using the method just mentioned above
         * fill out the fields
         * -->about --> SDET programme , graduated from EuroTech
         * -->Company --> Google
         * -->Job  --> QA Automation Engineer
         * -->Website --> www.google.com
         * -->Location --> Istanbul
         * -->Skills --> Java,Selenium, TestNG
         * click save changes button
         * verify that "Profile Updated" message is appeared
         */

        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        UserProfilePage userProfilePage = new UserProfilePage();
        EditProfilePage editProfilePage = new EditProfilePage();

        loginPage.login();

        BrowserUtils.waitForVisibility(dashboardPage.userName, 15);
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.usernameAtRightTop));
      //  new WebDriverWait(Driver.get(), Duration.ofSeconds(12)).until(ExpectedConditions.visibilityOf(dashboardPage.usernameAtRightTop));

        dashboardPage.navigateToTabs(ConfigurationReader.get("userName"), "My Profile");

        //burada page title gözükene kadar bekleme yapıyoruz
        BrowserUtils.waitForVisibility(userProfilePage.userProfilePageTitle,15);
        //burada ise page title gözükene kadar bekleme yaptıktan sonra, gözüktüğünü doğruluyoruz.
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(userProfilePage.userProfilePageTitle)).isDisplayed());

        userProfilePage.navigateUserProfileTabs("Edit Profile");

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(editProfilePage.saveChangesBtn)).isDisplayed());

        editProfilePage.aboutBox.clear();
        editProfilePage.aboutBox.sendKeys("SDET programme , graduated from EuroTech");

        BrowserUtils.clearAndSendKeys(editProfilePage.companyBox, "Google");

        editProfilePage.jobSelect("QA Automation Engineer");

        BrowserUtils.clearAndSendKeys(editProfilePage.websiteBox, "www.google.com");
        BrowserUtils.clearAndSendKeys(editProfilePage.locationBox, "Istanbul");
        BrowserUtils.clearAndSendKeys(editProfilePage.skillsBox, "Java, Selenium, TestNG");

        editProfilePage.saveChangesBtn.click();

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(userProfilePage.profileUpdateMessage)).isDisplayed());

        String actualMessage = userProfilePage.profileUpdateMessage.getText();
        String expectedMessage = "Profile Updated";

        Assert.assertEquals(actualMessage, expectedMessage);

    }

}
