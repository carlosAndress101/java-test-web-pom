package com.unac.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.UUID;

public class Action {

    private static WebElement getWebElement(WebDriver myBrowser, By target) {
        return myBrowser.findElement(target);
    }

    public static void navigateUrl(WebDriver myBrowser, String uri) {
        myBrowser.navigate().to(uri);
    }

    public static void clickElement(WebDriver myBrowser, By target) {
        getWebElement(myBrowser, target).click();
    }

    public static void send(WebDriver myBrowser, By target, String dt) {
        getWebElement(myBrowser, target).sendKeys(dt);
    }

    public static String generateId(String userId) {
        return userId + UUID.randomUUID().toString().substring(0, 8);
    }
}
