package ui.pages;

import ui.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleHomePage extends BasePage {

    By searchField = By.id("APjFqb");
    By searchButton = By.xpath("//input[@name='btnK']");
    By searchResult = By.xpath("//h3[text() ='Selenium']");

    By header = By.xpath("//h1");

    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }

    public void setSearchField(String value) {
        setInputField(searchField, value);
    }

    public void clickOnSearchButton() {
        clickOnElement(searchButton);
    }

    public void clickOnSearchResult() {
        clickOnElement(searchResult);
    }

    public String isHeaderDisplayedWithValue() {
        return getElement(header).getText();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
