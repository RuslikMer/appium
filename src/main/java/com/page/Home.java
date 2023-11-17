package com.page;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


public class Home extends BasePage {
    public Home(AppiumDriver driver) {
        super(driver);
    }

    @Step("")
    public void selectCategory(String sectionName) {
        driver.findElementByAccessibilityId(sectionName).click();
        String category = driver.findElement("xpath", "//*[contains(@name, \""+ sectionName +"\")]").getText();
        Assert.assertEquals(sectionName, category);
    }

    @Step("")
    public void openHomePage() {
        driver.findElement("-ios class chain", "**/XCUIElementTypeButton[`label == \"NEXT\"`]").click();
    }

    @Step("")
    public void goToWishlist() {
        driver.findElementByAccessibilityId("favOutlineIcon").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeNavigationBar[@name=\"WISHLIST\"]")));
    }
}
