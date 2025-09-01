package ui.tests;

import ui.base.BaseTest;
import org.testng.annotations.Test;
import ui.pages.GoogleHomePage;

import static org.testng.Assert.assertEquals;

public class DemoTest extends BaseTest {

    @Test
    void googleSearchTest() {
        GoogleHomePage googleHomePage = new GoogleHomePage(getDriver());

        googleHomePage.setSearchField("selenium");
        googleHomePage.clickOnSearchButton();
        googleHomePage.clickOnSearchResult();

        assertEquals(googleHomePage
                .isHeaderDisplayedWithValue(), "Selenium automates browsers. That's it!");

        assertEquals(googleHomePage
                .getCurrentUrl(), "https://www.selenium.dev/");
    }
}
