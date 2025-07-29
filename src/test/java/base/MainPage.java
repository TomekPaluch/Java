package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {

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
    private final String button = "button";

    public String readTitle() {
        return readTextFromElement(titleLabelBy);
    }

    public void openDropDownMenu() {
        clickOnElement(burgerMenuBy);
    }

    public void logOut() {
        clickOnElement(logoutButtonBy);
    }

    public WebElement findMostExpensiveItem() {
        return returnItemWithBiggestPrice(allItemsBy, priceBy);
    }

    public void clickOnMostExpensiveItem() {
        findMostExpensiveItem().findElement(By.tagName(button)).click();
    }

    public WebElement findLeastExpensiveItem() {
        return returnItemWithSmallestPrice(allItemsBy, priceBy);
    }

    public void clickOnLeastExpensiveItem() {
        findLeastExpensiveItem().findElement(By.tagName(button)).click();
    }

    public void selectAllItems() {
        returnAllItems(allItemsBy, button);
    }

}

