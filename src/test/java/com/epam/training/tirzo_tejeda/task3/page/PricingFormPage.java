package com.epam.training.tirzo_tejeda.task3.page;

import com.epam.training.tirzo_tejeda.task3.base.BasePage;
import com.epam.training.tirzo_tejeda.task3.model.GpuConfiguration;
import com.epam.training.tirzo_tejeda.task3.model.InstanceConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object class representing the Pricing Calculator Form page.
 * Extends BasePage to inherit common WebDriver and utility methods.
 */
public class PricingFormPage extends BasePage {

    // WebElements on the page
    @FindBy(id = "c13")
    WebElement instancesInput;

    /*OS selection*/
    @FindBy(xpath = "//div[@role=\"combobox\" and @aria-controls=\"c22\"]")
    WebElement osSelector;

    /*model*/
    @FindBy(xpath = "//label[contains(text(), \"Regular\")]")
    WebElement provisioningModelLabel;

    /*machine family*/
    @FindBy(xpath = "//div[@role=\"combobox\" and @aria-controls=\"c26\"]")
    WebElement machineFamilySelector;

    /*series*/
    @FindBy(xpath = "//div[@role=\"combobox\" and @aria-controls=\"c30\"]")
    WebElement seriesSelector;

    /*machine type*/
    @FindBy(xpath = "//div[@role=\"combobox\" and @aria-controls=\"c34\"]")
    WebElement machineTypeSelector;

    /*gpu*/
    @FindBy(xpath = "//button[@aria-label=\"Add GPUs\"]")
    WebElement addGPUsButton;

    /*gpu model*/
    @FindBy(xpath = "//*[@id=\"ow4\"]/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[23]/div/div[1]/div/div/div/div[1]")
    WebElement gpuModelSelector;

    /*gpu number*/
    @FindBy(xpath = "//*[@id=\"ow4\"]/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[24]/div/div[1]/div/div/div/div[1]")
    WebElement gpuNumberSelector;

    /*ssd*/
    @FindBy(xpath = "//div[span//span[text()=\"0\"]]")
    WebElement ssdSelector;

    /*region*/
    @FindBy(xpath = "//div[span//span[text()=\"Iowa (us-central1)\"]]")
    WebElement regionSelector;

    @FindBy(xpath = "//label[contains(text(), \"1 year\")]")
    WebElement discountSelection;

    @FindBy(xpath = "//*[contains(text(), \"Service cost updated\")]")
    WebElement serviceCostUpdate;

    @FindBy(xpath = "//span[following-sibling::*[contains(text(), \"/ month\")]]")
    WebElement serviceCost;

    @FindBy(xpath = "//button[@aria-label=\"Open Share Estimate dialog\"]")
    WebElement shareEstimateButton;

    @FindBy(xpath = "//a[contains(text(), \"Open estimate summary\")]")
    WebElement estimateSummaryButton;

    /**
     * Constructor for PricingForm Page Object.
     *
     * @param driver The WebDriver instance to use for interacting with the page.
     */
    public PricingFormPage(WebDriver driver) {
        super(driver); // call to BasePage constructor
        PageFactory.initElements(driver, this); // initialize WebElements
    }

    /**
     * Method to configure instance options on the Pricing Calculator form.
     *
     * @param configuration InstanceConfiguration object containing configuration options for instances.
     */
    public void configureInstance(InstanceConfiguration configuration) {
        WebDriver driver = getDriver();

        waitLoadElement(driver, instancesInput);
        instancesInput.clear();
        instancesInput.sendKeys(configuration.getNumberOfInstances());

        osSelector.click();
        WebElement osSelection = getElementSelection(configuration.getOperatingSystemSoftware());
        waitLoadElement(driver, osSelection);
        osSelection.click();

        provisioningModelLabel.click();

        machineFamilySelector.click();
        WebElement machineFamilySelection = getElementSelection(configuration.getMachineFamily());
        waitLoadElement(driver, machineFamilySelection);
        machineFamilySelection.click();

        seriesSelector.click();
        WebElement seriesSelection = getElementSelection(configuration.getSeries());
        waitLoadElement(driver, seriesSelection);
        seriesSelection.click();

        machineTypeSelector.click();
        WebElement machineTypeSelection = getElementSelection(configuration.getMachineType());
        waitLoadElement(driver, machineTypeSelection);
        machineTypeSelection.click();

        ssdSelector.click();
        WebElement ssdSelection = getElementSelection(configuration.getLocalSsd());
        waitLoadElement(driver, ssdSelection);
        ssdSelection.click();
    }

    /**
     * Method to configure GPU options on the Pricing Calculator form.
     *
     * @param configuration GpuConfiguration object containing configuration options for GPUs.
     */
    public void configureGpu(GpuConfiguration configuration) {
        WebDriver driver = getDriver();

        addGPUsButton.click();
        waitLoadElement(driver, gpuModelSelector);

        gpuModelSelector.click();
        WebElement gpuModelSelection = getElementSelection(configuration.getGpuModel());
        waitLoadElement(driver, gpuModelSelection);
        gpuModelSelection.click();

        gpuNumberSelector.click();
        WebElement gpuNumberSelection = getElementSelection(configuration.getNumberOfGpus());
        waitLoadElement(driver, gpuNumberSelection);
        gpuNumberSelection.click();
    }

    /**
     * Method to select a region on the Pricing Calculator form.
     *
     * @param configuration InstanceConfiguration object containing region information.
     */
    public void selectRegion(InstanceConfiguration configuration) {
        WebDriver driver = getDriver();

        regionSelector.click();
        WebElement regionSelection = getElementSelection(configuration.getRegion());
        waitLoadElement(driver, regionSelection);
        regionSelection.click();
    }

    /**
     * Method to select the 1 year discount option on the Pricing Calculator form.
     */
    public void select1YearDiscount() {
        discountSelection.click();
    }

    /**
     * Method to retrieve the cost per month from the Pricing Calculator form.
     * @return The cost per month as a string.
     */
    public String getCostPerMonth() {
        waitLoadElement(getDriver(), serviceCostUpdate);
        return serviceCost.getText();
    }

    /**
     * Method to navigate to the estimate summary page.
     * Clicks on 'Share Estimate' and then on 'Open estimate summary' button.
     */
    public void openEstimateSummary() {
        WebDriver driver = getDriver();

        waitLoadElement(driver, serviceCostUpdate);
        shareEstimateButton.click();
        waitLoadElement(driver, estimateSummaryButton);
        estimateSummaryButton.click();
    }

    /**
     * Private utility method to find and return a WebElement based on its text.
     * @param selection Text to match for finding the WebElement.
     * @return WebElement found based on the selection text that is used in the xpath.
     */
    private WebElement getElementSelection(String selection) {
        return getDriver().findElement(By.xpath("//li[.//span[text() = \"" + selection + "\"]]"));
    }

}
