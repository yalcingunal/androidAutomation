package com.myApp.steps;

import com.myApp.pages.BetCheckoutListPage;
import com.myApp.pages.HomePageBase;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class BetCheckoutSteps {

    private BetCheckoutListPage betCheckOutListPage;
    private HomePageBase homePageBase;

    public BetCheckoutSteps(BetCheckoutListPage betCheckOutListPage, HomePageBase homePageBase) {
        this.betCheckOutListPage = betCheckOutListPage;
        this.homePageBase = homePageBase;
    }

    @And("^User goes to bet checkout list$")
    public void userGoesToBetCheckoutList() throws Throwable {
        homePageBase.goToBetCheckoutList();
        betCheckOutListPage.playBet();
    }

    @Then("^User should see \"([^\"]*)\" warning message$")
    public void userShouldSeeWarningMessage(String warningMessage) throws Throwable {
        Assert.assertEquals("There is no warning message", warningMessage, betCheckOutListPage.getCheckoutMessage());
    }
}
