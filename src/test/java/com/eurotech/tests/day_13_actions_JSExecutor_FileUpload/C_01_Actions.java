package com.eurotech.tests.day_13_actions_JSExecutor_FileUpload;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class C_01_Actions {
    WebDriver driver;

    Actions actions;


    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void hoverOver() throws InterruptedException {
        /**
         * navigate to https://testpages.herokuapp.com/styled/csspseudo/css-hover.html
         * hover over "Hover Para" element
         * get the text which is seen after hover action
         * and verify that the text is "You can see this paragraph now that you hovered on the above 'button'."
         * also verify that the text is displayed (use explicit wait)
         * hover over the "Hover Div" and verify that the text is not displayed anymore. (use explicit wait)
         */

        driver.navigate().to("https://testpages.herokuapp.com/styled/csspseudo/css-hover.html");
        WebElement hoverPara = driver.findElement(By.id("hoverpara"));

       // Actions actions = new Actions(driver);  bu satıra gerek yok çünkü obje globale alındı.

        actions.moveToElement(hoverPara).perform();
        Thread.sleep(2000);

        WebElement hoverEffect = driver.findElement(By.cssSelector("#hoverparaeffect"));
        String actualText = hoverEffect.getText();
        String expectedText = "You can see this paragraph now that you hovered on the above 'button'.";

        Assert.assertEquals(actualText, expectedText);
        Assert.assertTrue(new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(hoverEffect)).isDisplayed());

        WebElement hoverDivPara = driver.findElement(By.id("hoverdivpara"));

        actions.moveToElement(hoverDivPara).perform();
        Assert.assertTrue(new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOf(hoverEffect)));

    }

    @Test
    public void hoverOver_Task() {
        /**
         * go to https://the-internet.herokuapp.com/hovers
         * locate all users (image on the page) with findElements()
         * hover over all of them and verify that "name:user1-2-3" is displayed
         * if any time issues solve them with implicitly or explicitly waits
         */

        driver.get("https://the-internet.herokuapp.com/hovers");

        //(//img)[2]
        //(//img)[3]
        //(//img)[4]

        //h5[text()='name: user1']
        //h5[text()='name: user2']
        //h5[text()='name: user3']

        driver.get("https://the-internet.herokuapp.com/hovers");

        for (int i = 2; i <= 4; i++) {
            String imgXPath = "(//img)[" + i + "]";
            WebElement img = driver.findElement(By.xpath(imgXPath));

            actions.moveToElement(img).perform();

            String userText = "//h5[text()='name: user" + (i - 1) + "']";
            WebElement user = driver.findElement(By.xpath(userText));

            Assert.assertTrue(new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(user)).isDisplayed());
        }
    }
    @Test
    public void dragAndDrop(){
        /**
         * go to https://webdriveruniversity.com/Actions/index.html
         * take the "DRAG ME TO MY TARGET!" box and drop it "DROP HERE!" place
         * verify that "Dropped!" text is displayed..(make text correction at the same time)
         */

        driver.get("https://webdriveruniversity.com/Actions/index.html");

        WebElement draggable = driver.findElement(By.cssSelector("div#draggable"));
        WebElement droppable = driver.findElement(By.cssSelector("div#droppable"));

        //1.yol
      //  actions.dragAndDrop(draggable, droppable).perform();

        //2.yol
        actions.moveToElement(draggable).clickAndHold().moveToElement(droppable).pause(2000).release().build().perform();

        WebElement dropped = driver.findElement(By.cssSelector("div#droppable>p"));
        String actualText = dropped.getText();
        String expectedText = "Dropped!";

        Assert.assertEquals(actualText, expectedText);

    }

    @Test
    public void dragAndDrop_Task(){
        /**
         * go to https://demoqa.com/droppable
         * take "Drag me" and drop it "Drop here" section
         * verify that the "Dropped!" message is displayed (make text verification)
         */

        driver.get("https://demoqa.com/droppable");

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        Actions actions = new Actions(driver);

        actions.dragAndDrop(source, target).perform();

        WebElement verifyMessage = driver.findElement(By.xpath("//p[text()='Dropped!']"));
        System.out.println("verifyMessage.getText() = " + verifyMessage.getText());

        Assert.assertTrue(verifyMessage.isDisplayed());
        Assert.assertEquals(verifyMessage.getText(), "Dropped!", "Verify that element has dropped");
    }

    @Test
    public void clickWithAction(){
        /**  CLASS TASK
         * navigate to https://skill-test.net/mouse-double-click
         * make double click to the Click box
         * make a normal click to the Click Box (not the middle of element)
         */

        driver.get("https://skill-test.net/mouse-double-click");
        WebElement clicker = driver.findElement(By.id("clicker"));

        //double click
        //1. yol
        actions.doubleClick(clicker).perform();
        //2.yol
        actions.moveToElement(clicker).doubleClick().perform();

        //koordinat ile click
        actions.moveToElement(clicker, 100,60).perform();

        //normal click
        actions.click(clicker).perform();
        actions.moveToElement(clicker).click().perform();
    }

    @Test
    public void rightClick() throws InterruptedException {
        /**  CLASS TASK
         * navigate to https://skill-test.net/right-click-test
         * make right click to the Start box and wait three seconds
         * make normal click on Reset box (use actions)
         */

        driver.get("https://skill-test.net/right-click-test");
        WebElement startBtn = driver.findElement(By.id("clicker"));

        //context click - sağ click
        actions.contextClick(startBtn).perform();

        Thread.sleep(3000);

        WebElement resetBtn = driver.findElement(By.id("reset"));

        actions.click(resetBtn).perform();
    }

    @Test
    public void rightClickOpenNewWindow(){
        /**
         * go to https://testpages.herokuapp.com/styled/csspseudo/css-hover.html
         * make right click and open in new tab  (sağ ctrl+click) - EvilTester'a click yapılacak.
         * switch to new opened tab
         * verify that the page title is "EvilTester.com"
         */

        driver.get("https://testpages.herokuapp.com/styled/csspseudo/css-hover.html");
        WebElement evilTester = driver.findElement(By.linkText("EvilTester.com"));

        actions.keyDown(Keys.LEFT_CONTROL)
                .click(evilTester)
                .keyUp(Keys.LEFT_CONTROL)
                .perform();

        String currentWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String handle : allWindowHandles){
            if (!handle.equals(currentWindowHandle)){
                driver.switchTo().window(handle);
            }
        }

        String actualTitle = driver.getTitle();
        String expectedTitle = "EvilTester.com";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

}
