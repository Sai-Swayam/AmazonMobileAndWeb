package org.example.platformfactory;

import org.example.customexceptions.IllegalMobilePlatformException;
import org.example.utils.ConfigReader;

public interface DriverFactory {
   public static DriverManager getDriver() {
        return switch (getPlatform()) {
            case ANDROID -> new AndroidDriverManager();
            case IOS -> new IOSDriverManager();
            case WEB -> new WebDriverManager();
            default -> throw new IllegalMobilePlatformException("Illegal mobile platform");
       };
   }

   public static Platform getPlatform() {
       String platformName = System.getProperty("platform");
       // If not passed via commandline, take from config reader
       if (platformName == null || platformName.isBlank()) platformName = ConfigReader.getProperty("PLATFORM");

       return Platform.valueOf(platformName.toUpperCase());
   }
}
