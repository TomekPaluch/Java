package org.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
    private WebDriver driver;
    private WebElement element;
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void Test(){
        enterPage("https://www.saucedemo.com");
    }

    public void inputUsername(String xpath){
        clickOnElement(xpath);
    }
}
