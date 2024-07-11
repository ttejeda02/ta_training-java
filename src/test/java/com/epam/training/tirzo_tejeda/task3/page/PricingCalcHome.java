package com.epam.training.tirzo_tejeda.task3.page;

import com.epam.training.tirzo_tejeda.task3.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object class representing the Pricing calculator Home Page.
 * Extends BasePage to inherit common WebDriver and utility methods.
 */
public class PricingCalcHome extends BasePage {
    private static final String URL = "https://cloud.google.com/products/calculator";

    //WebElements on the page
    @FindBy (xpath = "//span[contains(text(), \"Add to estimate\")]")
    WebElement addEstimateButton;

    @FindBy (xpath = "//h2[contains(text(), \"Compute Engine\")]")
    WebElement computeEngineButton;

    /**
     * Constructor for PricingCalcHome Page Object.
     * @param driver The WebDriver instance to use for interacting with the page.
     */
    public PricingCalcHome(WebDriver driver) {
        super(driver); //call to BasePage constructor
        driver.get(URL); //navigate to the URL of Pricing Calculator
        PageFactory.initElements(driver, this); //initialize the WebElements
    }

    /**
     * Method to navigate to the estimate form.
     * Clicks on 'Add to estimate' button and then on 'Compute Engine' section.
     */
    public void enterEstimateForm(){
        WebDriver driver = getDriver(); //get the WebDriver instance

        waitLoadElement(driver, addEstimateButton); //wait for estimate button visibility
        addEstimateButton.click();

        waitLoadElement(driver, computeEngineButton); //wait for compute engine button visibility
        computeEngineButton.click();
    }
}
