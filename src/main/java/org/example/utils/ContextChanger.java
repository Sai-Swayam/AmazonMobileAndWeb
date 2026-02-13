package org.example.utils;

import io.appium.java_client.remote.SupportsContextSwitching;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Set;

/**
 * Util class to change context from WEBVIEW to NATIVE_APP or vice versa
 */

public class ContextChanger {

    /**
     * Method to change the context
     *
     * @param driver : RemoteWebDriver instance where the context has to be changed
     * @param option : Context option that the context has to be switched to
     */

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
