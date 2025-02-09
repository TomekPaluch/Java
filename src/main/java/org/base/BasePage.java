package org.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class    BasePage {
    WebDriver driver;
    WebElement element;
    public BasePage(WebDriver driver){
        this.driver= driver;
    }
    public void enterPage(String pageUrl){
        driver.get(pageUrl);

    }
    public boolean findElement(String xpath){
        driver.findElement(By.xpath(xpath)).isDisplayed();
        return true;
    }
    public void clickOnElement(String xpath){
        driver.findElement(By.xpath(xpath)).click();
    }
    public void typeText( String xpath, String text) {
    driver.findElement(By.xpath(xpath)).sendKeys(text);
    }

}
