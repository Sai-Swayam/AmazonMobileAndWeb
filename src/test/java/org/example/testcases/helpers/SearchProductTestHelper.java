package org.example.testcases.helpers;

import org.example.pages.PageProvider;
import org.example.pages.interfaces.HomePage;
import org.example.pages.web.HomePageWeb;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SearchProductTestHelper {
    public static String helperSearchForProduct(RemoteWebDriver driver, String product) {
        HomePage homePageWeb = PageProvider.getHomePage(driver);
        homePageWeb
                .searchForProduct(product)
                .addToCartFirstResult();

        return "temp test data";
    }
}
