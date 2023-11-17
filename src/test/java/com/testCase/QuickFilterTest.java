package com.testCase;

import com.page.Menu;
import com.setup.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;


@Epic("Regression Tests")
@Feature("")


public class QuickFilterTest extends BaseTest {


    @Test
    //@Severity(SeverityLevel.BLOCKER)
    @Description("use quick filter catalog")
    @Story("")
    public void quickFilterTest() {
        home.openHomePage();
        menu.goToMenuCategory(Menu.NEW_IN);
        listing.quickFilter();
    }
}