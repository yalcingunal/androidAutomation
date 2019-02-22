package com.myApp.pages;

import com.myApp.core.driver.DriverFactory;
import com.myApp.helpers.PageBase;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.net.MalformedURLException;

public class BetCheckoutListPage extends PageBase {

    @AndroidFindBy(id = "com.pordiva.nesine.android:id/btnPlay")
    private AndroidElement playButton;

    @AndroidFindBy(id = "android:id/message")
    private AndroidElement checkoutMessage;

    public BetCheckoutListPage() throws MalformedURLException {
        super(DriverFactory.REAL_DRIVER);
    }

    public void playBet() {
        playButton.click();
    }

    public String getCheckoutMessage() {
        return checkoutMessage.getText();
    }
}
