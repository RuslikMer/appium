package com.page;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class Wishlist extends BasePage {
    public Wishlist(AppiumDriver driver) {
        super(driver);
    }

    @Step("")
    public void remove() {
        WebElement wishlistCount = driver.findElement("xpath", "//XCUIElementTypeButton[@name=\"favOutlineIcon\"]//XCUIElementTypeStaticText");
        int countBefore = Integer.parseInt(wishlistCount.getAttribute("name"));
        driver.findElement("-ios class chain", "**/XCUIElementTypeImage[`label == \"trash\"`][1]").click();
        int countAfter = Integer.parseInt(wishlistCount.getAttribute("name"));
        assert countAfter < countBefore;
    }

    @Step("")
    public void goToProduct() {}

    @Step("")
    public void addToCart() {}
}