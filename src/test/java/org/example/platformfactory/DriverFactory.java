package org.example.platformfactory;

import org.example.customexceptions.IllegalMobilePlatformException;

public interface DriverFactory {
   public static DriverManager getDriver(Platform platform) {
        return switch (platform) {
            case ANDROID -> new AndroidDriverManager();
            case IOS -> new IOSDriverManager();
            case WEB -> new WebDriverManager();
            default -> throw new IllegalMobilePlatformException("Illegal mobile platform");
       };
   }
}
