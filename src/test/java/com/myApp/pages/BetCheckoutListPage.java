package com.myApp.pages;

import com.myApp.helpers.PageBase;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BetCheckoutListPage extends PageBase {

    @AndroidFindBy(id = "com.pordiva.nesine.android:id/btnPlay")
    private AndroidElement playButton;

    @AndroidFindBy(id = "android:id/message")
    private AndroidElement checkoutMessage;

    public BetCheckoutListPage() {
    }

    public void playBet() {
        playButton.click();
    }

    public String getCheckoutMessage() {
        return checkoutMessage.getText();
    }
}
