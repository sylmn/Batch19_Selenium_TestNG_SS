package com.eurotech.pages;

import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class UserProfilePage extends BasePage {

    @FindBy(css = "ol.breadcrumb>li:nth-of-type(2)")
    public WebElement userProfilePageTitle;

    @FindBy(css = "#profile-overview>div:nth-of-type(1)")
    public WebElement profileUpdateMesg;

    public void navigateUserProfileTabs(String tabName) {
        WebElement tab = Driver.get().findElement(By.xpath("//li//button[text()='" + tabName + "']"));
        tab.click();
    }

    public String lastAddedSchoolName(String schoolName) {
        return Driver.get().findElement(By.xpath("(//span[text()='" + schoolName + "'])")).getText();

    }

    public void deleteLastAddedEducationRecord(String schoolName) {
        WebElement deleteBtn = Driver.get().findElement(By.xpath("(//span[text()='Yildirim'])[last()]/ancestor::tr//a"));
        BrowserUtils.scrollToElement(deleteBtn);
        BrowserUtils.clickWithJS(deleteBtn);
        Alert alert = Driver.get().switchTo().alert();
        alert.accept();
    }
}
