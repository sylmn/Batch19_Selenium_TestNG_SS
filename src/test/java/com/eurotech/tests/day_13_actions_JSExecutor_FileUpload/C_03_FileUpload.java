package com.eurotech.tests.day_13_actions_JSExecutor_FileUpload;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;

public class C_03_FileUpload {
    WebDriver driver;



    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void fileUpload(){
        /** CLASS TASK
         * go to https://demoqa.com/upload-download
         * upload ccc.txt (which is on your desktop)
         * verify that the file is uploaded
         *
         * win  ==> shift+rightClick
         * OC   ==> command+rightClick
         */

        driver.get("https://demoqa.com/upload-download");

        WebElement uploadFile = driver.findElement(By.id("uploadFile"));

        uploadFile.sendKeys("C:/Users/ihsan/OneDrive/Masaüstü/ccc.txt");

        WebElement uploadedFilePath = driver.findElement(By.id("uploadedFilePath"));
        String  actualFile = uploadedFilePath.getText();
        String  expectedFile = "ccc.txt";

        Assert.assertTrue(actualFile.contains(expectedFile));
    }

    @Test
    public void systemPropertiesTest(){
        /**
         * eğer bir pc ile ilgili bilgileri almak istiyorsak bu metodu kullanırız.
         */

        Properties properties = System.getProperties();
     //   properties.list(System.out);

        System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));
        System.out.println("System.getProperty(\"user.name\") = " + System.getProperty("user.name"));
        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));
        System.out.println("System.getProperty(\"user.home\") = " + System.getProperty("user.home"));
    }

    @Test
    public void fileUpload2(){

        /** CLASS TASK
         * proje kapsamında dosya yükleme işlemi
         * test klasörü altında resources directory'si oluşturulur (projeye dışarıdan eklenecek dosyalar burada olur.)
         * upload edilecek dosya bu klasöre kopyalanır (ccc.txt)
         * System.getProperty() metodu kullanılarak.. projenin yolu (path) alınır..
         * upload edilecek dosyaya sağ click yapılarak, projeden sonraki yolu (path) alınır..
         * iki path araya "/"  slash konularak birleştirilir. Artık projeyi her indirenin kullanabileceği path oluşur..
         * bu path kullanılarak dosya upload edilir.
         */

        driver.get("https://demoqa.com/upload-download");

        WebElement uploadFile = driver.findElement(By.id("uploadFile"));

        String projeninYolu = System.getProperty("user.dir");
        String projeIcindeDosyaninYolu = "src/test/resources/ccc.txt";

        String dosyaninTamYolu = projeninYolu+ "/"+ projeIcindeDosyaninYolu;

        uploadFile.sendKeys(dosyaninTamYolu);

        WebElement uploadedFilePath = driver.findElement(By.id("uploadedFilePath"));
        String  actualFile = uploadedFilePath.getText();
        String  expectedFile = "ccc.txt";

        Assert.assertTrue(actualFile.contains(expectedFile));

    }

    @Test
    public void fileDownload() throws InterruptedException {
        /**
         * navigate to https://demoqa.com/upload-download
         * click on download button
         * verify that the sampleFile.jpeg file is downloaded to the Downloads directory
         *
         * Note: Bir dosyanın bilgisayarınızda verilen path'in gösterdiği yerde olup olmadığını
         * Java'dan gelen Files classının exists metodu ile kontrol edebiliriz. Bu metod bir boolean değer döner.
         */

        driver.get("https://demoqa.com/upload-download");

        WebElement downloadButton = driver.findElement(By.id("downloadButton"));
        downloadButton.click();

        Thread.sleep(3000);

        //dosyanın indiğini doğrulayalım
        String filePath = System.getProperty("user.home")+"/Downloads/sampleFile.jpeg";
        System.out.println("filePath = " + filePath);

        Assert.assertTrue(Files.exists(Paths.get(filePath)));

    }

    @Test
    public void fileUpload_Task(){
        /**
         * resources klasöründe fileUploadDemo.txt dosyası oluştur.
         * https://the-internet.herokuapp.com/upload sitesine git
         * sitedeki dosya yükleme kısmına bu dosyayı yükle (dynamic path ile)
         * Upload butonuna bas
         * çıkan sayfadan yüklenen dosyanın ismini doğrula
         */

        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile= driver.findElement(By.cssSelector("#file-upload"));

        String projectPath=System.getProperty("user.dir");
        String filePath="src/test/resources/fileUploadDemo.txt";
        String fullPath=projectPath+"/"+filePath;
        System.out.println("fullPath = " + fullPath);

        chooseFile.sendKeys(fullPath);
        driver.findElement(By.id("file-submit")).click();

        String actualText=driver.findElement(By.id("uploaded-files")).getText();

        Assert.assertEquals(actualText, "fileUploadDemo.txt");
    }
}
