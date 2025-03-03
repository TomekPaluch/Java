package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class MainPage extends BasePage{

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private final By titleLabelBy = By.className("title");
    private final By burgerMenuBy = By.id("react-burger-menu-btn");
    private final By logoutButtonBy = By.id("logout_sidebar_link");
    private final By backpackAddToCartButtonBy = By.id("add-to-cart-sauce-labs-backpack");
    private final By shoppingCartIconBy = By.className("shopping_cart_link");
    private final By allItemsBy = By.className("inventory_item");
    private final By priceBy = By.className("inventory_item_price");
    private final By itemNameBy = By.className("inventory_item_name");
    private final By allAddToCartButtonsBy = By.xpath("//button[contains(@id,'add-to-cart')]");

    public String readTitle(){
        return readTextFromElement(titleLabelBy);
    }
    public void openDropDownMenu(){
        clickOnElement(burgerMenuBy);
    }
    public void logOut(){
        clickOnElement(logoutButtonBy) ;
    }
    public WebElement findMostExpensiveItem(){
        ArrayList<WebElement> itemList = new ArrayList<WebElement>(driver.findElements(allItemsBy));
        double maxPrice = 0.0;
        WebElement maxPriceElement = null;
        for(WebElement item : itemList){
            String priceText = item.findElement(priceBy).getText();
            double price = Double.parseDouble(priceText.substring(1));
            if (price > maxPrice){
                maxPrice = price;
                maxPriceElement = item;
            }
        }
        return maxPriceElement;
    }
    public void clickOnMostExpensiveItem(){
        findMostExpensiveItem().findElement(By.tagName("button")).click();
    }

    public WebElement findLeastExpensiveItem(){
        ArrayList<WebElement> itemList = new ArrayList<WebElement>(driver.findElements(allItemsBy));
        double minPrice = Double.MAX_VALUE;
        WebElement minPriceElement = null;
        for(WebElement item : itemList){
            String priceText = item.findElement(priceBy).getText();
            double price = Double.parseDouble(priceText.substring(1));
            if (price < minPrice){
                minPrice = price;
                minPriceElement = item;
            }
        }
        return minPriceElement;
    }

    public void clickOnLeastExpensiveItem() {
        findLeastExpensiveItem().findElement(By.tagName("button")).click();
    }
}

