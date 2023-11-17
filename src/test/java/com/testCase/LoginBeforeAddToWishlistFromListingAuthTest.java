package com.testCase;

import com.helper.GlobEnv;
import com.page.Menu;
import com.setup.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;


@Epic("Regression Tests")
@Feature("")


public class LoginBeforeAddToWishlistFromListingAuthTest extends BaseTest {


    @Test
    //@Severity(SeverityLevel.BLOCKER)
    @Description("login before add and remove from wishlist from listing by authorized user")
    @Story("")
    public void loginBeforeAddToWishlistFromListingAuthTest() {
        home.openHomePage();
        menu.login(GlobEnv.BUYER_EMAIL, GlobEnv.PASSWORD);
        menu.goToMenuCategory(Menu.NEW_IN);
        listing.addToWishlist(null);
        listing.removeFromWishList();
    }
}