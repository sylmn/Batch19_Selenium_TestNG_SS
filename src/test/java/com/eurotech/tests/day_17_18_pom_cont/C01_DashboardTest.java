package com.eurotech.tests.day_17_18_pom_cont;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C01_DashboardTest extends TestBase {

    @Test
    public void tabMenuTest(){
        /**
         * go to login page
         * login with valid credentials
         * verify that you are on the dashboard page by using 'Dashboard' keyword at top-left
         * Verify that tabs menu contains "Dashboard", "Developers", "Components", "Forms",  "JavaScript", "Leeroy"
         */

        LoginPage loginPage = new LoginPage();
        loginPage.login();

        DashboardPage dashboardPage = new DashboardPage();
        String actualTitle = dashboardPage.pageTitleLeftTop.getText();
        String expectedTitle = "Dashboard";

        Assert.assertEquals(actualTitle, expectedTitle, "TC001 - Verifying dashboard page title");

        List<WebElement> tabMenuElements = dashboardPage.tabMenu;

        List<String> tabMenuNames = new ArrayList<>();

        for (WebElement tabMenuElement : tabMenuElements) {
            tabMenuNames.add(tabMenuElement.getText());
        }

        List<String> expectedTabNames = new ArrayList<>
                (Arrays.asList("Dashboard", "Developers", "Components", "Forms",  "JavaScript", "Leeroy"));

        Assert.assertEquals(tabMenuNames, expectedTabNames);
    }

    @Test
    public void tabMenuTest_1(){
        /**
         * go to login page
         * login with valid credentials
         * verify that you are on the dashboard page by using 'Dashboard' keyword at top-left
         * Verify that tabs menu contains "Dashboard", "Developers", "Components", "Forms",  "JavaScript", "Leeroy"
         */

        LoginPage loginPage = new LoginPage();
        loginPage.login();

        DashboardPage dashboardPage = new DashboardPage();
        String actualTitle = dashboardPage.pageTitleLeftTop.getText();
        String expectedTitle = "Dashboard";

        Assert.assertEquals(actualTitle, expectedTitle, "TC001 - Verifying dashboard page title");

        List<String> tabMenuNames = BrowserUtils.getElementsText(dashboardPage.tabMenu);

        List<String> expectedTabNames = new ArrayList<>
                (Arrays.asList("Dashboard", "Developers", "Components", "Forms",  "JavaScript", "Leeroy"));

        Assert.assertEquals(tabMenuNames, expectedTabNames);
    }

    @Test
    public void navigateTabMenu(){
        /**
         * login with valid credentials
         * go to 'Developers' tab via navigateToTabs()
         * validate that you are on the right page through url
         * expectedUrl = https://sdettest.eurotechstudy.eu/developers
         */

        LoginPage loginPage = new LoginPage();
        loginPage.login();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToTabs("Developers");

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://sdettest.eurotechstudy.eu/developers";

        Assert.assertEquals(actualURL, expectedURL);

    }

    @Test
    public void navigateTabMenu_1(){
        /**
         * login with valid credentials
         * go to 'Components --> Modal' submodule via navigateToTabsAndModule( two parameters)
         * validate that you are on the right page through url
         * expected url : https://sdettest.eurotechstudy.eu/components/modal
         *
         * then navigate to Developer tab and make verification with url
         */

        LoginPage loginPage = new LoginPage();
        loginPage.login();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToTabs("Components", "Modal");

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://sdettest.eurotechstudy.eu/components/modal";

        Assert.assertEquals(actualURL, expectedURL);

        dashboardPage.navigateToTabs("Developers");

        String actualURL_1 = driver.getCurrentUrl();
        String expectedURL_1 = "https://sdettest.eurotechstudy.eu/developers";

        Assert.assertEquals(actualURL_1, expectedURL_1);
    }
}
