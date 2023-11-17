package com.page;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Search extends BasePage {
    public Search(AppiumDriver driver) {
        super(driver);
    }
    NavBar navBar = new NavBar(driver);
    Listing listing = new Listing(driver);

    @Step("")
    public void search(String searchRequest, boolean press) {
        navBar.goToNavTab("Search");
        driver.findElement("-ios predicate string", "type == \"XCUIElementTypeSearchField\"").sendKeys(searchRequest);
        if (press) driver.getKeyboard().sendKeys(Keys.ENTER);
    }

    @Step("")
    public void goToSearchResult(String searchRequest) {
        WebElement searchResult = driver.findElementByAccessibilityId(searchRequest);
        wait.until(ExpectedConditions.elementToBeClickable(searchResult));
        searchResult.click();
    }

    @Step("")
    public void goToLiveSearchResult(String section) {
        String sectionPath = "//XCUIElementTypeCell[@name=\"XUIElementTypeAlgolia"+section+"Cell\"]";
        switch (section) {
            case "Product":
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeCell[@name=\"XUIElementTypeAlgoliaBrandCell\"]")));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeCell[@name=\"XUIElementTypeAlgoliaCategoryCell\"]")));

                break;
            case "Brand":
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeCell[@name=\"XUIElementTypeAlgoliaProductCell\"]")));
                driver.findElement("xpath", "//XCUIElementTypeOther[@name=\"DESIGNERS\"]//XCUIElementTypeStaticText[@name=\"VIEW MORE\"]").click();
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//XCUIElementTypeOther[@name=\"DESIGNERS\"]//XCUIElementTypeStaticText[@name=\"VIEW MORE\"]")));

                break;
            default:
                driver.findElement("xpath", "//XCUIElementTypeOther[@name=\"CATEGORIES\"]//XCUIElementTypeStaticText[@name=\"VIEW MORE\"]").click();
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//XCUIElementTypeOther[@name=\"CATEGORIES\"]//XCUIElementTypeStaticText[@name=\"VIEW MORE\"]")));

        }

        String name = driver.findElement("xpath", sectionPath+"[1]/XCUIElementTypeStaticText[1]").getAttribute("name");
        System.out.println(sectionPath+"[1]/XCUIElementTypeStaticText");

        System.out.println(name);
        driver.findElement("xpath", sectionPath+"[1]").click();

        switch (section) {
            case "Product":
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(listing.PRODUCT_IMAGE)));
                Assert.assertTrue(driver.findElementByAccessibilityId(name).isEnabled());

                break;
            case "Brand":
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(listing.PRODUCT_CARD)));
                Assert.assertTrue(driver.findElementByAccessibilityId(name.toUpperCase()).isEnabled());

                break;
            default:
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[contains(@name, \""+name.toUpperCase()+"\")]")));
        }
    }

    @Step("")
    public void goToAllProductsFromLiveSearchResult(String searchRequest) {
        driver.findElement("-ios predicate string", "label == \"VIEW ALL PRODUCTS\"").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"SEARCH RESULTS FOR “"+searchRequest.toUpperCase()+"”\"]")));
    }
}