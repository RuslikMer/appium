package com.testCase;

import com.helper.*;
import com.page.Menu;
import com.setup.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;


@Epic("Regression Tests")
@Feature("")


public class GetOrderWithFixedAmountVoucherTest extends BaseTest {


    @Test
    //@Severity(SeverityLevel.BLOCKER)
    @Description("get order with fixed amount voucher")
    @Story("")
    public void getOrderWithFixedAmountVoucherTest() throws Exception {
        home.openHomePage();
        menu.goToMenuCategory(Menu.NEW_IN);
        listing.goToProduct();
        product.addToCart();
        cart.useVoucher(QaApi.generateFixedAmountVoucher("25"));
        cart.goToCheckout();
        login.guestLogin();
        checkout.fillContacts(GlobEnv.BUYER_COUNTRY, GlobEnv.BUYER_ADDRESS, GlobEnv.BUYER_CITY,  GlobEnv.BUYER_POSTCODE);
        Integer totalPrice = checkout.chooseShippingMethod();
        checkout.fillCardData(GlobEnv.BUYER_STRIPES_NOT_AUTH);
        checkout.confirmOrder();
        checkout.viewOrder(totalPrice);
    }
}