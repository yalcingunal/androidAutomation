package com.myApp.core.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MyAndroidDriver {

    public MyAndroidDriver() {
    }

    public AndroidDriver getDriver() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.APP, "/Users/yalcingunal/Downloads/nesine.com.apk");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi Note 4");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        return new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

}
