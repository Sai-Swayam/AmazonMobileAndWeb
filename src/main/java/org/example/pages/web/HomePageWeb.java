package org.example.pages.web;

import org.example.pages.interfaces.HomePage;
import org.example.pages.interfaces.SearchResultsPage;
import org.example.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePageWeb extends BasePageWeb implements HomePage {
    public HomePageWeb(RemoteWebDriver driver) {
        super(driver);
    }

    // Locators
    @FindBy(id = "twotabsearchtextbox")
    private WebElement inputSearchBox;

    @FindBy(id = "nav-search-submit-button")
    private WebElement inputSearchButton;

    // Actions
    @Override
    public SearchResultsPage searchForProduct(String product ) {
        driver.navigate().to(ConfigReader.getProperty("WEBSITE_URL"));
        sendKeys(inputSearchBox, "inputSearchBox", product);
        click(inputSearchButton, "inputSearchButton");
        return new SearchResultsPageWeb(driver);
    }
}
