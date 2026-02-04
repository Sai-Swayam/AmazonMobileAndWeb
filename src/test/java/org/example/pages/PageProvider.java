package org.example.pages;

import org.example.customexceptions.IllegalMobilePlatformException;
import org.example.pages.interfaces.HomePage;
import org.example.pages.interfaces.SearchResultsPage;
import org.example.pages.mobile.HomePageMobile;
import org.example.pages.mobile.SearchResultsPageMobile;
import org.example.pages.web.HomePageWeb;
import org.example.pages.web.SearchResultsPageWeb;
import org.example.platformfactory.Platform;
import org.example.utils.ConfigReader;
import org.openqa.selenium.remote.RemoteWebDriver;

import static org.example.platformfactory.Platform.WEB;

public class PageProvider {
    static Platform platform = Platform.valueOf(ConfigReader.getProperty("PLATFORM").toUpperCase());

    public static HomePage getHomePage(RemoteWebDriver driver) {
        if (platform.equals(WEB)) return new HomePageWeb(driver);
        return new HomePageMobile(driver);
    }

    public static SearchResultsPage getSearchResultsPage(RemoteWebDriver driver) {
        if (platform.equals(WEB)) return new SearchResultsPageWeb(driver);
        return new SearchResultsPageMobile(driver);
    }
}
