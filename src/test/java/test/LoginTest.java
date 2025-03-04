package test;

import base.LoginPage;
import commonUtilities.BrowserSetup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginTest extends BrowserSetup {
    private WebDriver driver;
    private LoginPage loginPage;


    @BeforeEach
    public void intizializeDriver() {
        BrowserSetup browserSetup = new BrowserSetup();
        driver = browserSetup.startChromeGithub();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginWithValidCredentials() {
        loginPage.enterPage();
        loginPage.validLogin();
        loginPage.validPassword();
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
    @Test
    public void logOut(){
        loginPage.enterPage();
        loginPage.validLogin();
        loginPage.validPassword();
    }
}
