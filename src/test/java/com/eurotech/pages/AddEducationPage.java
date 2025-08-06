package com.eurotech.pages;

import com.eurotech.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AddEducationPage extends BasePage{

    @FindBy(xpath = "//div/button[text()='Add Education']")
    public WebElement addEducationBtn;

    @FindBy(id="school")
    public WebElement schoolBox;

    @FindBy(id="todateedu")
    public WebElement toDateBox;

    @FindBy(xpath = "(//textarea[@id='description'])[2]")
    public WebElement descriptionBox;

    public void fillEducationForm(String schoolName, String degree, String study,String fromDate,
                                        String toDate, String desc){
        Actions actions = new Actions(Driver.get());

        actions.click(schoolBox)
                .sendKeys(schoolName + Keys.TAB)
                .sendKeys(degree + Keys.TAB)
                .sendKeys(study + Keys.TAB)
                .sendKeys(fromDate + Keys.TAB + Keys.TAB).perform();

        toDateBox.sendKeys(toDate);
        descriptionBox.sendKeys(desc);
        addEducationBtn.click();
    }
}
