package org.example.platformfactory;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class WebDriverManager implements DriverManager {
    @Override
    public RemoteWebDriver createDriver() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.setPageLoadTimeout(Duration.ofSeconds(20));
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches",
                new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);options.addArguments("--inprivate");

        RemoteWebDriver driver = new EdgeDriver(options);
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ZERO);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        return driver;
    }
}
