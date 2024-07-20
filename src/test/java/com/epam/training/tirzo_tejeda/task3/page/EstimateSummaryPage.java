package com.epam.training.tirzo_tejeda.task3.page;

import com.epam.training.tirzo_tejeda.task3.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;

/**
 * Page Object class representing the Estimate Summary page.
 * Extends BasePage to inherit common WebDriver and utility methods.
 */
public class EstimateSummaryPage extends BasePage {

    //WebElement to do a wait
    @FindBy (xpath = "//span[contains(text(), \"Number of Instances\")]/following-sibling::span")
    WebElement numberOfInstances;

    @FindBy (xpath = "//span[contains(text(), \"Operating System / Software\")]/following-sibling::span")
    WebElement operatingSystem;

    @FindBy (xpath = "//span[contains(text(), \"Provisioning Model\")]/following-sibling::span")
    WebElement provisioningModel;

    @FindBy (xpath = "//span[contains(text(), \"Machine type\")]/following-sibling::span")
    WebElement machineType;

    @FindBy (xpath = "//span[contains(text(), \"GPU Model\")]/following-sibling::span")
    WebElement gpuModel;

    @FindBy (xpath = "//span[contains(text(), \"Number of GPUs\")]/following-sibling::span")
    WebElement numberOfGPUs;

    @FindBy (xpath = "//span[contains(text(), \"Local SSD\")]/following-sibling::span")
    WebElement localSSD;

    @FindBy (xpath = "//span[contains(text(), \"Region\")]/following-sibling::span")
    WebElement region;

    @FindBy (xpath = "//h4[following-sibling::*[contains(text(), \"/ mo\")]]")
    WebElement serviceCost;

    /**
     * Constructor for EstimateSummary Page Object.
     * @param driver The WebDriver instance to use for interacting with the page.
     */
    public EstimateSummaryPage(WebDriver driver) {
        super(driver); //call to BasePage constructor
        PageFactory.initElements(driver, this); //initialize the WebElement
    }

    /**
     * Method to switch to recently opened tab in PricingForm class.
     */
    public void switchTab() {
        WebDriver driver = getDriver();

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles()); //get the browser tabs
        driver.switchTo().window(tabs.get(1)); //switch to the second tab (the summary tab)

        logger.info("The focus of the tab has been switched to the summary page");
    }

    public String getNumberOfInstancesInfoText() {
        return numberOfInstances.getText();
    }

    public String getOperatingSystemInfoText() {
        return operatingSystem.getText();
    }

    public String getProvisioningModelInfoText() {
        return provisioningModel.getText();
    }

    public String getMachineTypeInfoText() {
        return machineType.getText();
    }

    public String getGpuModelInfoText() {
        return gpuModel.getText();
    }

    public String getNumberOfGPUsInfoText() {
        return numberOfGPUs.getText();
    }

    public String getLocalSSDInfoText() {
        return localSSD.getText();
    }

    public String getRegionInfoText() {
        return region.getText();
    }

    public String getServiceCostInfoText() {
        waitLoadElement(getDriver(), localSSD);

        return serviceCost.getText();
    }
}
