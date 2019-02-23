package com.myApp.steps;

import com.myApp.pages.HomePageBase;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class HomePageSteps {
    private HomePageBase homePageBase;

    public HomePageSteps(HomePageBase homePageBase) {
        this.homePageBase = homePageBase;
    }

    @Given("^Visitor is on the Application Home$")
    public void visitorIsOnTheApplicationHome() throws Throwable {
        homePageBase.closeAdvertisement();
    }

    @And("^User goes to Football Bet list$")
    public void userGoesToFootballBetList() throws Throwable {
        homePageBase.goToFootballBetList();
    }

}
