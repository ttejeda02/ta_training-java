package com.epam.training.tirzo_tejeda.task3.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Singleton class to manage WebDriver instance for browser automation.
 */
public class DriverSingleton {

    private static WebDriver driver;

    /**
     * Retrieves the WebDriver instance. If the instance is not already initialized,
     * it initializes it based on the "browser" system property (defaulting to Chrome).
     *
     * @return WebDriver instance
     */
    public static WebDriver getDriver() {
        if (driver == null) {
            switch (System.getProperty("browser")) {
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                }
                default: {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                }
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    /**
     * Quits the WebDriver instance and sets it to null.
     */
    public static void quitDriver() {
        driver.quit();
        driver = null;
    }
}