package base;

import loadData.LoadData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPage extends BasePage {
    private WebDriver driver;
    private WebElement element;
    private LoadData loadData;
    private final String userNameXpath = "//*[@id=\"user-name\"]";
    private String passwordField = "//*[@id=\"password\"]";
    private String loginButton = "//*[@id=\"login-button\"]";
    private String errorPopUp = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3";
    private String errorMessage = "Epic sadface: Username and password do not match any user in this service";
    private String userNameRequired = "Epic sadface: Username is required";
    private String passwordRequired = "Epic sadface: Password is required";

    public LoginPage(WebDriver driver) {
        super(driver);
        this.loadData = LoadData.getInstance();
    }

    public void enterPage() {
        enterPage(loadData.getUrl());
    }

    public void validLogin() {
        typeText(userNameXpath, loadData.getValidUsername());
    }

    public void validPassword() {
        typeText(passwordField, loadData.getValidPassword());
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
    }

    public void invalidLogin() {
        typeText(userNameXpath, loadData.getInvalidUsername());
    }

    public void invalidPassword() {
        typeText(passwordField, loadData.getInvalidPassword());
    }

    public void verifyUserNameAndPasswordDoNotMatch() {
        verifyErrorMessage(errorPopUp, errorMessage, "Username and password do not match any user");
    }

    public void verifyUserNameIsRequiredError() {
        verifyErrorMessage(errorPopUp, userNameRequired, "UserName is required");
    }

    public void verifyPasswordNameIsRequiredError(){
        verifyErrorMessage(errorPopUp, passwordRequired, "Password is required");
    }


}
