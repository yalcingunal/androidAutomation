package com.myApp.pages;

import com.myApp.core.driver.DriverFactory;
import com.myApp.helpers.PageBase;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.net.MalformedURLException;

public class LoginPage  extends PageBase {

    @AndroidFindBy(id = "com.pordiva.nesine.android:id/username_edit")
    private AndroidElement usernameTextBox;

    @AndroidFindBy(id = "com.pordiva.nesine.android:id/password_edit")
    private AndroidElement passwordTextBox;

    @AndroidFindBy(id = "com.pordiva.nesine.android:id/login_btn")
    private AndroidElement loginButton;

    public LoginPage() throws MalformedURLException {
        super(DriverFactory.REAL_DRIVER);
    }

    public void loginWithUsernameAndPassword(String username, String password) {
        usernameTextBox.sendKeys(username);
        passwordTextBox.sendKeys(password);
        loginButton.click();
    }
}
