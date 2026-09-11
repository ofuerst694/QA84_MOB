package com.remindly.fw;

import com.remindly.core.BaseHelper;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MainScreenHelper extends BaseHelper {
    public MainScreenHelper(AppiumDriver driver) {
        super(driver);
    }

    public void confirm() {
        tap(By.id("android:id/button1"));
    }

//    public boolean isNoRemPresent() {
//        return isElementPresent(By.id("com.blanyal.remindly:id/no_reminder_text"));
//    }
    public boolean isNoRemPresent() {
    return isElementPresent(By.id("com.blanyal.remindly:id/no_reminder_text"));
}

    public void tapOnAddReminder() {
        tap(By.id("com.blanyal.remindly:id/add_reminder"));
    }

    public String isReminderPresent() {
        return isTextPresent(By.id("com.blanyal.remindly:id/recycle_title"));
    }

    public String isReminderDateTimePresent() {
        return isTextPresent(By.id("com.blanyal.remindly:id/recycle_date_time"));
    }
}
