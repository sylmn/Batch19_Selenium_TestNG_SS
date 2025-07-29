package com.eurotech.tests.day_05_06_xPath;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C08_RelativeXpath_withMethod {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        /**
         * open a chrome browser
         * navigate to https://demowebshop.tricentis.com/
         * locate "Simple Computer Add to Cart Button" with the name of product
         * ürün adını parametre olarak alan bir metod yazın ve ürünün add to cart butonuna click yapsın..
         * close driver
         *
         * meraklısına "Simple Computer","$25 Virtual Gift Card","Build your own cheap computer" ürünlerinin
         * add to cart buttonuna sırasıyla click yapan bir test yazın. yukarıdaki metodu kullanarak click
         * işlemini yapalım. ürünlerin isimlerini uygun java yapılarından çağırabiliriz..
         */
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demowebshop.tricentis.com/");

        //locate "Simple Computer Add to Cart Button" with the name of product

        //WebElement simpleComAddTochartBtn = driver.findElement(By.xpath("//a[text()='Simple Computer']/ancestor::div[@class='details']//input"));
        //simpleComAddTochartBtn.click();
        addToChart("Simple Computer");
        Thread.sleep(2000);
        driver.close();
    }

    private static void addToChart(String productName) {
        WebElement productAddToCart = driver.findElement(By.xpath("//a[text()='" + productName + "']/ancestor::div[@class='details']//input"));
        productAddToCart.click();
    }

    private static void viewProduct(String product){
        WebElement productView=driver.findElement(By.xpath("//p[text()='"+product+"']/ancestor::div[@class=\"product-image-wrapper\"]//li/a"));
        productView.click();
    }
}
