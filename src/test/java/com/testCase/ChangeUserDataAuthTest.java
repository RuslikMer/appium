package com.testCase;

import com.helper.GlobEnv;
import com.setup.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;


@Epic("Regression Tests")
@Feature("")


public class ChangeUserDataAuthTest extends BaseTest {


    @Test
    //@Severity(SeverityLevel.BLOCKER)
    @Description("update user personal information")
    @Story("")
    public void changeUserDataAuthTest() {
        home.openHomePage();
        menu.login(GlobEnv.CHANGE_EMAIL, GlobEnv.PASSWORD);
        menu.goToProfile();
        profile.goToTabFromProfile("PERSONAL INFORMATION");
        profile.updateData(GlobEnv.NEW_NAME, GlobEnv.NEW_LAST_NAME, GlobEnv.NEW_EMAIL, GlobEnv.NEW_PASSWORD, true);
        profile.logOut();
        login.doLogin(GlobEnv.NEW_EMAIL, GlobEnv.NEW_PASSWORD);
        menu.goToProfile();
        profile.goToTabFromProfile("PERSONAL INFORMATION");
        profile.updateData(GlobEnv.BUYER_NAME, GlobEnv.BUYER_LAST_NAME, GlobEnv.CHANGE_EMAIL, GlobEnv.PASSWORD, false);
    }
}