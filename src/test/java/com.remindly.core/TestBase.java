package com.remindly.core;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class TestBase {


    protected AppManager app = new AppManager();

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        app.init();

    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        app.stop();
        app.getMainScreen().confirm();

    }

}

//
//{
//        "platformName", "Android",
//        "automationName","UIAutomator2",
//        "platformVersion", "11",
//        "devicesName", "mob",
//        "appPackage", "com.blanyal.remindly",
//        "appActivity", "com.blanyal.remindme.MainActivity"
 //       }