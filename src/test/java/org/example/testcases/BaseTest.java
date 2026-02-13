package org.example.testcases;

import org.example.customexceptions.DriverNotFoundException;
import org.example.platformfactory.DriverFactory;
import org.example.platformfactory.Platform;
import org.example.utils.ConfigReader;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected RemoteWebDriver driver;

    // TODO make listeners, use ITestListener, IRetryAnalyzer etc
    // TODO OnTestFailure -> Screen record
    @BeforeClass
    public void setup() {
        // From commandline arguments
//        String platform = System.getProperty("platform");
//        // If not passed via commandline, take from config reader
//        if (platform == null || platform.isBlank()) platform = ConfigReader.getProperty("PLATFORM");
        driver = DriverFactory.getDriver().createDriver();

        if (driver == null) throw new DriverNotFoundException("No driver found");
    }

    @AfterClass
    public void cleanup() {
        if (driver != null) driver.quit();
    }

    // TODO enable screen recording for both appium and selenium, not just appium
/*

    @BeforeMethod
    public void startRecording() {
        ((CanRecordScreen) driver).startRecordingScreen();
    }

    // TODO extract to video recording util
    @AfterMethod
    public void stopRecording(ITestResult result) throws IOException {
        String base64Video = ((CanRecordScreen) driver).stopRecordingScreen();
        byte[] videoBytes = Base64.getDecoder().decode(base64Video);

        File videoDir = new File("target/videos");
        if (!videoDir.exists()) {
            videoDir.mkdirs();
        }

        File videoFile = new File(videoDir, result.getMethod().getMethodName() + ".mp4");
        Files.write(videoFile.toPath(), videoBytes);
    }

 */
}
