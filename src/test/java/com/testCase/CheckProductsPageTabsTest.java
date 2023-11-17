package com.testCase;

import com.page.Menu;
import com.setup.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;


@Epic("Regression Tests")
@Feature("")


public class CheckProductsPageTabsTest extends BaseTest {


    @Test
    //@Severity(SeverityLevel.BLOCKER)
    @Description("check information tabs at product page")
    @Story("")
    public void checkProductsPageTabsTest() {
        home.openHomePage();
        menu.goToMenuCategory(Menu.NEW_IN);
        listing.goToProduct();
        product.openTab("DESCRIPTION", true);
        product.openTab("DELIVERY AND RETURNS", false);
    }
}