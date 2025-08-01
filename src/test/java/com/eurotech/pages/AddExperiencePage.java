package com.eurotech.pages;

import com.eurotech.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AddExperiencePage extends BasePage {

    @FindBy(xpath = "//label[text()='Job Title *']")
    public WebElement jobTitleHdr;

    @FindBy(xpath = "//div/button[text()='Add Experience']")
    public WebElement addExperienceBtn;

    @FindBy(xpath = "//input[@placeholder='Job Title *']")
    public WebElement jobTitleBox;

    @FindBy(id = "todateexp")
    public WebElement toDateBox;

    @FindBy(xpath = "(//textarea[@id='description'])[1]")
    public WebElement descriptionBox;

    String jobTitle = "SDET";
    String company = "ABC";
    String location = "Izmir";
    String fromDate = "10102013";
    String toDate = "10102016";
    String descr = "Job is very easy";

    public void fillExperienceForm() {
        Actions actions = new Actions(Driver.get());
        actions.click(jobTitleBox)
                .sendKeys(jobTitle + Keys.TAB)
                .sendKeys(company + Keys.TAB)
                .sendKeys(location + Keys.TAB)
                .sendKeys(fromDate + Keys.TAB + Keys.TAB).perform();
        toDateBox.sendKeys(toDate);
        actions.click(descriptionBox)
                .sendKeys(descr + Keys.TAB + Keys.ENTER).perform();
    }
}
