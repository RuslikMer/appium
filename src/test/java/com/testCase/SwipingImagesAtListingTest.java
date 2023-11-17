package com.testCase;

import com.page.Menu;
import com.setup.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;


@Epic("Regression Tests")
@Feature("")


public class SwipingImagesAtListingTest extends BaseTest {


    @Test(enabled = false)
    //@Severity(SeverityLevel.BLOCKER)
    @Description("swiping images in listing")
    @Story("")
    public void swipingImagesAtListingTest() {
        home.openHomePage();
        menu.goToMenuCategory(Menu.NEW_IN);
        listing.swipeImage("("+listing.PRODUCT_CARD+")[1]");
    }
}