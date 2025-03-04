package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class BasePage {
    WebDriver driver;
    WebElement element;
    Wait<WebDriver> wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement waitUntilElementAppear(By element){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void enterPage(String pageUrl) {
        driver.get(pageUrl);

    }

    public boolean findElement(String xpath) {
        driver.findElement(By.xpath(xpath)).isDisplayed();
        return true;
    }

    public void clickOnElement(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }
    public void clickOnElement(By element){
        waitUntilElementAppear(element);
        driver.findElement(element).click();
    }

    public void typeText(String xpath, String text) {
        driver.findElement(By.xpath(xpath)).sendKeys(text);
    }

    public void verifyErrorMessage(String xpath, String expectedMessage, String textDontAppear) {
        assertTrue(driver.findElement(By.xpath(xpath)).getText().contains(expectedMessage), textDontAppear);
    }
    public String readTextFromElement(By element){
        waitUntilElementAppear(element);
        return driver.findElement(element).getText();
    }
    public WebElement returnItemWithBiggestPrice(By element, By itemPrice){
        ArrayList<WebElement> itemList = new ArrayList<>(driver.findElements(element));
        double maxPrice = 0.0;
        WebElement maxPriceElement = null;
        for(WebElement item : itemList){
            String priceText = item.findElement(itemPrice).getText();
            double price = Double.parseDouble(priceText.substring(1));
            if (price > maxPrice){
                maxPrice = price;
                maxPriceElement = item;
            }
        }
        return maxPriceElement;
    }
    public WebElement returnItemWithSmallestPrice(By element, By itemPrice){

        ArrayList<WebElement> itemList = new ArrayList<>(driver.findElements(element));
        double minPrice = Double.MAX_VALUE;
        WebElement minPriceElement = null;
        for(WebElement item : itemList){
            String priceText = item.findElement(itemPrice).getText();
            double price = Double.parseDouble(priceText.substring(1));
            if (price < minPrice){
                minPrice = price;
                minPriceElement = item;
            }
        }
        return minPriceElement;
    }
    public void returnAllItems(By element, String button){
        ArrayList<WebElement> itemList = new ArrayList<>(driver.findElements(element));
        for(WebElement item: itemList){
            item.findElement(By.tagName(button)).click();
        }
    }
    public void quitDriver() {
        driver.quit();
    }

}
