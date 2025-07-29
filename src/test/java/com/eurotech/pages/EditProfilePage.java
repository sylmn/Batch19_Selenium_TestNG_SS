package com.eurotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class EditProfilePage extends BasePage{

    @FindBy(xpath = "//button[text()='Save Changes']")
    public WebElement saveChangesBtn;

    @FindBy(id = "about")
    public WebElement aboutBox;

    @FindBy(xpath = "(//input[@id='company'])[1]")
    public WebElement companyBox;

    @FindBy(xpath = "//select[@id='job']")
    public WebElement jobSelectionDropdown;

    @FindBy(xpath = "//input[@id='website']")
    public WebElement websiteBox;

    @FindBy(xpath = "(//input[@id='location'])[1]")
    public WebElement locationBox;

    @FindBy(xpath = "//input[@id='skills']")
    public WebElement skillsBox;


    public void jobSelect(String jobName){
        Select select = new Select(jobSelectionDropdown);
        select.selectByVisibleText(jobName);
    }
}
