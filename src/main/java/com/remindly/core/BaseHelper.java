package com.remindly.core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

public class BaseHelper {

    protected AppiumDriver driver;
    TouchAction touchAction;

    public BaseHelper(AppiumDriver driver) {//Generate -> constructor
        this.driver = driver;
        touchAction = new TouchAction<>((PerformsTouchActions) driver);
    }
    public boolean isElementPresent(By locator){
        return driver.findElements(locator).size()>0;
    }

    public void type(By locator, String text) {
        if(text != null) {
            tap(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
        driver.navigate().back();
    }

    public void tap(By locator) {
        driver.findElement(locator).click();
    }

    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String isTextPresent(By locator) {
        return driver.findElement(locator).getText();
    }

    public void swipe(double start, double stop) {
        Dimension dimension = driver.manage().window().getSize();
        int x = dimension.getWidth()/2;
        int startY = (int) (dimension.getHeight() * start);
        int stopY = (int) (dimension.getHeight() * stop);

        touchAction.longPress(PointOption.point(x,startY))
                .moveTo(PointOption.point(x,stopY))
                .release().perform();
    }
}
