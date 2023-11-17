package com.testCase;

import com.page.Menu;
import com.setup.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;


@Epic("Regression Tests")
@Feature("")


public class CrossSaleProductsScrollTest extends BaseTest {


    @Test
    //@Severity(SeverityLevel.BLOCKER)
    @Description("check cross sale products scroll")
    @Story("")
    public void crossSaleProductsScrollTest() {
        home.openHomePage();
        menu.goToMenuCategory(Menu.NEW_IN);
        listing.goToProduct();
        product.scrollProductsCarousel();
    }
}