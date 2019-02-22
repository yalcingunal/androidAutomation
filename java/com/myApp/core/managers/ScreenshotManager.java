package com.myApp.core.managers;

import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotManager {

    private static String FAIL_SCENARIO_PATH = "target/screenshots/failure/%s.png";

    public static void saveScreenshot(WebDriver driver, String path) throws IOException {
        if (path == null) {
            throw new IllegalArgumentException("Screenshot file name must not be null.");
        }

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File(path));
    }

    public static void saveFailScenarioScreenshot(WebDriver driver, Scenario scenario) throws IOException {
        String path = String.format(FAIL_SCENARIO_PATH, scenario.getName());
        saveScreenshot(driver, path);
    }
}
