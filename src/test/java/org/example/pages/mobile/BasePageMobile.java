package org.example.pages.mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.SupportsContextSwitching;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePageMobile {
    protected final RemoteWebDriver driver;
    protected final WebDriverWait wait;
    protected Logger logger = LogManager.getLogger(this.getClass());

    public BasePageMobile(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void click(WebElement element, String elementName) {
        try{
            logger.debug("Clicking on element " + elementName);
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (StaleElementReferenceException exception) {
            logger.error("StaleElementReferenceException occurred, retrying clicking on " + elementName);
            System.out.println(exception.getMessage());
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        }
    }

    public void sendKeys(WebElement element, String elementName, String text) {
        try {
            logger.debug("Typing content into " + elementName);
            wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
        } catch (StaleElementReferenceException exception) {
            logger.error("StaleElementReferenceException occurred, retrying typing on " + elementName);
            System.out.println(exception.getMessage());
            wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);
        }
    }

    public String getText(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    public void waitForElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public boolean scrollDownTillElementVisible(By element, int maxScrolls) {
        for (int i = 0; i < maxScrolls; i++) {
            if (!driver.findElements(element).isEmpty()) {
                return true;
            }

            swipeUp();
        }
        return false;
    }

    public void swipeUp() {
        Dimension size = driver.manage().window().getSize();

        int startX = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        PointerInput finger = new PointerInput(
                PointerInput.Kind.TOUCH, "finger");

        Sequence swipeUp = new Sequence(finger, 1);

        swipeUp.addAction(finger.createPointerMove(
                Duration.ZERO,
                PointerInput.Origin.viewport(),
                startX, startY));

        swipeUp.addAction(finger.createPointerDown(
                PointerInput.MouseButton.LEFT.asArg()));

        swipeUp.addAction(finger.createPointerMove(
                Duration.ofMillis(600),
                PointerInput.Origin.viewport(),
                startX, endY));

        swipeUp.addAction(finger.createPointerUp(
                PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(List.of(swipeUp));
    }
    // TODO extract it to a separate util class
    public void changeContext(String option) {
        SupportsContextSwitching tempDriver = (SupportsContextSwitching) driver;
        Set<String> contexts = tempDriver.getContextHandles();
        for (String context : contexts) {
            if (option.equalsIgnoreCase("web") && context.contains("WEBVIEW")) {
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
