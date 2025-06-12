package com.eurotech.tests.day_02_webdrivers_basics;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class C02_CloseAndQuit {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();
        driver.get("https://www.eurotechstudy.com/en/index");
        driver.close();

        WebDriver driver1 = new FirefoxDriver();
        driver1.manage().window().setPosition(new Point(-1000,0));
        driver1.manage().window().maximize();
        driver1.navigate().to("https://www.amazon.de/?&tag=hydraamazon09-21&ref=pd_sl_781ozcfkw7_e&adgrpid=153217435865&hvpone=&hvptwo=&hvadid=674893335740&hvpos=&hvnetw=g&hvrand=11651312360688594205&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9044109&hvtargid=kwd-10573980&hydadcr=12763_2327837");
        driver1.quit();

        //kapanmis bir driveri tekrar kullanmak istersem

        driver1=new ChromeDriver();
        driver1.manage().window().setPosition(new Point(-1000,0));
        driver1.manage().window().maximize();
        driver1.get("https://www.eurotechstudy.com/en/index");
        driver1.quit();
    }
}
