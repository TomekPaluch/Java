package test;

import base.LoginPage;
import base.CheckOutPage;
import commonUtilities.BrowserSetup;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class CheckOutPageTest extends BrowserSetup{
    private WebDriver driver;
    private LoginPage loginPage;
    private CheckOutPage checkOutPage;
    @BeforeEach
    public void intizializeDriver() {
        driver = startBrowser("chrome");
        loginPage = new LoginPage(driver);
    }


}
