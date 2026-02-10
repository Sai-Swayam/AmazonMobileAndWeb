package org.example.pages.web;

import org.example.pages.interfaces.SearchResultsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPageWeb extends BasePageWeb implements SearchResultsPage {
    public SearchResultsPageWeb(RemoteWebDriver driver) {
        super(driver);
    }

    // Locators
    @FindBy(xpath = "//div[@data-cy='title-recipe']//span[.='Philips']/ancestor::div[@class='a-section']//button")
    private List<WebElement> buttonsAddToCart;

    // Actions
    @Override
    public void addToCartFirstResult() {
        buttonsAddToCart.stream()
                .filter(webElement -> webElement.isDisplayed())
                .findFirst()
                .ifPresent(WebElement::click);
    }
}
