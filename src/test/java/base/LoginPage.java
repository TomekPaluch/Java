package base;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPage extends BasePage{
    private WebDriver driver;
    private WebElement element;
    private String userNameXpath = "//*[@id=\"user-name\"]";
    private String userNameText = "standard_user";
    private String passwordField = "//*[@id=\"password\"]";
    private String passwordFieldText = "secret_sauce";
    private String loginButton = "//*[@id=\"login-button\"]";
    private String invalidLogin="Test";
    private String invalidPassword = "12345";
    private String errorPopUp = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3";
    private String errorMessage = "Epic sadface: Username and password do not match any user in this service";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterPage(){
        enterPage("https://www.saucedemo.com");
    }

    public void validLogin(){
        typeText(userNameXpath, userNameText);
    }
    public void validpassword(){
        typeText(passwordField, passwordFieldText);
    }
    public void clickOnLoginButton(){
        clickOnElement(loginButton);
    }

    public void invalidLogin(){
        typeText(userNameXpath, invalidLogin);
    }
    public void invalidPassword(){
        typeText(passwordField, invalidPassword);
    }
    public void verifyErrorMessage(){
        verifyErrorMessage(errorPopUp, errorMessage, "Text not found");
    }

}
