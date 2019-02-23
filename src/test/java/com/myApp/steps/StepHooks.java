package com.myApp.steps;

import com.myApp.core.driver.DriverFactory;
import com.myApp.core.managers.ScreenshotManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;

public class StepHooks {

    private AndroidDriver androidDriver;

    public StepHooks() {
        this.androidDriver = DriverFactory.REAL_DRIVER;
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            ScreenshotManager.saveFailScenarioScreenshot(androidDriver, scenario);
        }
        androidDriver.resetApp();
    }
}
