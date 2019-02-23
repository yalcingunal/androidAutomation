package com.myApp.steps;

import com.myApp.pages.HomePageBase;
import com.myApp.pages.LoginPage;
import cucumber.api.java.en.And;


public class LoginSteps {

    private LoginPage loginPage;
    private HomePageBase homePageBase;

    public LoginSteps(LoginPage loginPage, HomePageBase homePageBase) {
        this.loginPage = loginPage;
        this.homePageBase = homePageBase;
    }

    @And("^Visitor logs in to Application with \"([^\"]*)\" username and \"([^\"]*)\" password$")
    public void visitorLogsInToApplicationWithUsernameAndPassword(String username, String password) {
        homePageBase.goToLogin();
        loginPage.loginWithUsernameAndPassword(username, password);
    }
}
