package com.setup;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.page.*;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class BaseTest {


    public static AppiumDriver driver;
    public static Home home;
    public static Cart cart;
    public static Checkout checkout;
    public static Listing listing;
    public static Login login;
    public static Menu menu;
    public static NavBar navBar;
    public static Product product;
    public static Profile profile;
    public static Search search;
    public static Wishlist wishlist;
    public static JavascriptExecutor jse;
    protected WebDriverWait wait;
    private String testCaseName;
    private long testStartTime;
    private long testFinishTime;
    private long testDurationTime;
    private String testFailedMsg;

    public WebDriver getDriver() {
        return driver;
    }

    protected long getTestStartTime() {
        return testStartTime;
    }

    protected void setTestStartTime(long testStartTime) {
        this.testStartTime = testStartTime;
    }

    protected long getTestFinishTime() {
        return testFinishTime;
    }

    protected void setTestFinishTime(long testFinishTime) {
        this.testFinishTime = testFinishTime;
    }

    protected long getTestDurationTime() {
        return testDurationTime;
    }

    protected void setTestDurationTime(long testDurationTime) {
        this.testDurationTime = testDurationTime;
    }

    protected String getTestCaseName() {
        return testCaseName;
    }

    protected void setTestCaseName(String testCaseName) {
        this.testCaseName = testCaseName;
    }

    public String getTestFailedMsg() {
        return testFailedMsg;
    }

    public void setTestFailedMsg(String testFailedMsg) {
        this.testFailedMsg = testFailedMsg;
    }


    @BeforeSuite()
    public void setUp() {
    }

    @AfterSuite
    public void tearDown() {
    }

    @BeforeTest
    public void beforeTest() {
    }

    @AfterTest
    public void afterTest() {
    }

    @BeforeMethod
    public void beforeMethod(Method method) throws MalformedURLException {
        DeviceSetup.prepareDevice();
        wait = new WebDriverWait(driver, 30);
        home = new Home(driver);
        cart = new Cart(driver);
        checkout = new Checkout(driver);
        listing = new Listing(driver);
        login = new Login(driver);
        menu = new Menu(driver);
        navBar = new NavBar(driver);
        product = new Product(driver);
        profile = new Profile(driver);
        search = new Search(driver);
        wishlist = new Wishlist(driver);
        jse = (JavascriptExecutor)driver;
        jse.executeScript("browserstack_executor: {\"action\": \"setSessionName\", \"arguments\": {\"name\":\""+ method.getName() +"\" }}");
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {

        try{
            if (result.getStatus() == ITestResult.SUCCESS) {
                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\"}}");
            } else if (result.getStatus() == ITestResult.FAILURE) {
                //jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \""+ result.getThrowable().getMessage().split("")[0] +"\"}}");
                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\"}}");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}