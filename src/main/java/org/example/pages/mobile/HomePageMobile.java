package org.example.pages.mobile;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.example.pages.interfaces.HomePage;
import org.example.pages.interfaces.SearchResultsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HomePageMobile extends BasePageMobile implements HomePage {
    public HomePageMobile(RemoteWebDriver driver) {
        super(driver);
    }

    // Locators
    @AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/chrome_search_edit_frame")
    private WebElement buttonSearch;
    @AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/rs_search_src_text")
    private WebElement inputSearch;

    @AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/skip_sign_in_button")
    private WebElement buttonSkipSignIn;


    // Actions
    @Override
    public SearchResultsPage searchForProduct(String product) {
//        skipSignIn(); // use it when "appium:noReset" is set to false
        click(buttonSearch, "buttonSearch");
        sendKeys(inputSearch, "inputSearch", product);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));

//        try {
//            Thread.sleep(5000);
//        }
//        catch (InterruptedException e) {
//
//        }

        return new SearchResultsPageMobile(driver);
    }

    // Helpers
    private void skipSignIn() {
        click(buttonSkipSignIn, "buttonSkipSignIn");
    }
}
