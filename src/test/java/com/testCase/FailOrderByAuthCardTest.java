package com.testCase;

import com.helper.GlobEnv;
import com.page.*;
import com.setup.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;


@Epic("Regression Tests")
@Feature("")


public class FailOrderByAuthCardTest extends BaseTest {


    @Test
    //@Severity(SeverityLevel.BLOCKER)
    @Description("fail order by authorized card")
    @Story("")
    public void failOrderByAuthCardTest() {
        home.openHomePage();
        menu.goToMenuCategory(Menu.NEW_IN);
        listing.goToProduct();
        product.addToCart();
        cart.goToCheckout();
        login.guestLogin();
        checkout.fillContacts(GlobEnv.BUYER_COUNTRY, GlobEnv.BUYER_ADDRESS, GlobEnv.BUYER_CITY,  GlobEnv.BUYER_POSTCODE);
        checkout.chooseShippingMethod();
        checkout.fillCardData(GlobEnv.BUYER_STRIPES_AUTH);
        checkout.complete3DSecure(false);
        checkout.waitAlert("We are unable to authenticate your payment method. Please choose a different payment method and try again.", true);
    }
}