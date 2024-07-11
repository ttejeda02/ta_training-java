package com.epam.training.tirzo_tejeda.task3.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * BasePage class provides common functionalities and WebDriver management for Page Objects.
 */
public class BasePage {
    WebDriver driver;

    /**
     * Constructor for BasePage.
     * @param driver The WebDriver instance to be used by the Page Object.
     */
    public BasePage(WebDriver driver) {
        this.driver = driver; //initialize the WebDriver instance
    }

    /**
     * Get the current WebDriver instance.
     * @return The current WebDriver instance.
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Utility method to wait for an element to be visible on the page.
     * @param driver        The WebDriver instance to use for waiting.
     * @param elementToWait The WebElement to wait for its visibility.
     */
    protected void waitLoadElement(WebDriver driver, WebElement elementToWait) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(elementToWait));
    }
}
