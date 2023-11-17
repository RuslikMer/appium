package com.testCase;

import com.page.Menu;
import com.setup.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;


@Epic("Regression Tests")
@Feature("")


public class AddToWishlistFromListingTest extends BaseTest {


    @Test
    //@Severity(SeverityLevel.BLOCKER)
    @Description("add and remove from wishlist at listing by guest")
    @Story("")
    public void addToWishlistFromListingTest() {
        home.openHomePage();
        menu.goToMenuCategory(Menu.NEW_IN);
        listing.addToWishlist("guest");
        listing.removeFromWishList();
    }
}