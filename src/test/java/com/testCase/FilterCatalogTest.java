package com.testCase;

import com.page.Menu;
import com.setup.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;


@Epic("Regression Tests")
@Feature("")


public class FilterCatalogTest extends BaseTest {


    @Test
    //@Severity(SeverityLevel.BLOCKER)
    @Description("filter catalog")
    @Story("")
    public void filterCatalogTest() {
        home.openHomePage();
        menu.goToMenuCategory(Menu.NEW_IN);
        listing.selectCategoryFilter("Age");
    }
}