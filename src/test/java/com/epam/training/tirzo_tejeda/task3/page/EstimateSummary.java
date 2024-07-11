package com.epam.training.tirzo_tejeda.task3.page;

import com.epam.training.tirzo_tejeda.task3.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Page Object class representing the Estimate Summary page.
 * Extends BasePage to inherit common WebDriver and utility methods.
 */
public class EstimateSummary extends BasePage {

    //WebElement to do a wait
    @FindBy (xpath = "//span[contains(text(), \"Number of Instances\")]/following-sibling::span")
    WebElement numberOfInstances;

    /**
     * Constructor for EstimateSummary Page Object.
     * @param driver The WebDriver instance to use for interacting with the page.
     */
    public EstimateSummary(WebDriver driver) {
        super(driver); //call to BasePage constructor
        PageFactory.initElements(driver, this); //initialize the WebElement
    }

    /**
     * Method to switch to recently opened tab in PricingForm class.
     */
    public void switchTab(){
        WebDriver driver = getDriver();

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles()); //get the browser tabs
        driver.switchTo().window(tabs.get(1)); //switch to the second tab (the summary tab)
    }

    /**
     * Method to retrieve summary information based on provided parameters (selected options in the PricingForm methods).
     * @param parameters Array of strings representing summary information to retrieve.
     * @return Map containing summary information as key-value pairs.
     */
    public Map<String, String> getSummaryInfo(String[] parameters){

        waitLoadElement(getDriver(), numberOfInstances);
        Map<String, String> information = new HashMap<>();

        for (String parameter : parameters) {
            information.put(parameter, getElementOfTheSummary(parameter));
        }

        return information;
    }

    /**
     * Private method to retrieve text of a specific element from the summary section.
     * @param elementName Name of the element to retrieve from the summary.
     * @return Text of the specified element if found, empty string otherwise.
     */
    private String getElementOfTheSummary(String elementName){
        try {
            return getDriver().findElement(By.xpath("//span[contains(text(), \"" + elementName + "\")]/following-sibling::span")).getText();
        } catch (NoSuchElementException e) {
            return ""; //return empty string if the information of "elementName" is not found
        }
    }
}
