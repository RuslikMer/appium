package com.testCase;

import com.page.Menu;
import com.setup.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;


@Epic("Regression Tests")
@Feature("")


public class CheckImagesFullViewAtProductPageTest extends BaseTest {


    @Test
    //@Severity(SeverityLevel.BLOCKER)
    @Description("check images full view at product page")
    @Story("")
    public void checkImagesFullViewAtProductPageTest() {
        home.openHomePage();
        menu.goToMenuCategory(Menu.NEW_IN);
        listing.goToProduct();
        product.fullView();
    }
}