package com.testCase;

import com.helper.GlobEnv;
import com.page.Menu;
import com.setup.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;


@Epic("Regression Tests")
@Feature("")


public class GetOrderByPayPalTest extends BaseTest {


    @Test
    //@Severity(SeverityLevel.BLOCKER)
    @Description("get order by PayPal")
    @Story("")
    public void getOrderByPayPalTest() {
        home.openHomePage();
        menu.goToMenuCategory(Menu.NEW_IN);
        listing.goToProduct();
        product.addToCart();
        cart.goToCheckout();
        login.guestLogin();
        checkout.fillContacts(GlobEnv.BUYER_COUNTRY, GlobEnv.BUYER_ADDRESS, GlobEnv.BUYER_CITY,  GlobEnv.BUYER_POSTCODE);
        Integer totalPrice = checkout.chooseShippingMethod();
        checkout.payByPayPal();
        checkout.viewOrder(totalPrice);
    }
}