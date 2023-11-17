package com.testCase;

import com.page.Menu;
import com.setup.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;


@Epic("Regression Tests")
@Feature("")


public class AddToWishlistFromListingAuthTest extends BaseTest {


    @Test
    //@Severity(SeverityLevel.BLOCKER)
    @Description("add and remove from wishlist at listing by authorized user")
    @Story("")
    public void addToWishlistFromListingAuthTest() {
        home.openHomePage();
        menu.goToMenuCategory(Menu.NEW_IN);
        listing.addToWishlist("auth");
        listing.removeFromWishList();
    }
}