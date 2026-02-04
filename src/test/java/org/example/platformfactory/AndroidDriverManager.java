package org.example.platformfactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.example.utils.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDriverManager implements DriverManager {
    @Override
    public AppiumDriver createDriver() {
        AndroidDriver driver = null;
        try {
            UiAutomator2Options options = new UiAutomator2Options();

            options.setPlatformName("Android");
            options.setAutomationName("uiautomator2");
            options.setAppPackage("com.amazon.mShop.android.shopping");
            options.setAppActivity("com.amazon.mShop.android.shopping/com.amazon.mShop.home.HomeActivity");
            options.setAutoGrantPermissions(true);

            options.setCapability("allowTestPackages", true); // optional
            options.setCapability("chromedriverAutodownload", true);

            driver = new AndroidDriver(new URL(ConfigReader.getProperty("APPIUM_SERVER_URL")), options);
        } catch (MalformedURLException exception) {
            exception.printStackTrace();
        }
        return driver;

        //TODO CommonOptions class to be passed here , as well as AndroidOptions and IOSOptions
        // ENUMS
    }
}
