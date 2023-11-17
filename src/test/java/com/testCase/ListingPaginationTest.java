package com.testCase;

import com.page.Menu;
import com.setup.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;


@Epic("Regression Tests")
@Feature("")


public class ListingPaginationTest extends BaseTest {


    @Test
    //@Severity(SeverityLevel.BLOCKER)
    @Description("filter catalog")
    @Story("")
    public void listingPaginationTest() {
        home.openHomePage();
        menu.goToMenuCategory(Menu.NEW_IN);
        listing.checkPagination();
    }
}