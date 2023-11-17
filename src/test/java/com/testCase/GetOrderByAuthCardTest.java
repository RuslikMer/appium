package com.testCase;

import com.helper.GlobEnv;
import com.page.Menu;
import com.setup.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;


@Epic("Regression Tests")
@Feature("")


public class GetOrderByAuthCardTest extends BaseTest {


    @Test
    //@Severity(SeverityLevel.BLOCKER)
    @Description("get order by authorized card")
    @Story("")
    public void getOrderByAuthCardTest() {
        home.openHomePage();
        menu.goToMenuCategory(Menu.NEW_IN);
        listing.goToProduct();
        product.addToCart();
        cart.goToCheckout();
        login.guestLogin();
        checkout.fillContacts(GlobEnv.BUYER_COUNTRY, GlobEnv.BUYER_ADDRESS, GlobEnv.BUYER_CITY,  GlobEnv.BUYER_POSTCODE);
        Integer totalPrice = checkout.chooseShippingMethod();
        checkout.fillCardData(GlobEnv.BUYER_STRIPES_AUTH);
        checkout.complete3DSecure(true);
        checkout.viewOrder(totalPrice);
    }
}