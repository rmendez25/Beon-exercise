package ui.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * BaseTest sets up and tears down the Selenium WebDriver for UI tests.
 * It provides a Chrome browser instance and manages its lifecycle.
 */
public class BaseTest {

    WebDriver driver;

    /**
     * Initializes the Chrome WebDriver before any test class runs.
     */
    @BeforeClass
    public void init() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-blink-features=AutomationControlled");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://www.google.com/");
    }

    /**
     * Quits the WebDriver after all tests in the class have run.
     */
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * Returns the current WebDriver instance.
     * @return WebDriver
     */
    public WebDriver getDriver() {
        return driver;
    }
}
