package com.page;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;


public class NavBar extends BasePage {
    public NavBar(AppiumDriver driver) {
        super(driver);
    }

    @Step("")
    public void goToNavTab(String tabName) {
        driver.findElementByAccessibilityId(tabName).click();
    }
}
