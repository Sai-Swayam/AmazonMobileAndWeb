package org.example.utils;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.appmanagement.BaseOptions;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.example.platformfactory.DriverFactory;
import org.example.platformfactory.Platform;
import org.openqa.selenium.MutableCapabilities;

import java.util.Map;

public class MobileOptionsBuilder {

    // COMMON
    private static MutableCapabilities getCommonOptions() {
        MutableCapabilities commonOptions = new MutableCapabilities();
        commonOptions.setCapability("appium:noReset", ConfigReader.getProperty("mobile.no.reset"));

        return commonOptions;
    }

    // ANDROID
    public static UiAutomator2Options getAndroidOptions() {
        UiAutomator2Options options = new UiAutomator2Options()
                .merge(getCommonOptions())
//                .setDeviceName(ConfigReader.getProperty("mobile.device.name"))
                .setPlatformName("Android")
                .setPlatformVersion(ConfigReader.getProperty("mobile.platform.version"))
                .setAutomationName("UiAutomator2")
                .setAppPackage(ConfigReader.getProperty("android.app.package"))
                .setAppActivity(ConfigReader.getProperty("android.app.activity"));

        options.setAutoGrantPermissions(true);
        options.setCapability("allowTestPackages", true);
        options.setCapability("chromedriverAutodownload", true);

        return options;
    }

    // IOS
    public static XCUITestOptions getIosOptions() {
        return new XCUITestOptions()
                .merge(getCommonOptions())
                .setAutomationName("XCUITest")
                .setDeviceName(ConfigReader.getProperty("ios.device.name"))
                .setPlatformVersion(ConfigReader.getProperty("ios.platform.version"))
                .setBundleId("ios.bundle.id")
                .setUdid("ios.udid");
    }
}
