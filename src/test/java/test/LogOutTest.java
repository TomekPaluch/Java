package test;

import base.LoginPage;
import base.MainPage;
import commonUtilities.BrowserSetup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class LogOutTest extends BrowserSetup {
    private WebDriver driver;
    private LoginPage loginPage;
    private MainPage mainPage;


    @BeforeEach
    public void startDriver() {
        BrowserSetup browserSetup = new BrowserSetup();
        driver = browserSetup.startChromeGithub();
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
    }
    @Test
    public void logOut(){
        loginPage.enterPage();
        loginPage.validLogin();
        loginPage.validPassword();
        loginPage.clickOnLoginButton();
        mainPage.openDropDownMenu();
        mainPage.logOut();
    }
}
