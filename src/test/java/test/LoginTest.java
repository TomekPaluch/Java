package test;

import base.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoginTest {
    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);
    private WebDriver driver;
    private LoginPage loginPage;


    @BeforeEach
    public void intizializeDriver() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginWithValidCredentials() {
        loginPage.enterPage();
        loginPage.validLogin();
        loginPage.validpassword();
        loginPage.clickOnLoginButton();
        loginPage.quitDriver();
    }

    @Test
    public void loginWithInvalidCredentials() {
        loginPage.enterPage();
        loginPage.invalidLogin();
        loginPage.invalidPassword();
        loginPage.clickOnLoginButton();
        loginPage.verifyUserNameAndPasswordDoNotMatch();
        loginPage.quitDriver();
    }
    @Test
    public void userNameIsRequiredMessage(){
        loginPage.enterPage();
        loginPage.clickOnLoginButton();
        loginPage.verifyUserNameIsRequiredError();
        loginPage.quitDriver();
    }
    @Test
    public void passwordIsRequiredMessage(){
        loginPage.enterPage();
        loginPage.validLogin();
        loginPage.clickOnLoginButton();
        loginPage.verifyPasswordNameIsRequiredError();
        loginPage.quitDriver();
    }

}
