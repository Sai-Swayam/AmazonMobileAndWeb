package org.example.pages.mobile;

import io.appium.java_client.AppiumBy;
import org.example.pages.interfaces.SearchResultsPage;
import org.example.utils.ContextChanger;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SearchResultsPageMobile extends BasePageMobile implements SearchResultsPage {
    public SearchResultsPageMobile(RemoteWebDriver driver) {
        super(driver);
    }

    // Locators
//    @AndroidFindBy(xpath = "//android.view.View[contains(@text, 'Philips')][1]")
//    private WebElement optionFirstPhilips;

//    @FindBy(xpath = "new UiSelector().description('Philips Air Fryer 2000 Series - 13-in-1 functions, 6.6 Quarts, Compact Design with Cooking Window, Black, (NA231/00)')")
    private final By optionFirstPhilips = AppiumBy.androidUIAutomator("new UiSelector().description(\"Philips Air Fryer 2000 Series - 13-in-1 functions, 6.6 Quarts, Compact Design with Cooking Window, Black, (NA231/00)\")");
//    private WebElement optionFirstPhilips;


    // Actions
    @Override
    public void addToCartFirstResult() {
        changeContextToWeb();
        // TODO temp
        scrollDownTillElementVisible(optionFirstPhilips, 4);
        click(optionFirstPhilips, "optionFirstPhilips");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
    }

    public void changeContextToWeb() {
        ContextChanger.changeContext(driver, "web");
    }
}
