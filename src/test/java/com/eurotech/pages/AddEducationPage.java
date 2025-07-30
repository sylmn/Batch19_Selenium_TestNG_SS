package com.eurotech.pages;

import com.eurotech.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AddEducationPage extends BasePage{
    @FindBy(xpath = "//div/button[text()='Add Education']")
    public WebElement addEducationBtn;

    @FindBy(id = "school")
    public WebElement schollBox;

    public void fillEducationForm(String schollName, String degree, String study,String fromDAte, String toDate,String descr){
        Actions actions=new Actions(Driver.get());
        actions.click(schollBox)
                .sendKeys(schollName+ Keys.TAB)
                .sendKeys(degree+Keys.TAB)
                .sendKeys(study+Keys.TAB)
                .sendKeys(fromDAte+Keys.TAB+Keys.TAB)
                /**
                 * .sendKeys(fromDate + Keys.TAB + Keys.TAB).perform();
                 *
                 *                 toDateBox.sendKeys(toDate);
                 *
                 *                 actions.click(descriptionBox)
                 *                         .sendKeys(desc+Keys.TAB+Keys.ENTER).perform();
                 */
                .sendKeys(toDate+Keys.TAB)
                .sendKeys(descr+Keys.TAB+Keys.ENTER)
                .perform();
    }
}
