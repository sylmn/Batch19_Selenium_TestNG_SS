package com.eurotech.tests.day_11_alerts_multipleWindows_iframes;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class C_04_Iframes {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void iframeWithIdAndWebElement(){
        /**
         * navigate to https://testpages.herokuapp.com/styled/iframes-test.html
         * switch to first frame by id
         * take the "iFrame" heading and print it
         * return to main html
         * switch to second frame by web element
         * take the "Nested Page Example" heading and print it
         */

        driver.get("https://testpages.herokuapp.com/styled/iframes-test.html");
        WebElement mainElement = driver.findElement(By.tagName("h1"));
        System.out.println("mainElement.getText() = " + mainElement.getText());


        driver.switchTo().frame("thedynamichtml");

        WebElement firstFrameElement = driver.findElement(By.tagName("h1"));
        System.out.println("firstFrameElement.getText() = " + firstFrameElement.getText());

        driver.switchTo().parentFrame();

        WebElement secondIframe = driver.findElement(By.cssSelector("[src='frames/frames-header.html']"));
        driver.switchTo().frame(secondIframe);

        WebElement secondFrameElement = driver.findElement(By.tagName("h1"));
        System.out.println("secondFrameElement.getText() = " + secondFrameElement.getText());

    }

    @Test
    public void iframeWithIndex(){
        /**
         * navigate to https://testpages.herokuapp.com/styled/iframes-test.html
         * switch to first frame by index
         * take the "iFrame" heading and print it
         * return to main html  (default content)
         * switch to second frame by index
         * take the "Nested Page Example" heading and print it
         */

        driver.get("https://testpages.herokuapp.com/styled/iframes-test.html");

        driver.switchTo().frame(0);

        WebElement firstFrame = driver.findElement(By.tagName("h1"));
        System.out.println("firstFrame.getText() = " + firstFrame.getText());

        driver.switchTo().defaultContent();

        driver.switchTo().frame(1);

        WebElement secondFrame = driver.findElement(By.tagName("h1"));
        System.out.println("secondFrame.getText() = " + secondFrame.getText());
    }
}

/**
 * No Such Element Exception aldığımızda
 * 1- Locator might be wrong or dynamic or not correct-Locator/konumlandırıcı
 yanlış veya dinamik olabilir veya doğru olmayabilir.
 * 2- Not enough wait time - Yeterli bekleme süresi yok
 * 3- There is a frame or iframe -Bir frame veya iframe var !
 - Html'de bir HTML sayfasının içinde bir diğer HTML yapısı olabilir.
 - Bu, <iframe> veya <frame> etiketi ile sağlanır.
 - Frame varsa, selenyum frame içinde ne olduğunu kontrol edemez.
 - Önce iframe'i değiştirmeliyiz. (switchTo() metodu ile)
 - iframe'e geçtiğimizde, selenium biz geri değiştirene kadar ana HTML sayfasını ve diğer frame yapılarını göremez,
 - Bir seferde sadece bir frame değiştirebiliriz ve torunlara doğrudan geçilmez.
 - kardeş/sibling arası geçiş/switch olmaz sadece ebeveynden çocuğa/parentchild.
 - child frameden bir üste yani parenta switchTo().parentFrame(); ile geçeriz.
 - en üstteki ana HTML (default) yapısına ise switchTo().defaultContent(); ile geçebiliriz.
 - bulunduğumuz frame'den bir üste ya da en üste (ana HTML) geçiş vardır. iki, üç vb. üstlere geçiş yoktur.
 - switchTo().frame()----> üç farklı parametre ile çalışır...
 1. id ya da name attribute değeri ile  ex: driver.switchTo().frame("frame1");
 2. index numarası ile ex:  driver.switchTo().frame(0);
 3. Web Element ile  ex: WebElement frame2 = driver.findElement(By.cssSelector("[src='frames/frames-header.html']"));
 driver.switchTo().frame(frame2);
 */
