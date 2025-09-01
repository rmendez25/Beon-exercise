package ui.base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public WebDriver driver;
    private WebDriverWait wait;
    private static final int TIMEPOUT = 15;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEPOUT));
    }

    public void waitForElementToBeDisplayed(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement getElement(By locator) {
        waitForElementToBeDisplayed(locator);

        try {
           return driver.findElement(locator);
        }catch (NoSuchElementException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void setInputField(By locator, String value) {
        getElement(locator).clear();
        getElement(locator).sendKeys(value);
    }

    public void clickOnElement(By locator) {
        getElement(locator).click();
    }
}
