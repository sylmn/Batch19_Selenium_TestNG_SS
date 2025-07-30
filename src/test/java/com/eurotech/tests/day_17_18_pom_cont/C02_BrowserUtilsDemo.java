package com.eurotech.tests.day_17_18_pom_cont;

import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_BrowserUtilsDemo {
    WebDriver driver;


    @BeforeMethod
    public void setUp() {
        driver = Driver.get();
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test1(){
        /**
         * go to https://the-internet.herokuapp.com/windows
         * take the window title
         * click the "Click Here" link
         * switch to new window
         * take the new window title
         * print both titles -> "The Internet" and "New Window"
         *
         * NOTE : Use BrowserUtils Method
         */

        driver.get("https://the-internet.herokuapp.com/windows");
        String titleBeforeClick = driver.getTitle();

        driver.findElement(By.linkText("Click Here")).click();

        BrowserUtils.switchToWindow("New Window");

        String titleAfterClick = driver.getTitle();

        System.out.println("titleBeforeClick = " + titleBeforeClick);
        System.out.println("titleAfterClick = " + titleAfterClick);

    }

    @Test
    public void test2(){
        /**
         * go to https://the-internet.herokuapp.com/hovers
         * hover over image1
         * get the text of image1
         * print it.
         *
         * NOTE : Use BrowserUtils Method
         */

        driver.get("https://the-internet.herokuapp.com/hovers");
        WebElement user1 = driver.findElement(By.xpath("(//div[@class='figure'])[1]"));

        BrowserUtils.hover(user1);

        String elementText = BrowserUtils.getElementText(By.xpath("(//h5)[1]"));

        System.out.println("elementText = " + elementText);


    }

    @Test
    public void highlight(){
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement clickHere = driver.findElement(By.linkText("Click Here"));

        BrowserUtils.highlight(clickHere);


    }

}
