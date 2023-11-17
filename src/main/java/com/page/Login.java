package com.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class Login extends BasePage {
    public Login(AppiumDriver driver) {
        super(driver);
    }

    Checkout checkout = new Checkout(driver);

    @Step("")
    public void doLogin(String email, String password) {
        try {
            driver.findElement("-ios class chain", "**/XCUIElementTypeTextField[`value == \"Enter e-mail\"`][2]").sendKeys(email);
        } catch (Exception e) {
            driver.findElement("-ios class chain", "**/XCUIElementTypeTextField[`value == \"Enter e-mail\"`]").sendKeys(email);
        }

        //driver.swipe(0, 500, 0, 150, 5);
        touch.longPress(PointOption.point(0, 500)).moveTo(PointOption.point(0, 150)).release().perform();
        driver.findElement("-ios predicate string", "value == \"Enter password\"").sendKeys(password);
        driver.findElement("xpath", "//XCUIElementTypeButton[@name=\"SIGN IN\"] | //XCUIElementTypeButton[@name=\"LOG IN\"]").click();
    }

    @Step("")
    public void continueAsGuest() {
        driver.findElement("-ios class chain", "**/XCUIElementTypeStaticText[`label == \"Continue as Guest\"`]").click();
    }

    @Step("")
    public void forgotPassword() {
        driver.findElement("-ios class chain", "**/XCUIElementTypeButton[`label == \"Forgot password\"`]").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"FORGOT PASSWORD?\"]")));
        String email = generateString(5)+"@bambinifashion.com";
        driver.findElement("-ios predicate string", "value == \"Enter e-mail\"").sendKeys(email);
        driver.findElement("-ios class chain", "**/XCUIElementTypeButton[`label == \"SEND\"`]").click();
        checkout.waitAlert("Congratulations!", true);
    }

    @Step("")
    public void registration() {
        driver.findElement("-ios class chain", "**/XCUIElementTypeButton[`label == \"REGISTER\"`]").click();
    }

    @Step("")
    public void guestLogin() {
        String email = generateString(5)+"@bambinifashion.com";
        WebElement emailInput = driver.findElement("-ios class chain", "**/XCUIElementTypeTextField[`value == \"Enter e-mail\"`][1]");
        emailInput.click();
        emailInput.sendKeys(email);
        driver.findElement("xpath", "//XCUIElementTypeButton[@name=\"GUEST SIGN IN\"] | //XCUIElementTypeButton[@name=\"CHECKOUT\"]").click();
    }
}
