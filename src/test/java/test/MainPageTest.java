package test;

import base.LoginPage;
import base.MainPage;
import commonUtilities.BrowserSetup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class MainPageTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private MainPage mainPage;

    @BeforeEach
    public void intizializeDriver() {
        BrowserSetup browserSetup = new BrowserSetup();
        driver = browserSetup.startChrome();
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
    }
    @Test
    public void verifyUserLoggedIn(){
        loginPage.enterPage();
        loginPage.validLogin();
        loginPage.validPassword();
        loginPage.clickOnLoginButton();
        assertEquals(mainPage.readTitle(), "Products");
    }
    @Test
    public void selectMostExpensiveItem(){
        loginPage.enterPage();
        loginPage.validLogin();
        loginPage.validPassword();
        loginPage.clickOnLoginButton();
        mainPage.clickOnMostExpensiveItem();
    }
    @Test
    public void selectLeastExpensiveItem(){
        loginPage.enterPage();
        loginPage.validLogin();
        loginPage.validPassword();
        loginPage.clickOnLoginButton();
        mainPage.clickOnLeastExpensiveItem();
    }


}

