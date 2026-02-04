package org.example.pages.mobile;

import org.example.pages.interfaces.SearchResultsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SearchResultsPageMobile extends BasePageMobile implements SearchResultsPage {
    public SearchResultsPageMobile(RemoteWebDriver driver) {
        super(driver);
    }

    // Locators


    // Actions
    @Override
    public void addToCartFirstResult() {
    }
}
