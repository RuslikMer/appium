package com.testCase;

import com.setup.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;


@Epic("Regression Tests")
@Feature("")


public class LiveSearchViewAllProductsTest extends BaseTest {


    @Test
    //@Severity(SeverityLevel.BLOCKER)
    @Description("go to all products live search")
    @Story("")
    public void liveSearchViewAllProductsTest() {
        home.openHomePage();
        search.search("Fe", false);
        search.goToAllProductsFromLiveSearchResult("Fe");
    }
}