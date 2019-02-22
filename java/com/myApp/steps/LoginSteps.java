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

    @And("^Visitor logs in to Application with \"([^\"]*)\" usename and \"([^\"]*)\" password$")
    public void visitorLogsInToApplicationWithUsenameAndPassword(String username, String password) throws Throwable {
        homePageBase.goToLogin();
        loginPage.loginWithUsernameAndPassword(username, password);
    }
}
