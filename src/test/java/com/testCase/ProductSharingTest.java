package com.testCase;

import com.page.Menu;
import com.setup.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;


@Epic("Regression Tests")
@Feature("")


public class ProductSharingTest extends BaseTest {


    @Test
    //@Severity(SeverityLevel.BLOCKER)
    @Description("check product sharing")
    @Story("")
    public void productSharingTest() {
        home.openHomePage();
        menu.goToMenuCategory(Menu.NEW_IN);
        listing.goToProduct();
        product.sharing();
    }
}