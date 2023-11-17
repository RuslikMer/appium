package com.page;

import io.appium.java_client.*;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;
import com.helper.GlobEnv;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.*;


public class Listing extends BasePage {
    public Listing(AppiumDriver driver) {
        super(driver);
    }

    Login login = new Login(driver);
    public String PRODUCT_CARD = "//XCUIElementTypeCell[@name=\"XUIElementTypeShopProductCell\"]";
    public String PRODUCT_IMAGE = "(//XCUIElementTypeImage[@name=\"ProductImage\"])[1]";

    //Random rand;

    @Step("")
    public void goToProduct() {
        driver.findElement("-ios class chain", "**/XCUIElementTypeCell[`name == \"XUIElementTypeShopProductCell\"`][1]").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PRODUCT_IMAGE)));
    }

    @Step("")
    public void selectCategoryFilter(String filterName) {
        WebElement filters = driver.findElement("-ios class chain", "**/XCUIElementTypeButton[`label == \"FILTER PRODUCTS\"`]");
        wait.until(ExpectedConditions.elementToBeClickable(filters));
        filters.click();
        //driver.findElement("xpath", "//XCUIElementTypeButton[@name=\"FILTER PRODUCTS\"]").click();
        expandFilter(filterName);
        WebElement filter = driver.findElement(By.xpath("//*[@name=\"XUIElementTypeFilterSectionHeader\"]//XCUIElementTypeStaticText[@name=\""+ filterName +"\"]/../following-sibling::XCUIElementTypeCell"));
        System.out.println(filter);
        List<WebElement> filtersData = filter.findElements(By.xpath("//XCUIElementTypeStaticText[@name]"));
        System.out.println(filtersData);
        WebElement option = filtersData.get(0);
        System.out.println(option);
        option.click();
        driver.findElement("xpath", "//XCUIElementTypeButton[contains(@name, \"SHOW\")]").click();
    }

    @Step("")
    public void expandFilter(String filterName) {
        WebElement filter = driver.findElement("xpath", "//*[@name=\"XUIElementTypeFilterSectionHeader\"]//XCUIElementTypeStaticText[@name=\""+ filterName +"\"]");
        wait.until(ExpectedConditions.elementToBeClickable(filter));
        filter.click();
    }

    @Step("")
    public void addToWishlist(String auth) {
        WebElement wishlistCount = driver.findElement("xpath", "//XCUIElementTypeButton[@name=\"favOutlineIcon\"]//XCUIElementTypeStaticText");
        //wait.until(ExpectedConditions.visibilityOf(wishlistCount));
        int countBefore = Integer.parseInt(wishlistCount.getAttribute("name"));
        touch.longPress(PointOption.point(5, 740)).moveTo(PointOption.point(5, 500)).release().perform();
        WebElement heart = driver.findElement("-ios class chain", "**/XCUIElementTypeButton[`label == \"heartEmpty\"`][1]");
        wait.until(ExpectedConditions.elementToBeClickable(heart));
        heart.click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"GUEST LOGIN\"]")));
        if (Objects.equals(auth, "auth")) {
            login.doLogin(GlobEnv.BUYER_EMAIL, GlobEnv.PASSWORD);
        } else if (Objects.equals(auth, "guest")) {
            login.guestLogin();
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeButton[@name=\"heartFull\"]")));
        int countAfter = Integer.parseInt(wishlistCount.getAttribute("name"));
        assert countAfter > countBefore;
    }

    @Step("")
    public void removeFromWishList() {
        WebElement wishlistCount = driver.findElement("xpath", "//XCUIElementTypeButton[@name=\"favOutlineIcon\"]//XCUIElementTypeStaticText");
        int countBefore = Integer.parseInt(wishlistCount.getAttribute("name"));
        driver.findElementByAccessibilityId("heartFull").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//XCUIElementTypeButton[@name=\"heartEmpty\"])[1]")));
        int countAfter = Integer.parseInt(wishlistCount.getAttribute("name"));
        assert countAfter < countBefore;
    }

    @Step("")
    public void checkPagination() {
        for(int i = 1; i <= 13; i++) {
            touch.longPress(PointOption.point(5, 740)).moveTo(PointOption.point(5, 100)).release().perform();
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[contains(@name, \"1 OF\")]")));
        driver.findElementByAccessibilityId("Forward").click();
        for(int i = 1; i <= 12; i++) {
            touch.longPress(PointOption.point(5, 740)).moveTo(PointOption.point(5, 100)).release().perform();
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[contains(@name, \"2 OF\")]")));
    }

    @Step("")
    public void quickFilter() {
        List filters = driver.findElements("-ios class chain", "**/XCUIElementTypeCell[`name == \"XUIElementTypeQuickFilterCell\"`]");
        System.out.println(filters);
//        int filtersCount = filters.size() - 1;
//        System.out.println(filtersCount);
//        int randomNum = rand.nextInt(10) + 1;
//        System.out.println(randomNum);
        System.out.println(filters.get(0));
        WebElement filter = (WebElement) filters.get(0);
        filter.click();
        driver.findElementByAccessibilityId("Back").click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//XCUIElementTypeStaticText[@name=\"Back\"])[2]")));
    }

    @Step("")
    public void swipeImage(String imagePath) {
        WebElement productCard = driver.findElement("xpath", imagePath);
        Point location = productCard.getLocation();
        int x = location.getX();
        int y = location.getY();
        Dimension size = productCard.getSize();
        int width = size.getWidth();
        int height = size.getHeight();
        touch.longPress(PointOption.point(width, y+(height/2))).moveTo(PointOption.point(x, y+(height/2))).release().perform();
        Assert.assertTrue(driver.findElement("-ios class chain", "**/XCUIElementTypePageIndicator[`value == \"page 2 of 2\"`]").isDisplayed());
    }
}