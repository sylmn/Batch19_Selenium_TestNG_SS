package com.eurotech.tests.day_11_alerts_multipleWindows_iframes;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Set;

public class C_03_MultipleWindows {
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
    public void singleWindow() throws InterruptedException {
        /**   CLASS TASK
         * navigate to "https://testpages.herokuapp.com/styled/windows-test.html"
         * click Basic Ajax in new page
         * switch to new opened page
         * verify that the page title is "Test Page For Basic Ajax Example"
         * verify that the new page's url is different
         */

        driver.get("https://testpages.herokuapp.com/styled/windows-test.html");
        WebElement basicAjaxInNewPage = driver.findElement(By.linkText("Basic Ajax in new page"));
        basicAjaxInNewPage.click();

        Thread.sleep(2000);

        System.out.println("driver.getTitle() = " + driver.getTitle());

        String currentWindow = driver.getWindowHandle();

        System.out.println("currentWindow = " + currentWindow);

        Set<String> allWindows = driver.getWindowHandles();

        System.out.println("allWindows = " + allWindows);

        for( String windowHandle : allWindows){
            if (!windowHandle.equals(currentWindow)){
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        String expectedTitle = "Test Page For Basic Ajax Example";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);

        String firstURL = "https://testpages.herokuapp.com/styled/windows-test.html";
        String secondURL = driver.getCurrentUrl();

        Assert.assertNotEquals(firstURL, secondURL);

    }

    @Test
    public void multipleWindow(){
        /**  CLASS TASK
         * navigate to "https://testpages.herokuapp.com/styled/windows-test.html"
         * click all three links
         * switch to the page whose title is "Test Page For Element Attributes"
         * verify that the page title
         * verify that the new page's url is different
         */

        driver.get("https://testpages.herokuapp.com/styled/windows-test.html");
        WebElement basicAjaxInNewPage = driver.findElement(By.linkText("Basic Ajax in new page"));
        WebElement attributesInNewPage = driver.findElement(By.linkText("Attributes in new page"));
        WebElement newWindowForJS = driver.findElement(By.linkText("Alerts In A New Window From JavaScript"));

        basicAjaxInNewPage.click();
        attributesInNewPage.click();
        newWindowForJS.click();

        String targetTitle = "Test Page For Element Attributes";

        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String handle : allWindowHandles){
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(targetTitle)){
                break;
            }
        }

        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, targetTitle);

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://testpages.herokuapp.com/styled/windows-test.html";

        Assert.assertFalse(actualURL.equals(expectedURL));
    }
}
