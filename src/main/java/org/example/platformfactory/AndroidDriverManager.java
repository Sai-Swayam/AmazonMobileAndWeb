package org.example.platformfactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.example.utils.ConfigReader;
import org.example.utils.MobileOptionsBuilder;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDriverManager implements DriverManager {
    // TODO apply thread local
    @Override
    public AppiumDriver createDriver() {
        AndroidDriver driver = null;
        try {
            driver = new AndroidDriver(new URL(
                    ConfigReader.getProperty("APPIUM_SERVER_URL")),
                    MobileOptionsBuilder.getAndroidOptions()
            );
        } catch (MalformedURLException exception) {
            exception.printStackTrace();
        }
        return driver;

        //TODO CommonOptions class to be passed here , as well as AndroidOptions and IOSOptions
        // above is disputed, because to adhere SRP, a separate MobileOptionsBuilder was created.
        //
    }
}
