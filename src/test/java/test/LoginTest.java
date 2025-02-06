package test;

import org.base.LoginPage;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginTest {
    private WebDriver driver;
    private WebElement element;
    private LoginPage loginPage;
    private String userNameXpath = "//*[@id=\"user-name\"]";
    private String userNameText = "standard_user";
    private String passwordField = "//*[@id=\"password\"]";
    private String passwordFieldText = "secret_sauce";
    private String loginButton = "//*[@id=\"login-button\"]";
    private String userNameTextNegative="Test";
    private String passwordNameTextNegative = "12345";
    private String errorMessage = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3";

    @BeforeEach
    public void intizializeDriver(){
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLogin(){
        loginPage.Test();
        loginPage.typeText(userNameXpath,userNameText);
        loginPage.typeText(passwordField, passwordFieldText);
        loginPage.clickOnElement(loginButton);
    }
    @Test
    public void testLoginNegative(){
        loginPage.Test();
        loginPage.typeText(userNameXpath,userNameTextNegative);
        loginPage.typeText(passwordField, passwordNameTextNegative);
        loginPage.clickOnElement(loginButton);
        assertTrue(loginPage.findElement(errorMessage),
                "Message Appeared");
    }

}
