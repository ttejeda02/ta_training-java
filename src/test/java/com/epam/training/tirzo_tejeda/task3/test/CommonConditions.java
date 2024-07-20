package com.epam.training.tirzo_tejeda.task3.test;

import com.epam.training.tirzo_tejeda.task3.driver.DriverSingleton;
import com.epam.training.tirzo_tejeda.task3.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class CommonConditions {
    protected WebDriver driver;

    /**
     * Setup method to initialize WebDriver before each test.
     * Creates a new ChromeDriver instance and maximizes the browser window.
     */
    @BeforeMethod()
    public void setUpBrowser(){
        driver = DriverSingleton.getDriver();
    }

    /**
     * Teardown method to quit the WebDriver after each test.
     */
    @AfterMethod()
    public void quitBrowser(){
        DriverSingleton.quitDriver();
    }
}
