package com.myApp.pages;

import com.myApp.helpers.PageBase;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.NoSuchElementException;

import java.util.ArrayList;
import java.util.List;


public class BetListPage extends PageBase {

    @AndroidFindBy(id = "com.pordiva.nesine.android:id/filter_btn")
    private AndroidElement filterButton;

    @AndroidFindBy(id = "com.pordiva.nesine.android:id/main_layout")
    private List<AndroidElement> matchLayouts;

    @AndroidFindBy(id = "com.pordiva.nesine.android:id/ms1")
    private AndroidElement firstTeamWinBetButton;

    @AndroidFindBy(id = "com.pordiva.nesine.android:id/msX")
    private AndroidElement drawBetButton;

    @AndroidFindBy(id = "com.pordiva.nesine.android:id/ms2")
    private AndroidElement secondTeamWinBetButton;

    public List<String> idList = new ArrayList<>();

    public BetListPage() {
    }

    public void openFilter() {
        filterButton.click();
    }

    public int getTotalMatchCount() {

        boolean isAllFinished;
        isAllFinished = fillList();
        while (!isAllFinished) {
            if (matchLayouts.size() > 4)
                swipeByElements(matchLayouts.get(matchLayouts.size() - 1), matchLayouts.get(0));
            isAllFinished = fillList();
        }


        return idList.size();
    }

    public void addBetListWithIndex(int index) {
        for (int i = 0; i < index; ++i) {
            matchLayouts.get(i).findElementById("com.pordiva.nesine.android:id/ms1").click();
        }

    }

    private boolean fillList() {
        int counter = 0;
        for (AndroidElement matchLayout : matchLayouts) {
            String itemId;
            try {
                itemId = matchLayout.findElementById("com.pordiva.nesine.android:id/code").getText();
            } catch (NoSuchElementException elementException) {
                itemId = null;
            }
            if (itemId != null) {
                if (!idList.contains(itemId)) {
                    idList.add(itemId);
                } else {
                    ++counter;
                }
            }
        }
        return (counter > 1);
    }
}