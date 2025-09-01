package ui.base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * BasePage provides common Selenium WebDriver actions for page objects.
 * It includes element waiting, input, and click utilities.
 */
public class BasePage {

    public WebDriver driver;
    private WebDriverWait wait;
    private static final int TIMEPOUT = 15;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEPOUT));
    }

    /**
     * Waits for the element located by the given locator to be visible.
     * @param locator Selenium By locator
     */
    public void waitForElementToBeDisplayed(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Returns the WebElement for the given locator after waiting for visibility.
     * @param locator Selenium By locator
     * @return WebElement or null if not found
     */
    public WebElement getElement(By locator) {
        waitForElementToBeDisplayed(locator);

        try {
           return driver.findElement(locator);
        }catch (NoSuchElementException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Clears and sets the value of an input field.
     * @param locator Selenium By locator
     * @param value Value to set
     */
    public void setInputField(By locator, String value) {
        getElement(locator).clear();
        getElement(locator).sendKeys(value);
    }

    /**
     * Clicks on the element located by the given locator.
     * @param locator Selenium By locator
     */
    public void clickOnElement(By locator) {
        getElement(locator).click();
    }
}
