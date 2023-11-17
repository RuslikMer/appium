package com.page;

import io.appium.java_client.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.Random;


class BasePage {

    public AppiumDriver driver;
    public WebDriverWait wait;
    public TouchAction touch;


    //Constructor
    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,30);
        touch = new TouchAction(driver);
    }

    void click(By element) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }

    String getText(By element) throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        return driver.findElement(element).getText();
    }

    boolean isEnableElement(By element) throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        Assert.assertTrue(driver.findElement(element).isEnabled());
        return true;
    }

    void assertText(By element, String text) throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        Assert.assertEquals(driver.findElement(element).getText(),"");
    }

    /**
     * Generation of a random string, the number of digits
     * in a string is set by the parameter.
     *
     */
    public String generateString(int length)
    {
        Random random = new Random();
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWYZ";
        int numChars = chars.length();
        StringBuilder newString = new StringBuilder();
        //int numLenght = 0;

        for (int i = 0; i <= length; i++) {
            int randomInt = random.nextInt(numChars);
            //int rndChar = rnd(1, numChars) - 1;
            newString.append(chars.charAt(randomInt));
        }

        return newString.toString();
    }
}
