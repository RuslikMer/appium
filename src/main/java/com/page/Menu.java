package com.page;

import io.appium.java_client.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.util.*;


public class Menu extends BasePage {
    public Menu(AppiumDriver driver) {
        super(driver);
    }

    public NavBar navBar = new NavBar(driver);
    public Login login = new Login(driver);
    public final static String NEW_IN = "NEW IN";
    public final static String DESIGNERS = "DESIGNERS";
    public final static String BABY = "BABY";
    public final static String BOY = "BOY";
    public final static String GIRL = "GIRL";
    public final static String SHOES = "SHOES";
    public final static String LIFESTYLE = "LIFESTYLE";
    public final static String SALE = "SALE";

    @Step("")
    public void goToMenuCategory(String category) {
        navBar.goToNavTab("Menu");
        driver.findElementByAccessibilityId(category).click();
        categoryCheck(category);
    }

    @Step("")
    public void categoryCheck(String category) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeButton[@name=\"FILTER PRODUCTS\"]")));
        String catName = driver.findElement("xpath", "//XCUIElementTypeStaticText[contains(@name, \""+ category.toUpperCase() +"\")]").getText();
        Assert.assertEquals(category, catName);
    }

    @Step("")
    public void changeCountry(String country) {
        navBar.goToNavTab("Menu");
        driver.findElementByAccessibilityId("LOCATION").click();
        driver.findElementByAccessibilityId(country).click();
        driver.findElementByAccessibilityId("//*[contains(@name,\""+ country +"\")]");

    }

    @Step("")
    public void changeCurrency(String currency) {
        navBar.goToNavTab("Menu");
        driver.findElementByAccessibilityId("CURRENCY").click();
        driver.findElementByAccessibilityId(currency).click();
        String[] symbol = currency.split(" ");
        driver.findElement("xpath","//*[contains(@name,\""+ symbol[0] +"\")]");
    }

    @Step("")
    public void goToProfile() {
        navBar.goToNavTab("Menu");
        driver.findElementByAccessibilityId("MY ACCOUNT").click();
    }

    @Step("")
    public void login(String email, String password) {
        goToProfile();
        driver.findElementByAccessibilityId("SIGN IN").click();
        login.doLogin(email, password);
    }
}
