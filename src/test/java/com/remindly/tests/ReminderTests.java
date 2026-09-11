package com.remindly.tests;

import com.remindly.core.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReminderTests extends TestBase {
    @BeforeMethod
    public void precondition(){
        app.getMainScreen().tapOnAddReminder();
        app.getReminder().enterReminderTitle("Holiday");
    }
    @Test
    public void addReminderPositiveTest(){

        app.getReminder().saveReminder();
        Assert.assertTrue(app.getMainScreen().isReminderPresent().contains("Holiday"));

    }
    @Test
    public void addReminderDateTest(){
        app.getReminder().tapOnDateField();
        app.getReminder().swipeToMonth("future","NOV",2);
        app.getReminder().swipeDate(18);
        app.getReminder().tapOnYear();
        app.getReminder().swipeToYear("future","2026");
        app.getReminder().tapOnOk();
        app.getReminder().saveReminder();

        Assert.assertTrue(app.getMainScreen().isReminderDateTimePresent().contains("26/11/2026"));
    }
}
