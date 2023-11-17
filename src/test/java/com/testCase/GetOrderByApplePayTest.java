package com.testCase;

import com.helper.GlobEnv;
import com.page.Menu;
import com.setup.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;


@Epic("Regression Tests")
@Feature("")


public class GetOrderByApplePayTest extends BaseTest {


    @Test(enabled = false)
    //@Severity(SeverityLevel.BLOCKER)
    @Description("get order by Apple pay")
    @Story("")
    public void getOrderByApplePayTest() {
        home.openHomePage();
        menu.goToMenuCategory(Menu.NEW_IN);
        listing.goToProduct();
        product.addToCart();
        cart.goToCheckout();
        login.guestLogin();
        checkout.fillContacts(GlobEnv.BUYER_COUNTRY, GlobEnv.BUYER_ADDRESS, GlobEnv.BUYER_CITY,  GlobEnv.BUYER_POSTCODE);
        Integer totalPrice = checkout.chooseShippingMethod();
        checkout.payByApplePay();
        checkout.viewOrder(totalPrice);
    }
}