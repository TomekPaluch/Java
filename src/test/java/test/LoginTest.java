package test;

import base.LoginPage;
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


    @BeforeEach
    public void intizializeDriver(){
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginWithValidCredentials(){
        loginPage.enterPage();
        loginPage.validLogin();
        loginPage.validpassword();
        loginPage.clickOnLoginButton();
        loginPage.quitDriver();
    }
    @Test
    public void loginWithInvalidCredentials(){
        loginPage.enterPage();
        loginPage.invalidLogin();
        loginPage.invalidPassword();
        loginPage.clickOnLoginButton();
        loginPage.verifyErrorMessage();
        loginPage.quitDriver();
    }

}
