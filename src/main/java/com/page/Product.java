package com.page;

import io.appium.java_client.*;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;


public class Product extends BasePage {
    public Product(AppiumDriver driver) {
        super(driver);
    }

    Login login = new Login(driver);
    Listing listing = new Listing(driver);

    @Step("")
    public Integer addToCart() {
        touch.longPress(PointOption.point(5, 700)).moveTo(PointOption.point(5, 400)).release().perform();
        WebElement sizeButton = driver.findElement("-ios predicate string", "value == \"Select Size\"");
        wait.until(ExpectedConditions.elementToBeClickable(sizeButton));
        sizeButton.click();
        selectSize();
        WebElement itemPrice = driver.findElement("xpath", "//XCUIElementTypeStaticText[@name=\"Item successfully added\"]/../following-sibling::XCUIElementTypeOther//XCUIElementTypeStaticText[contains(@name, \"$\")]");
        wait.until(ExpectedConditions.elementToBeClickable(itemPrice));
        Integer price = Integer.valueOf(itemPrice.getText().replaceAll("[^0-9]", ""));
        System.out.println(price);
        WebElement shoppingBagButton = driver.findElement("-ios class chain", "**/XCUIElementTypeButton[`label == \"SHOPPING BAG\"`]");
        wait.until(ExpectedConditions.elementToBeClickable(shoppingBagButton));
        shoppingBagButton.click();

        return price;
    }

    @Step("")
    public void selectSize() {
        WebElement sizeList = driver.findElement(By.xpath("//XCUIElementTypeTable"));
        List<WebElement> sizes = sizeList.findElements(By.xpath("//XCUIElementTypeCell[@name=\"XUIElementTypeDimensionCell\"]"));
        WebElement itemSize = sizes.get(0);
        for (WebElement size : sizes) {
            if (size.findElements(By.xpath("//XCUIElementTypeButton[@name=\"Request size\"]")).isEmpty()) {
                itemSize = size;

                break;
            }
        }
        System.out.println(itemSize);

        wait.until(ExpectedConditions.elementToBeClickable(itemSize));
        itemSize.click();
    }


    @Step("")
    public void sendRequestSize() {
        touch.longPress(PointOption.point(5, 700)).moveTo(PointOption.point(5, 400)).release().perform();
        String str = generateString(5);
        WebElement sizeButton = driver.findElement("-ios predicate string", "value == \"Select Size\"");
        wait.until(ExpectedConditions.elementToBeClickable(sizeButton));
        sizeButton.click();
        WebElement requestButton = driver.findElement("-ios class chain", "**/XCUIElementTypeButton[`label == \"Request size\"`][1]");
        requestButton.click();
        WebElement emailField = driver.findElement("-ios predicate string", "value == \"Enter e-mail\"");
        wait.until(ExpectedConditions.elementToBeClickable(emailField));
        emailField.sendKeys(str + "@bambinifashion.com");
        driver.getKeyboard().sendKeys(Keys.ENTER);
        driver.findElement("-ios class chain", "**/XCUIElementTypeButton[`label == \"SEND REQUEST\"`]").click();
        WebElement popUp = driver.findElementByAccessibilityId("Your request has been sent.");
        wait.until(ExpectedConditions.elementToBeClickable(popUp));
        popUp.click();
    }

    @Step("")
    public void checkSizeGuide() {
        touch.longPress(PointOption.point(5, 740)).moveTo(PointOption.point(5, 500)).release().perform();
        driver.findElement("-ios class chain", "**/XCUIElementTypeButton[`label == \"Size guide\"`]").click();
        driver.findElement("-ios class chain", "**/XCUIElementTypeButton[`label == \"INCHES\"`]").click();
        driver.findElement("-ios class chain", "**/XCUIElementTypeButton[`label == \"CM\"`]").click();
    }

    @Step("")
    public void fullView() {
        driver.findElement("xpath", listing.PRODUCT_IMAGE).click();
        driver.findElementByAccessibilityId("close").click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//XCUIElementTypeButton[@name=\"close\"]")));
    }

    @Step("")
    public void openTab(String tabName, boolean back) {
        String[] description = {"PRODUCT FEATURES: ", "PRODUCT DETAILS: ", "ABOUT THE BRAND"};
        String[] delivery = {"DELIVERY", "30 DAY RETURN", "SHIPPING", "IMPORT DUTIES INCLUDED"};
        String[] subTabs;
        touch.longPress(PointOption.point(5, 720)).moveTo(PointOption.point(5, 100)).release().perform();
        driver.findElement("-ios class chain", "**/XCUIElementTypeButton[`label == \""+tabName+"\"`]").click();
        if (tabName.equals("DESCRIPTION")) {
            subTabs = description;
        } else {
            subTabs = delivery;
        }

        for (String subTab : subTabs) {
            Assert.assertTrue(driver.findElementByAccessibilityId(subTab).isDisplayed());
        }

        if (back) {
            driver.findElementByAccessibilityId("backIcon").click();
        }
    }

    @Step("")
    public void sharing() {
        driver.findElementByAccessibilityId("Share").click();
        Assert.assertTrue(driver.findElement("-ios class chain", "**/XCUIElementTypeButton[`label == \"Copy\"`]").isDisplayed());
        driver.findElementByAccessibilityId("Close").click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//XCUIElementTypeButton[@name=\"Close\"]")));
    }

    @Step("")
    public void scrollProductsCarousel() {
        touch.longPress(PointOption.point(5, 720)).moveTo(PointOption.point(5, 100)).release().perform();
        touch.longPress(PointOption.point(5, 720)).moveTo(PointOption.point(5, 100)).release().perform();
        WebElement item = driver.findElement(By.xpath(listing.PRODUCT_CARD+"[1]"));
        List<WebElement> element = item.findElements(By.xpath("//XCUIElementTypeStaticText[last()]"));
        String name = element.get(0).getAttribute("name");
        WebElement scrollHor =  driver.findElementByAccessibilityId("Horizontal scroll bar, 1 page");
        Point location = scrollHor.getLocation();
        int x = location.getX();
        int y = location.getY();
        Dimension size = scrollHor.getSize();
        int width = size.getWidth();
        touch.longPress(PointOption.point(width, y)).moveTo(PointOption.point(x, y)).release().perform();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\""+name+"\"]")));
    }

    @Step("")
    public void goToCrossSaleProduct() {
        touch.longPress(PointOption.point(5, 720)).moveTo(PointOption.point(5, 100)).release().perform();
        touch.longPress(PointOption.point(5, 720)).moveTo(PointOption.point(5, 100)).release().perform();
        driver.findElement(By.xpath(listing.PRODUCT_CARD+"[1]")).click();
        touch.longPress(PointOption.point(5, 720)).moveTo(PointOption.point(5, 100)).release().perform();
        touch.longPress(PointOption.point(5, 720)).moveTo(PointOption.point(5, 100)).release().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//XCUIElementTypeCell[@name=\"RecentlyViewedProduct\"])[1]")));
    }
}