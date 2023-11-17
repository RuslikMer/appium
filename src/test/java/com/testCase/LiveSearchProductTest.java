package com.testCase;

import com.setup.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;


@Epic("Regression Tests")
@Feature("")


public class LiveSearchProductTest extends BaseTest {


    @Test
    //@Severity(SeverityLevel.BLOCKER)
    @Description("product live search")
    @Story("")
    public void liveSearchProductTest() {
        home.openHomePage();
        search.search("Fe", false);
        search.goToLiveSearchResult("Product");
    }
}