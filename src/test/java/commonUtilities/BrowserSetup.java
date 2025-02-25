package commonUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserSetup {
    public WebDriver driver;

    public WebDriver startChrome(){
        driver = new ChromeDriver(new ChromeOptions().addArguments("--start-maximized"));
        return driver;
    }
    public WebDriver startEdge(){
        driver = new EdgeDriver(new EdgeOptions().addArguments("--start-maximized"));
        return driver;
    }
    public WebDriver startFirefox(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
