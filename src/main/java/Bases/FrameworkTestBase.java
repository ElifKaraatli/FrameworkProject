package Bases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class FrameworkTestBase {

    protected WebDriver driver;
    protected static final Logger log  = Logger.getLogger(FrameworkTestBase.class.getName());

    @BeforeSuite
    public void settings() {
        PropertyConfigurator.configure("src/test/java/Resources/log4j.properties");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\TCEKARAATLI\\chromedriver.exe");
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.turkcell.com.tr/");
        driver.manage().deleteAllCookies();

    }

    @AfterMethod
    public void quitDriver() {
        driver.quit();
    }


}
