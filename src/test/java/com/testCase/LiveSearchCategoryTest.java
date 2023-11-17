package com.testCase;

import com.setup.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;


@Epic("Regression Tests")
@Feature("")


public class LiveSearchCategoryTest extends BaseTest {


    @Test
    //@Severity(SeverityLevel.BLOCKER)
    @Description("categories live search")
    @Story("")
    public void liveSearchCategoryTest() {
        home.openHomePage();
        search.search("Fe", false);
        search.goToLiveSearchResult("Category");
    }
}