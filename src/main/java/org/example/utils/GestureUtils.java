package org.example.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;
import java.util.List;

public class GestureUtils {
    public static boolean scrollDownTillElementVisible(RemoteWebDriver driver, By element, int maxScrolls) {
        for (int i = 0; i < maxScrolls; i++) {
            if (!driver.findElements(element).isEmpty()) {
                return true;
            }

            swipeUp(driver, 0.8f, 0.5f);
        }
        return false;
    }

    public static void swipeUp(RemoteWebDriver driver, float yStartPercent, float yEndPercent) {
        Dimension size = driver.manage().window().getSize();

        int startX = size.width / 2;
        int startY = (int) (size.height * yStartPercent);
        int endY = (int) (size.height * yEndPercent);

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
}
