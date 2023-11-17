package com.setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;


public class DeviceSetup extends BaseTest {

   public static String __build_number__ = "__build_number__template";
   public static String __bs_app__ = "__bs_app__template";

   static AppiumDriver prepareDevice() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        //local
//        capabilities.setCapability(MobileCapabilityType.APP, "/Users/rus/bambiniFashion Stage.app");
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15.5");
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
//        //capabilities.setCapability(MobileCapabilityType.PLATFORM, "MAC");
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"iPhone 13 Pro");
//        capabilities.setCapability("udid","C7CBBF90-C33D-48D6-9E6E-19F64742E438");
//        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
//        //capabilities.setCapability("appium-version", "1.7.2");
//        capabilities.setCapability("autoAcceptAlerts",true);
//        capabilities.setCapability("noReset",true);
//        //capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
//        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 30000);
//        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        //browserstack
        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        //browserstackOptions.put("project", "app-inspector");
        browserstackOptions.put("osVersion", "16");
        browserstackOptions.put("realMobile", "true");
        browserstackOptions.put("local", "false");
        browserstackOptions.put("userName", "ruslanmerikanov_hgdoNE");
        browserstackOptions.put("accessKey", "rapizxxxCccqv5havz6k");
        capabilities.setCapability("bstack:options", browserstackOptions);
        capabilities.setCapability("app", __bs_app__);
        capabilities.setCapability("deviceName","iPhone 14");
        capabilities.setCapability("os", "ios");
        capabilities.setCapability("build", __build_number__);
        //capabilities.setCapability("name", testName);
        capabilities.setCapability("skipUnlock",true);
        capabilities.setCapability("autoAcceptAlerts",true);
        capabilities.setCapability("noReset", false);
        capabilities.setCapability("browserstack.networkLogs", true);
        capabilities.setCapability("browserstack.debug", true);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 1000);
        driver = new IOSDriver(new URL("https://hub-cloud.browserstack.com/wd/hub"), capabilities);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;
    }
}
