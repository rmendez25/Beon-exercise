package ui.pages;

import ui.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * GoogleHomePage models the Google search page for UI automation.
 * Provides actions for search and result validation.
 */
public class GoogleHomePage extends BasePage {

    By searchField = By.id("APjFqb");
    By searchButton = By.xpath("//input[@name='btnK']");
    By searchResult = By.xpath("//h3[text() ='Selenium']");

    By header = By.xpath("//h1");

    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Sets the value in the Google search field.
     * @param value Search query
     */
    public void setSearchField(String value) {
        setInputField(searchField, value);
    }

    /**
     * Clicks the Google search button.
     */
    public void clickOnSearchButton() {
        clickOnElement(searchButton);
    }

    /**
     * Clicks on the Selenium search result.
     */
    public void clickOnSearchResult() {
        clickOnElement(searchResult);
    }

    /**
     * Returns the text of the header element on the result page.
     * @return Header text
     */
    public String isHeaderDisplayedWithValue() {
        return getElement(header).getText();
    }

    /**
     * Returns the current browser URL.
     * @return Current URL
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
