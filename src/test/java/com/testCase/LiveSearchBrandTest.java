package com.testCase;

import com.setup.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;


@Epic("Regression Tests")
@Feature("")


public class LiveSearchBrandTest extends BaseTest {


    @Test
    //@Severity(SeverityLevel.BLOCKER)
    @Description("brands live search")
    @Story("")
    public void liveSearchBrandTest() {
        home.openHomePage();
        search.search("Fe", false);
        search.goToLiveSearchResult("Brand");
    }
}