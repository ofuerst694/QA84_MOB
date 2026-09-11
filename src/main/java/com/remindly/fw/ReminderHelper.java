package com.remindly.fw;

import com.remindly.core.BaseHelper;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ReminderHelper extends BaseHelper {
    public ReminderHelper(AppiumDriver driver) {
        super(driver);
    }

    public void enterReminderTitle(String text) {
        type(By.id("com.blanyal.remindly:id/reminder_title"), text);
    }

    public void saveReminder() {
        tap(By.id("com.blanyal.remindly:id/save_reminder"));
    }

    public void tapOnDateField() {
        tap(By.id("com.blanyal.remindly:id/date"));
    }

    public void swipeToMonth(String period, String month, int swipeCount) {
        pause(500);
        if (!getSelectedMonth().equals(month)) {
            for (int i = 0; i < swipeCount; i++) {
                if (period.equals("future")) {
                    swipe(0.8, 0.4);
                } else if (period.equals("past")) {
                    swipe(0.5,0.9);
                }

            }
        }
    }
        private String getSelectedMonth () {
            return isTextPresent(By.id("com.blanyal.remindly:id/date_picker_month"));
        }

    public void swipeDate(int index) {
        List<WebElement> days =driver.findElements(By.className("android.view.View"));
         days.get(index-1).click();
    }

    public void tapOnYear() {
        tap(By.id("com.blanyal.remindly:id/date_picker_year"));
    }

    public void swipeToYear(String period,String year) {
        pause(500);

        if(!getSelectedYear().equals(year)){
            if (period.equals("future")){
                untilNeededYear(year,0.6,0.5);
            }else if (period.equals("past")){
                untilNeededYear(year,0.5,0.6);
            }
        }
        tap(By.id("com.blanyal.remindly:id/month_text_view"));

    }
    private String getSelectedYear(){
        return  isTextPresent(By.id("com.blanyal.remindly:id/date_picker_year"));
    }
    private void untilNeededYear(String year,double start,double stop){
        while (!getYear().equals(year)){
            swipe(start,stop);
        }
        getYear();
    }
    private String getYear(){
        return  isTextPresent(By.id("com.blanyal.remindly:id/month_text_view"));
    }

    public void tapOnOk() {
       // tap(By.id("com.blanyal.remindly:id/ok"));
        tap(By.xpath("//*[@text='OK']"));
    }
}