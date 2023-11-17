package com.page;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;


public class Profile extends BasePage {
    public Profile(AppiumDriver driver) {
        super(driver);
    }
    Checkout checkout = new Checkout(driver);

    @Step("")
    public void goToTabFromProfile(String tabName) {
        driver.findElementByAccessibilityId(tabName).click();
    }

    @Step("")
    public void updateData(String name, String lastName, String email, String password, Boolean back) {
        driver.findElement("-ios class chain", "**/XCUIElementTypeButton[`label == \"Change my password\"`]").click();
        driver.findElementByAccessibilityId("ProfileFieldFirstName").clear();
        driver.findElementByAccessibilityId("ProfileFieldFirstName").sendKeys(name);
        driver.findElementByAccessibilityId("ProfileFieldLastName").clear();
        driver.findElementByAccessibilityId("ProfileFieldLastName").sendKeys(lastName);
        driver.findElementByAccessibilityId("ProfileFieldEmail").click();
        driver.findElementByAccessibilityId("textFieldClearIcon").click();
        driver.findElementByAccessibilityId("ProfileFieldEmail").sendKeys(email);
        driver.findElementByAccessibilityId("ProfileFieldPassword").sendKeys(password);
        driver.findElementByAccessibilityId("ProfileFieldPasswordRepeat").sendKeys(password);
        driver.getKeyboard().sendKeys(Keys.ENTER);
        driver.findElement("-ios class chain", "**/XCUIElementTypeButton[`label == \"UPDATE\"`]");
        checkout.waitAlert("Congratulations!", true);
        if (back) driver.findElementByAccessibilityId("backIcon").click();
    }

    @Step("")
    public void logOut() {
        driver.findElementByAccessibilityId("LOG OUT").click();
    }
}
