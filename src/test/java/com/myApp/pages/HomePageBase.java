package com.myApp.pages;

import com.myApp.helpers.PageBase;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.NoSuchElementException;

public class HomePageBase extends PageBase {

    @AndroidFindBy(id = "com.pordiva.nesine.android:id/close_btn")
    private AndroidElement advertisementCloseButton;

    @AndroidFindBy(id = "com.pordiva.nesine.android:id/layout_football")
    private AndroidElement footballLayout;

    @AndroidFindBy(id = "com.pordiva.nesine.android:id/btn_football")
    private AndroidElement footballButton;

    @AndroidFindBy(id = "com.pordiva.nesine.android:id/btn_login")
    private AndroidElement loginButton;

    @AndroidFindBy(id = "com.pordiva.nesine.android:id/background_view")
    private AndroidElement betCheckoutListButton;

    public HomePageBase() {
    }

    public void closeAdvertisement() {
        try {
            advertisementCloseButton.click();
        } catch (NoSuchElementException elementException) {
            System.out.println("There is no advertisement pop up");
        }

    }

    public void goToFootballBetList() {
        footballLayout.click();
    }

    public void goToBetCheckoutList() {
        betCheckoutListButton.click();
    }

    public void goToLogin() {
        loginButton.click();
    }

}
