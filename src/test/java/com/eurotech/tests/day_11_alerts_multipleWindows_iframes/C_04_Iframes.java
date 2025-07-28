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

    @Test
    public void iFrameExample(){
        /**
         * navigate to https://testpages.herokuapp.com/styled/frames/frames-test.html
         * switch to top frame by name attribute
         * take the "Nested Frames Example" heading and print it
         * return to main html
         * switch to left frame by name attribute
         * take the "Left" heading and print it
         * return to main html
         * switch to middle frame by index
         * take the "Middle" heading and print it
         * return to main html
         * switch to right frame by web element
         * take the "Right" heading and print it
         * return to main html
         * switch to footer frame by index
         * take the "EvilTester.com" link text and print it
         */

        driver.get("https://testpages.herokuapp.com/styled/frames/frames-test.html");
        driver.switchTo().frame("top");
      //  driver.switchTo().frame(0);
        WebElement topTitle = driver.findElement(By.cssSelector("h1"));
        System.out.println("topTitle.getText() = " + topTitle.getText());
        driver.switchTo().parentFrame();

        driver.switchTo().frame("left");
        WebElement leftTitle = driver.findElement(By.tagName("h1"));
        System.out.println("leftTitle.getText() = " + leftTitle.getText());
        driver.switchTo().defaultContent();

        driver.switchTo().frame(2);
        WebElement middleTitle = driver.findElement(By.tagName("h1"));
        System.out.println("middleTitle.getText() = " + middleTitle.getText());
        driver.switchTo().defaultContent();

        WebElement rightFrame = driver.findElement(By.cssSelector("[src='get-list?name=Right&list=50']"));
        driver.switchTo().frame(rightFrame);
        WebElement rightTitle = driver.findElement(By.xpath("//h1"));
        System.out.println("rightTitle.getText() = " + rightTitle.getText());
        driver.switchTo().parentFrame();

        driver.switchTo().frame(4);
        WebElement evilLink = driver.findElement(By.linkText("EvilTester.com"));
        System.out.println("evilLink.getText() = " + evilLink.getText());

    }

    @Test
    public void nestedFrames() throws InterruptedException {
        /**
         * navigate to https://demoqa.com/nestedframes
         * switch to parent frame by id
         * take the "Parent frame" heading and print it
         * switch to child frame by index
         * take the "Child frame" heading and print it
         * switch to main frame related method
         * take the "Nested Frames" heading and print it
         */

        driver.get("https://demoqa.com/nestedframes");
        driver.switchTo().frame("frame1");
        WebElement parentBody = driver.findElement(By.tagName("body"));
        System.out.println("parentBody.getText() = " + parentBody.getText());

        driver.switchTo().frame(0);
        WebElement childTitle = driver.findElement(By.tagName("p"));
        System.out.println("childTitle.getText() = " + childTitle.getText());

        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();

        WebElement mainTitle = driver.findElement(By.cssSelector("#framesWrapper>.text-center"));
        System.out.println("mainTitle.getText() = " + mainTitle.getText());
    }

    @Test
    public void iframeTask() throws InterruptedException {
        /**
         * navigate to https://the-internet.herokuapp.com/iframe
         * get te text of heading "An iFrame containing the TinyMCE WYSIWYG Editor" and print it
         * "Your content goes here." take this writing and print it
         * get te text of heading "An iFrame containing the TinyMCE WYSIWYG Editor" and print it again.
         * NOT : frame geçişlerinde id veya name kullanalım.
         */

        // NOT: ******** Taskın olduğu site paralı olmuş, task çalışmıyor şu anda. **********

        driver.get("https://the-internet.herokuapp.com/iframe");
        Thread.sleep(2000);

        //we will be able to locate this element since it is in the default HTML
        WebElement upTitle = driver.findElement(By.xpath("//textarea[@id='mce_0']/../h3"));
        System.out.println("upTitle.getText() = " + upTitle.getText());

        //we will not be able to locate this element since it is in another HTML/frame
        /*WebElement targetElement = driver.findElement(By.xpath("//p[text()='Your content goes here.']"));
        System.out.println("targetElement.getText() = " + targetElement.getText());*/

        //switch driver to the target html block by using "id value" or "name value"
        driver.switchTo().frame("mce_0_ifr");

        WebElement targetElement = driver.findElement(By.xpath("//p[text()='Your content goes here.']"));
        System.out.println("targetElement.getText() = " + targetElement.getText());

        //switch driver to the parent (default) HMTL
        //go back to parent frame
        driver.switchTo().parentFrame();

        //tekrar locate etmek gerekir mi? Hayır gerekmez ama burada tekrar locate edilmiştir.
        WebElement upTitle1 = driver.findElement(By.xpath("//textarea[@id='mce_0']/../h3"));
        System.out.println("upTitle1.getText() = " + upTitle1.getText());
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
