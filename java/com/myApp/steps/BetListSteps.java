package com.myApp.steps;

import com.myApp.pages.BetListPage;
import com.myApp.pages.FootBallLeaguePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class BetListSteps {
    private BetListPage betListPage;
    private FootBallLeaguePage footBallLeaguePage;

    private int matchCount;

    public BetListSteps(BetListPage betListPage, FootBallLeaguePage footBallLeaguePage) {
        this.betListPage = betListPage;
        this.footBallLeaguePage = footBallLeaguePage;
    }

    @And("^User goes to Filter$")
    public void userGoesToFilter() throws Throwable {
        betListPage.openFilter();
    }

    @Then("^User should see matches the number of selected league$")
    public void userShouldSeeMatchesTheNumberOfSelectedLeague() throws Throwable {
        Assert.assertEquals("Wrong match count",matchCount,betListPage.getTotalMatchCount());
    }

    @When("^User adds first (\\d+) match to bet list$")
    public void userAddsFirstMatchToBetList(int matchCount) throws Throwable {
        betListPage.addBetListWithIndex(matchCount);
    }

    @And("^User selects (\\d+) th League$")
    public void userSelectsThLeague(int index) throws Throwable {
        matchCount = footBallLeaguePage.getMatchCountByIndex(index);
        footBallLeaguePage.chooseLeagueByIndex(index);
        footBallLeaguePage.applyFilter();
    }
}
