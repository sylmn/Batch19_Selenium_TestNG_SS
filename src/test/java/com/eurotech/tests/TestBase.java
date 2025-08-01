package com.eurotech.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class TestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest extentLogger;

    @BeforeTest
    public void setUpTest(){
        report = new ExtentReports();
        String projectPath = System.getProperty("user.dir");
        String reportPath = projectPath+"/test-output/report.html"; //burada sadece yolunu olusturduk

        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String reporthPath = projectPath+"/test-output/report"+date+".html";
        htmlReporter = new ExtentHtmlReporter(reportPath); //burada dosya olusturuluyor
        report.attachReporter(htmlReporter);
        htmlReporter.config().setReportName("Smoke Test");
        report.setSystemInfo("Environment","QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));
        report.setSystemInfo("Test Engineer",ConfigurationReader.get("userName"));
        report.setSystemInfo("PO","Süleyman Süleyman");

    }
    @AfterTest
    public void tearDownTest(){
        report.flush();
    }
    @BeforeMethod
    public void setup (){
        driver= Driver.get();
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.get("url"));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        actions=new Actions(Driver.get());
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        //test basarisiz olursa
        if (result.getStatus()==ITestResult.FAILURE){
            //basarisiz testin adini alalim
            extentLogger.fail(result.getName());

            //ekran görüntüsü alalim ve kayit edildigi yeri belirleyelim
            String screenShotPath = BrowserUtils.getScreenshot(result.getName());
            //screen shot'i rapora ekleyelim
            extentLogger.addScreenCaptureFromPath(screenShotPath);
            //hata loglarini da rapora ekleyelim
            extentLogger.fail(result.getThrowable());

        }
        Driver.closeDriver();
    }
}
