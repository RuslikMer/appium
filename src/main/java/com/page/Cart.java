package com.page;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


public class Cart extends BasePage {
    public Cart(AppiumDriver driver) {
        super(driver);
    }

    @Step("")
    public void goToCheckout() {
        driver.findElementByAccessibilityId("Import duties included").click();
        //totalAmount();
        WebElement checkoutButton = driver.findElement("-ios class chain", "**/XCUIElementTypeButton[`label == \"CHECKOUT\"`]");
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        checkoutButton.click();
    }

    @Step("")
    public Integer totalAmount() {
        Integer itemsPrice = Integer.valueOf(driver.findElement("xpath", "//XCUIElementTypeStaticText[@name=\"Items\"]/following-sibling::XCUIElementTypeStaticText").getText().replaceAll("[^0-9]", ""));
        System.out.println(itemsPrice);
        Integer discount = 0;
        try {
            discount = Integer.valueOf(driver.findElement("xpath", "//XCUIElementTypeStaticText[@name=\"Discount\"]/following-sibling::XCUIElementTypeStaticText").getText().replaceAll("[^0-9]", ""));
        } catch (Exception ignored){}

        Integer storeCredit = 0;
        try {
            storeCredit = Integer.valueOf(driver.findElement("xpath", "//XCUIElementTypeStaticText[@name=\"Store Credit\"]/following-sibling::XCUIElementTypeStaticText").getText().replaceAll("[^0-9]", ""));
        } catch (Exception ignored){}

        Integer shippingPrice = Integer.valueOf(driver.findElement("xpath", "//XCUIElementTypeStaticText[@name=\"Shipping\"]/following-sibling::XCUIElementTypeStaticText").getText().replaceAll("[^0-9]", ""));
        Integer totalPrice = Integer.valueOf(driver.findElement("xpath", "//XCUIElementTypeStaticText[@name=\"Total\"]/following-sibling::XCUIElementTypeStaticText").getText().replaceAll("[^0-9]", ""));
        Integer expected = (itemsPrice + shippingPrice - discount - storeCredit);
        Assert.assertEquals(totalPrice, expected);

        return totalPrice;
    }

    @Step("")
    public void useVoucher(String voucher) {
        driver.findElement("-ios class chain", "**/XCUIElementTypeButton[`label == \"Apply voucher\"`]").click();
        driver.findElement("-ios predicate string", "value == \"Enter voucher\"").sendKeys(voucher);
        driver.findElement("-ios class chain", "**/XCUIElementTypeButton[`label == \"Submit\"`]").click();
    }
}
