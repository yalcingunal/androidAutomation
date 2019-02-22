package com.myApp.core.driver;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;

public class DriverFactory {

    public static AndroidDriver REAL_DRIVER = null;

    static {
        try {
            REAL_DRIVER = new MyAndroidDriver().getDriver();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
