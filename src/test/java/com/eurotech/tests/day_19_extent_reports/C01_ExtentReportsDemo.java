package com.eurotech.tests.day_19_extent_reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class C01_ExtentReportsDemo {

    /**
     * SOLID --> Info
     * S - Single Responsibility Principle (SRP)
     * O – Open/Closed Principle (OCP)
     * L – Liskov Substitution Principle (LSP)
     * I – Interface Segregation Principle (ISP)
     * D – Dependency Inversion Principle (DIP)
     */

    //Bu class rapor olusturmak ve rapor ile ilgili metadata'yi tanimlamak icin kullanilir.
    ExtentReports report;

    //Bu class raporumuzun HTML formatinda olmasini saglar.
    ExtentHtmlReporter htmlReporter;

    //Her test ile ilgili log kayitlari almamizi ve test adimlarini tanimlamamizi saglar
    ExtentTest extentLogger;

    @BeforeMethod
    public void before() {
        //rapor objemizi initialize edelim
        report = new ExtentReports();

        //raporun kayit edilecegi yeri belirleyelim
        String projectPath = System.getProperty("user.dir");
        String reportPath = projectPath + "/test-output/report.html"; //burada sadece yolunu olusturduk

        //html raporumuzu path ile olusturalim
        htmlReporter = new ExtentHtmlReporter(reportPath); //burada dosya olusturuluyor

        //html raporumuzu, rapor objesi ile iliskilendirelim (attach)
        report.attachReporter(htmlReporter);

        //raporumuza baslik verelim
        htmlReporter.config().setReportName("Smoke Test");

        //Raporumuzun environment (metadata) bilgilerini düzenleyelim
        report.setSystemInfo("Environment", "QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS", System.getProperty("os.name"));
        report.setSystemInfo("Test Engineer", ConfigurationReader.get("userName"));
        report.setSystemInfo("PO", "Süleyman Süleyman");
    }

    @Test
    public void test1() {
        //mevcut bu testimizin adini girelim
        extentLogger = report.createTest("TC001 Demo Test");

        //test adimlarini tekrar tekrar girelim
        extentLogger.info("chrome browseri ac");

        extentLogger.info("web sayfasina git");
        //kod buraya yazilacak - code here

        extentLogger.info("email gir");
        //kod buraya yazilacak - code here

        extentLogger.info("password gir");
        //kod buraya yazilacak - code here

        extentLogger.info("login butonuna click yap");
        //kod buraya yazilacak - code here

        extentLogger.info("Login oldugunuzu kullanici adi ile dogrula " + ConfigurationReader.get("userName"));
        //kod buraya yazilacak - code here

        extentLogger.pass("Passed...!");
    }

    @AfterMethod
    public void after() {
        //raporun gercek anlamda olusturuldugu yer
        report.flush();
    }
}
