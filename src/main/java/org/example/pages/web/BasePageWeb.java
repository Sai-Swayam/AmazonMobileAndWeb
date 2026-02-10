package org.example.pages.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePageWeb {
    protected RemoteWebDriver driver;
    protected Logger logger = LogManager.getLogger(this.getClass());
    WebDriverWait wait;
    JavascriptExecutor javascriptExecutor;

    public BasePageWeb(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    protected void click(WebElement element, String elementName) {
        try {
            logger.debug("Clicking on element " + elementName);
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (StaleElementReferenceException exception) {
            logger.error("StaleElementReferenceException occurred, retrying clicking on " + elementName);
            System.out.println(exception.getMessage());
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (ElementClickInterceptedException exception) {
//            logger.error(exception.getMessage());
            logger.error("ElementClickInterceptedException occurred, retrying clicking on " + elementName);
            System.out.println(exception.getMessage());
            javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (Exception exception) {
//            logger.error(exception.getMessage());
            System.out.println(exception.getMessage());
            throw exception;
        }
    }

    protected void sendKeys(WebElement element, String elementName, String text) {
        try {
            WebElement e = wait.until(ExpectedConditions.visibilityOf(element));
            if (element.isEnabled()) {
                logger.debug("Typing content into " + elementName);
                e.sendKeys(text);
            }
        } catch (Exception exception) {
            logger.error(exception.getMessage());
            throw exception;
        }
    }
}
