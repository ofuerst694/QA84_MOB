package com.remindly.core;

import com.remindly.fw.MainScreenHelper;
import com.remindly.fw.ReminderHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AppManager {
    AppiumDriver driver;
    DesiredCapabilities capabilities;

    MainScreenHelper mainScreen;
    ReminderHelper reminder;


    public void init() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
//        capabilities.setCapability( "platformName","Android");
//        capabilities.setCapability("automationName","UIAutomator2");
//        capabilities.setCapability( "platformVersion","11");
//        capabilities.setCapability("devicesName","mob");
//        capabilities.setCapability("appPackage","com.blanyal.remindly");
//        capabilities.setCapability("appActivity","com.blanyal.remindme.MainActivity");
//        capabilities.setCapability("app","C:/Users/7500251/Downloads/Remindly.apk");

        capabilities.setCapability("appium:platformName", "Android");
        capabilities.setCapability("appium:automationName", "UIAutomator2");
        capabilities.setCapability("appium:platformVersion", "11");
        capabilities.setCapability("appium:devicesName", "mob");
        capabilities.setCapability("appium:appPakage", "com.blanyal.remindly");
        capabilities.setCapability("appium:appActivity", "com.blanyal.remindme.MainActivity");
        capabilities.setCapability("appium:app", "C:/Users/7500251/Downloads/Remindly.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        mainScreen = new MainScreenHelper(driver);
        reminder = new ReminderHelper(driver);

    }

    public void stop() {
        driver.quit();
    }

    public ReminderHelper getReminder() {
        return reminder;
    }

    public MainScreenHelper getMainScreen() {
        return mainScreen;
    }
}
