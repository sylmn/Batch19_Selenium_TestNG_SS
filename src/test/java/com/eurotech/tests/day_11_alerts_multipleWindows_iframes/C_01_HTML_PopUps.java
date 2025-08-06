package com.eurotech.tests.day_11_alerts_multipleWindows_iframes;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class C_01_HTML_PopUps {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void htmlPopups() throws InterruptedException {
        /**  CLASS TASK
         * navigate to https://testpages.herokuapp.com/styled/alerts/fake-alert-test.html
         * click show fake alert box
         * verify that ok button can be seen on the popup
         * take the text on popup and print it (I am a fake alert box!) and verify
         * then click on ok at the popup
         * verify that ok button cannot be seen
         */

        driver.get("https://testpages.herokuapp.com/styled/alerts/fake-alert-test.html");
        WebElement fakeAlertBtn = driver.findElement(By.cssSelector("#fakealert"));
        fakeAlertBtn.click();
        Thread.sleep(2000);

        WebElement okBtn = driver.findElement(By.id("dialog-ok"));
        Assert.assertTrue(okBtn.isDisplayed());

        WebElement fakeText = driver.findElement(By.cssSelector("[id='dialog-text']"));
        String actualText = fakeText.getText();
        String expectedText = "I am a fake alert box!";

        Assert.assertEquals(actualText, expectedText, "TC-212-Fake alert box texts should be same");

        okBtn.click();

        Assert.assertFalse(okBtn.isDisplayed());
    }

    @Test
    public void html_Popup_task() throws InterruptedException {
        /**
         * go to http://primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=73437
         * click on confirm button
         * click on yes at the popup window
         * make verification with confirmed popup
         */

        driver.get("http://primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=73437");
        Thread.sleep(2000);


        WebElement confirmButton = driver.findElement(By.xpath("(//span[text()='Confirm'])[1]"));
        confirmButton.click();

        Thread.sleep(2000);

        WebElement yesButton = driver.findElement(By.xpath("//span[.='Yes']"));
        yesButton.click();

        Thread.sleep(2000);

        WebElement confirmationPopUp = driver.findElement(By.xpath("//p[.='You have accepted']"));

        //make verification
        String actual = confirmationPopUp.getText();
        String expected = "You have accepted";
        Assert.assertEquals(actual,expected);
    }
}
