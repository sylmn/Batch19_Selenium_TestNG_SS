package com.eurotech.pages;

import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class LoginPage extends BasePage {
    /**
     * PageFactory.initElements()   webElement leri locate etmek çin gerekli olan   By class ının tanımla hale getirir
     * <p>
     * aksi halde
     *
     * @FindBy ile tanımlanan elementler null olarak kalır
     * NullPointerException alınır
     */

    //    public LoginPage(){
    //        PageFactory.initElements(Driver.get(),this);
    //    }

    // WebElement emailBox = driver.findElement(By.id("email"));

    @FindBy(id = "email")
    public WebElement emailBox;

    @FindBy(id = "yourPassword")
    public WebElement passwordBox;

    @FindBy(xpath = "//button")
    public WebElement loginBtn;


    // AND logic ile çalışır... Yani verilen tüm locator lara sahip olan webElement i bulur
    @FindBys({
            @FindBy(id = "email"),
            @FindBy(xpath = "//input[@name='email']")
    })
    public WebElement emailBoxWithFindBys;


    // OR logic ile çalışır. Verilen locator lara ilişkin bütün webElementleri bulup getirir. (çoğul dönebilir)
    @FindAll({
            @FindBy(css = "#yourPassword"),
            @FindBy(css = ".samet")
    })
    public WebElement passwordBoxWithFindAll;


    @FindBy(xpath = "//div[contains(text(),'Password is incorrect. Please check')]")
    public WebElement wrongPasswordMessage;

    @FindBy(xpath = "//div[contains(text(),'Email address is incorrect. Please check')]")
    public WebElement wrongUserEmailMessage;

    @FindBy(css = "[role=\"alert\"]")
    public WebElement wrongCrendtialMessage;

    @FindBy(css = ".form-control,button")
    public List<WebElement> loginInputs;


    public void login() {
        emailBox.sendKeys(ConfigurationReader.get("userEmail"));
        passwordBox.sendKeys(ConfigurationReader.get("password"));
        loginBtn.click();

    }

    public void login(String userEmail, String password) {
        emailBox.sendKeys(userEmail);
        passwordBox.sendKeys(password);
        loginBtn.click();
    }


}
