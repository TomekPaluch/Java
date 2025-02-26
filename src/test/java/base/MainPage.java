package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage{

    public MainPage(WebDriver driver) {
        super(driver);
    }

    By titleLabelBy = By.className("title");
    By burgerMenuBy = By.id("react-burger-menu-btn");
    By logoutButtonBy = By.id("logout_sidebar_link");
    By backpackAddToCartButtonBy = By.id("add-to-cart-sauce-labs-backpack");
    By shoppingCartIconBy = By.className("shopping_cart_link");
    By allItemsBy = By.className("inventory_item");
    By priceBy = By.className("inventory_item_price");
    By itemNameBy = By.className("inventory_item_name");
    By allAddToCartButtonsBy = By.xpath("//button[contains(@id,'add-to-cart')]");

    public String readTitle(){
        return readTextFromElement(titleLabelBy);
    }
    public void openDropDownMenu(){
        clickOnElement(burgerMenuBy);
    }
}
