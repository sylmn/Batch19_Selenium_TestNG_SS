package com.eurotech.pages;

import com.eurotech.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BasePage {
//    public DashboardPage(){
//        PageFactory.initElements(Driver.get(),this);
//    }

    @FindBy(xpath = "//h2")
    public WebElement userName;


}
