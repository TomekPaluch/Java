package test;

import org.base.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {
    private WebDriver driver;
    private LoginPage loginPage;
    private String userNameXpath = "//*[@id=\"user-name\"]";
    private String userNameText = "Test";
    @BeforeEach
    public void intizializeDriver(){
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLogin(){
        loginPage.Test();
        loginPage.typeText(userNameXpath,userNameText);
    }
}
