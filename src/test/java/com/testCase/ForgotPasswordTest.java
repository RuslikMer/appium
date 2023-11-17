package com.testCase;

import com.page.Menu;
import com.setup.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;


@Epic("Regression Tests")
@Feature("")


public class ForgotPasswordTest extends BaseTest {


    @Test
    //@Severity(SeverityLevel.BLOCKER)
    @Description("forgot password")
    @Story("")
    public void forgotPasswordTest() {
        home.openHomePage();
        menu.goToProfile();
        driver.findElementByAccessibilityId("SIGN IN").click();
        login.forgotPassword();
    }
}