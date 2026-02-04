package org.example.utils;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PermissionUtils {
    private static WebDriverWait wait;

    public static void denyPermission(RemoteWebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement buttonDeny = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.id("com.android.packageinstaller:id/permission_deny_button")
                )
        );

        buttonDeny.click();
    }
}
