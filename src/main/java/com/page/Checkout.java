package com.page;

import io.appium.java_client.*;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;
import com.helper.GlobEnv;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


public class Checkout extends BasePage {
    public Checkout(AppiumDriver driver) {
        super(driver);
    }

    Cart cart = new Cart(driver);

    @Step("")
    public void fillContacts(String country, String address, String city, String postcode) {
        WebElement nameInput = driver.findElement("-ios predicate string", "value == \"Enter name\"");
        wait.until(ExpectedConditions.elementToBeClickable(nameInput));
        nameInput.sendKeys(GlobEnv.BUYER_NAME);
        driver.findElement("-ios predicate string", "value == \"Enter surname\"").sendKeys(GlobEnv.BUYER_LAST_NAME);
        driver.findElement("-ios predicate string", "value == \"Enter address line 1\"").sendKeys(address);
        driver.findElement("xpath", "//XCUIElementTypeApplication[@name=\"BAMBINI STAGE\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeTextField[5]").click();
        touch.longPress(PointOption.point(0, 0)).moveTo(PointOption.point(0, 500)).release().perform();
        //driver.swipe(0, 0, 0, 500, 5);
        driver.findElement("accessibility id", country).click();
        driver.findElement("accessibility id", country).click();

        driver.findElement("-ios predicate string", "value == \"Enter city\"").sendKeys(city);
        driver.findElement("-ios predicate string", "value == \"Enter postal code\"").sendKeys(postcode);
        driver.findElement("-ios predicate string", "value == \"Enter telephone\"").sendKeys(GlobEnv.BUYER_PHONE);
        touch.longPress(PointOption.point(5, 500)).moveTo(PointOption.point(5, 150)).release().perform();
        //driver.swipe(0, 500, 0, 150, 5);
        driver.getKeyboard();
        driver.hideKeyboard();
        driver.findElement("-ios class chain", "**/XCUIElementTypeButton[`label == \"CONTINUE\"`]").click();
    }

    @Step("")
    public Integer chooseShippingMethod() {
        driver.findElement("-ios class chain", "**/XCUIElementTypeOther[`name == \"SHIPPING METHOD\"`]/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeOther/XCUIElementTypeOther").getText();
        driver.findElement("-ios class chain", "**/XCUIElementTypeStaticText[`label == \"CONTINUE\"`][1]").getLocation();
        driver.findElement("-ios class chain", "**/XCUIElementTypeStaticText[`label == \"CONTINUE\"`][1]").click();

        return cart.totalAmount();
    }

    @Step("")
    public void fillCardData(String cardNumber) {
        driver.findElementByAccessibilityId("card number").sendKeys(cardNumber);
        driver.findElementByAccessibilityId("expiration date").sendKeys("1228");
        driver.findElement("-ios class chain", "**/XCUIElementTypeTextField[`label == \"CVC\"`]").sendKeys("123");
    }

    @Step("")
    public void payByPayPal() {
        driver.findElementByAccessibilityId("PayPal").click();
        driver.findElement("-ios class chain", "**/XCUIElementTypeButton[`label == \"PAY\"`]").click();
        driver.findElement("-ios class chain", "**/XCUIElementTypeTextField[`value == \"Email address or mobile number\"`]").sendKeys(GlobEnv.PAYPAL_LOGIN);
        driver.getKeyboard().sendKeys(Keys.ENTER);
        driver.findElement("-ios class chain", "**/XCUIElementTypeButton[`label == \"Next\"`][1]").click();
        driver.findElement("-ios class chain", "**/XCUIElementTypeSecureTextField[`value == \"Password\"`]").sendKeys(GlobEnv.PAYPAL_PASS);
        driver.findElementByAccessibilityId("Log In").click();
        driver.findElementByAccessibilityId("Complete Purchase").click();
    }

    @Step("")
    public void payByApplePay() {
        driver.findElementByAccessibilityId("Buy with Apple Pay").click();
        addBillingAddressForApplePay();
        addShippingContactForApplePay();
        addShippingAddressForApplePay();
        driver.findElement("xpath", "(//XCUIElementTypeButton[@name=\"Pay with Passcode\"])[2]").click();
    }

    @Step("")
    public void addBillingAddressForApplePay() {
        driver.findElement("xpath", "//XCUIElementTypeButton[contains(@name,\"Add Billing Address\")]").click();
        driver.findElement("xpath", "(//XCUIElementTypeCell[@name=\"Add Billing Address\"])[2]").click();
        driver.findElement("xpath", "(//XCUIElementTypeCell[@name=\"First Name\"])[2]//XCUIElementTypeTextField").sendKeys(GlobEnv.BUYER_NAME);
        driver.findElement("xpath", "(//XCUIElementTypeCell[@name=\"Last Name\"])[2]//XCUIElementTypeTextField").sendKeys(GlobEnv.BUYER_LAST_NAME);
        driver.findElement("xpath", "(//XCUIElementTypeCell[@name=\"Street, Search Contact or Address\"])[2]//XCUIElementTypeTextField").sendKeys(GlobEnv.BUYER_ADDRESS);
        driver.findElement("xpath", "(//XCUIElementTypeCell[@name=\"State\"])[2]//XCUIElementTypeTextField").sendKeys("state");
        driver.findElement("xpath", "(//XCUIElementTypeCell[@name=\"City\"])[2]//XCUIElementTypeTextField").sendKeys(GlobEnv.BUYER_CITY);
        driver.findElement("xpath", "(//XCUIElementTypeCell[@name=\"ZIP\"])[2]//XCUIElementTypeTextField").sendKeys(GlobEnv.BUYER_POSTCODE);
        driver.findElement("xpath", "(//XCUIElementTypeButton[@name=\"Done\"])[2]").click();
        driver.findElement("xpath", "(//XCUIElementTypeButton[@name=\"close\"])[2]").click();
    }

    @Step("")
    public void addShippingContactForApplePay() {
        driver.findElement("xpath", "(//XCUIElementTypeButton[@name=\"Add Contact\"])[2]").click();
        driver.findElement("xpath", "(//XCUIElementTypeButton[@name=\"Add Phone Number\"])[2]").click();
        driver.findElement("xpath", "(//XCUIElementTypeOther[@name=\"Phone Number\"])[2]/XCUIElementTypeTextField").sendKeys(GlobEnv.BUYER_PHONE);
        driver.findElement("xpath", "(//XCUIElementTypeButton[@name=\"Add Email Address\"])[2]").click();
        driver.findElement("xpath", "(//XCUIElementTypeOther[@name=\"Email\"])[2]/XCUIElementTypeTextField").sendKeys(GlobEnv.BUYER_EMAIL);
        driver.findElement("xpath", "(//XCUIElementTypeButton[@name=\"Done\"])[2]").click();
    }

    @Step("")
    public void addShippingAddressForApplePay() {
        driver.findElement("xpath", "(//XCUIElementTypeButton[@name=\"Add Shipping\"])[2]").click();
        driver.findElement("xpath", "(//XCUIElementTypeButton[@name=\"Add Shipping Address\"])[2]").click();
        driver.findElement("xpath", "(//XCUIElementTypeButton[@name=\"Add Address Manually\"])[2]").click();
        driver.findElement("xpath", "(//XCUIElementTypeCell[@name=\"First Name\"])[2]//XCUIElementTypeTextField").sendKeys(GlobEnv.BUYER_NAME);
        driver.findElement("xpath", "(//XCUIElementTypeCell[@name=\"Last Name\"])[2]//XCUIElementTypeTextField").sendKeys(GlobEnv.BUYER_LAST_NAME);
        driver.findElement("xpath", "(//XCUIElementTypeCell[@name=\"Street, Search Contact or Address\"])[2]//XCUIElementTypeTextField").sendKeys(GlobEnv.BUYER_ADDRESS);
        driver.findElement("xpath", "(//XCUIElementTypeCell[@name=\"State\"])[2]//XCUIElementTypeTextField").sendKeys("state");
        driver.findElement("xpath", "(//XCUIElementTypeCell[@name=\"City\"])[2]//XCUIElementTypeTextField").sendKeys(GlobEnv.BUYER_CITY);
        driver.findElement("xpath", "(//XCUIElementTypeCell[@name=\"ZIP\"])[2]//XCUIElementTypeTextField").sendKeys(GlobEnv.BUYER_POSTCODE);
        driver.findElement("xpath", "(//XCUIElementTypeButton[@name=\"Done\"])[2]").click();
        driver.findElement("xpath", "(//XCUIElementTypeButton[@name=\"Done\"])[2]").click();
    }

    @Step("")
    public void confirmOrder() {
        WebElement payButton = driver.findElement("-ios class chain", "**/XCUIElementTypeButton[`label == \"PAY\"`]");
        payButton.click();
        payButton.click();
        driver.findElement("-ios class chain", "**/XCUIElementTypeOther[`label == \"Authentication Complete\"`]");
        driver.findElement("-ios class chain", "**/XCUIElementTypeButton[`label == \"Close\"`]").click();
    }

    @Step("")
    public void complete3DSecure(boolean authorize) {
        driver.findElement("-ios class chain", "**/XCUIElementTypeButton[`label == \"PAY\"`]").click();
        if (authorize) {
            driver.findElementByAccessibilityId("COMPLETE AUTHENTICATION").click();
        } else {
            driver.findElementByAccessibilityId("FAIL AUTHENTICATION").click();
        }

        driver.findElement("-ios class chain", "**/XCUIElementTypeButton[`label == \"Close\"`]").click();
    }

    @Step("")
    public void waitAlert(String message, Boolean close) {
        Assert.assertTrue(driver.findElementByAccessibilityId(message).isDisplayed());
        if (close) driver.findElementByAccessibilityId("closeIconTemplate").click();
    }

    @Step("")
    public String viewOrder(Integer expected) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeButton[@name=\"VIEW ORDER\"]")));
        driver.findElement("-ios class chain", "**/XCUIElementTypeButton[`label == \"VIEW ORDER\"`]").click();

        return orderData(expected);
    }

    @Step("")
    public String orderData(Integer expected) {
        String orderId = driver.findElement("xpath", "//XCUIElementTypeStaticText[@name=\"Reference\"]/following-sibling::XCUIElementTypeStaticText").getText();
        System.out.println(orderId);
        Integer totalPrice = Integer.valueOf(driver.findElement("xpath", "(//XCUIElementTypeStaticText[@name=\"Total\"])[1]/following-sibling::XCUIElementTypeStaticText").getText().replaceAll("[^0-9]", ""));
        Assert.assertEquals(totalPrice, expected);

        return orderId;
    }
}