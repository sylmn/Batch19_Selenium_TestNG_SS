package com.eurotech.tests.day_20_DDF;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C04_DDF_LoginTest extends TestBase {

    @DataProvider
    public Object[][] userData(){
        ExcelUtil qaTeam1 = new ExcelUtil(ConfigurationReader.get("excelPath"),"QaTeam1");
        String[][] qaTeam1Multi = qaTeam1.getDataArrayWithoutFirstRow();

        return qaTeam1Multi;
    }

    @Test(dataProvider = "userData")
    public void loginTestWithDDF(String username, String email, String password){

        extentLogger = report.createTest("TC-0012 " + username + "'nin Login Testi");

        LoginPage loginPage = new LoginPage();

        extentLogger.info("Eurotech login sayfasına gidilir.");
        extentLogger.info("Geçerli email/password girilir");
        loginPage.login(email, password);

        extentLogger.info("Başarılı login işlemi username ile doğrulanır");
        DashboardPage dashboardPage = new DashboardPage();
        String actualUsername = dashboardPage.userName.getText();
        Assert.assertEquals(actualUsername, username);

        extentLogger.pass("Passed..!");

    }

    @DataProvider
    public Object[][] userData2(){
        ExcelUtil qaTeam2 = new ExcelUtil(ConfigurationReader.get("excelPath"),"QaTeam2");
        String[][] qaTeam2Multi = qaTeam2.getDataArrayWithoutFirstRow();

        return qaTeam2Multi;
    }

    @Test(dataProvider = "userData2")
    public void loginTestWithDDF2( String email, String password, String username){

        extentLogger = report.createTest("TC-0013 " + username + "'nin Login Testi");

        LoginPage loginPage = new LoginPage();

        extentLogger.info("Eurotech login sayfasına gidilir.");
        extentLogger.info("Geçerli email/password girilir");
        loginPage.login(email, password);

        extentLogger.info("Başarılı login işlemi username ile doğrulanır");
        DashboardPage dashboardPage = new DashboardPage();
        String actualUsername = dashboardPage.userName.getText();
        Assert.assertEquals(actualUsername, username);

        extentLogger.pass("Passed..!");

    }
}
