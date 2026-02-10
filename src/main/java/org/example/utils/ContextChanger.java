package org.example.utils;

import io.appium.java_client.remote.SupportsContextSwitching;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Set;

public class ContextChanger {

    // TODO extract it to a separate util class
    public static void changeContext(RemoteWebDriver driver, String option) {
        SupportsContextSwitching tempDriver = (SupportsContextSwitching) driver;
        Set<String> contexts = tempDriver.getContextHandles();
        for (String context : contexts) {
            if (option.equalsIgnoreCase("web") && context.contains("WEBVIEW")) {
                System.out.println(context);
                tempDriver.context(context);
                break;
            }
            if (option.equalsIgnoreCase("native")) {
                tempDriver.context("NATIVE_APP");
                break;
            }
        }
    }
}
