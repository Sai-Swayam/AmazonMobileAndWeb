package org.example.platformfactory;

import org.openqa.selenium.remote.RemoteWebDriver;

public interface DriverManager {
    RemoteWebDriver createDriver();
}
