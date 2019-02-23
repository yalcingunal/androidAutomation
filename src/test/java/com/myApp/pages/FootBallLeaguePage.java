package com.myApp.pages;

import com.myApp.helpers.PageBase;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FootBallLeaguePage extends PageBase {

    @AndroidFindBy(id = "com.pordiva.nesine.android:id/filter_Txt")
    private List<AndroidElement> leagueOptions;

    @AndroidFindBy(id = "com.pordiva.nesine.android:id/top_button")
    private AndroidElement filterOkButton;

    public FootBallLeaguePage() {
    }

    public void chooseLeagueByIndex(int value) {
        leagueOptions.get(value - 1).click();
    }

    public int getMatchCountByIndex(int value) {
        Pattern patt = Pattern.compile("\\(\\d+\\)");
        Matcher match = patt.matcher(leagueOptions.get(value - 1).getText());
        while (match.find()) {
            return Integer.parseInt(match.group().replaceAll("\\(", "").replaceAll("\\)", ""));
        }
        return 0;
    }

    public void applyFilter() {
        filterOkButton.click();
    }
}
