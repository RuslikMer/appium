package com.testCase;

import com.page.Menu;
import com.setup.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;


@Epic("Regression Tests")
@Feature("")


public class AddToWishlistFromProductPageTest extends BaseTest {


    @Test
    //@Severity(SeverityLevel.BLOCKER)
    @Description("add and remove from wishlist at product page by guest")
    @Story("")
    public void addToWishlistFromProductPageTest() {
        home.openHomePage();
        menu.goToMenuCategory(Menu.NEW_IN);
        listing.goToProduct();
        listing.addToWishlist("guest");
        listing.removeFromWishList();
    }
}