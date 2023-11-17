package com.testCase;

import com.page.Menu;
import com.setup.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;


@Epic("Regression Tests")
@Feature("")


public class SwipingImagesAtProductPageTest extends BaseTest {


    @Test
    //@Severity(SeverityLevel.BLOCKER)
    @Description("swiping images at product page")
    @Story("")
    public void swipingImagesAtProductPageTest() {
        home.openHomePage();
        menu.goToMenuCategory(Menu.NEW_IN);
        listing.goToProduct();
        listing.swipeImage(listing.PRODUCT_IMAGE);
    }
}