package com.testCase;

import com.page.Menu;
import com.setup.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;


@Epic("Regression Tests")
@Feature("")


public class CheckSizeGuideTest extends BaseTest {


    @Test
    //@Severity(SeverityLevel.BLOCKER)
    @Description("check size guide")
    @Story("")
    public void checkSizeGuideTest() {
        home.openHomePage();
        menu.goToMenuCategory(Menu.NEW_IN);
        listing.goToProduct();
        product.checkSizeGuide();
    }
}