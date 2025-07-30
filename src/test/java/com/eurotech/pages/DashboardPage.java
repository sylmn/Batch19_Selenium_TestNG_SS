package com.eurotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {
//    public DashboardPage(){
//        PageFactory.initElements(Driver.get(),this);
//    }

    @FindBy(xpath = "//h2")
    public WebElement userName;

    @FindBy(css = ".breadcrumb>li:nth-of-type(2)")
    public WebElement pageTitleLeftTop;


}
