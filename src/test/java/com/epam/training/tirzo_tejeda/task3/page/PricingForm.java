package com.epam.training.tirzo_tejeda.task3.page;

import com.epam.training.tirzo_tejeda.task3.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Map;

/**
 * Page Object class representing the Pricing Calculator Form page.
 * Extends BasePage to inherit common WebDriver and utility methods.
 */
public class PricingForm extends BasePage {

    //WebElements on the page
    @FindBy (id = "c13")
    WebElement instancesInput;

    /*OS selection*/
    @FindBy (xpath = "//div[@role=\"combobox\" and @aria-controls=\"c22\"]")
    WebElement osSelector;

    /*model*/
    @FindBy (xpath = "//label[contains(text(), \"Regular\")]")
    WebElement provisioningModelLabel;

    /*machine family*/
    @FindBy (xpath = "//div[@role=\"combobox\" and @aria-controls=\"c26\"]")
    WebElement machineFamilySelector;

    /*series*/
    @FindBy (xpath = "//div[@role=\"combobox\" and @aria-controls=\"c30\"]")
    WebElement seriesSelector;

    /*machine type*/
    @FindBy (xpath = "//div[@role=\"combobox\" and @aria-controls=\"c34\"]")
    WebElement machineTypeSelector;

    /*gpu*/
    @FindBy (xpath = "//button[@aria-label=\"Add GPUs\"]")
    WebElement addGPUsButton;

    /*gpu model*/
    @FindBy (xpath = "//*[@id=\"ow4\"]/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[23]/div/div[1]/div/div/div/div[1]")
    WebElement gpuModelSelector;

    /*gpu number*/
    @FindBy (xpath = "//*[@id=\"ow4\"]/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[24]/div/div[1]/div/div/div/div[1]")
    WebElement gpuNumberSelector;

    /*ssd*/
    @FindBy (xpath = "//*[@id=\"ow4\"]/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[27]/div/div[1]/div/div/div/div[1]")
    WebElement ssdSelector;

    /*region*/
    @FindBy (xpath = "//*[@id=\"ow4\"]/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[29]/div/div[1]/div/div/div/div[1]")
    WebElement regionSelector;

    @FindBy (xpath = "//label[@for=\"1-year\"]")
    WebElement discountSelection;

    @FindBy (xpath = "//*[contains(text(), \"Service cost updated\")]")
    WebElement serviceCostUpdate;

    @FindBy (xpath = "//button[@aria-label=\"Open Share Estimate dialog\"]")
    WebElement shareEstimateButton;

    @FindBy (xpath = "//a[contains(text(), \"Open estimate summary\")]")
    WebElement estimateSummaryButton;

    /**
     * Constructor for PricingForm Page Object.
     * @param driver The WebDriver instance to use for interacting with the page.
     */
    public PricingForm(WebDriver driver){
        super(driver); //call to BasePage constructor
        PageFactory.initElements(driver, this); //initialize WebElements
    }

    /**
     * Method to configure instance options on the Pricing Calculator form.
     * @param options Map containing configuration options for instances.
     */
    public void configureInstance(Map<String, String> options) {
        WebDriver driver = getDriver();

        waitLoadElement(driver, instancesInput);
        instancesInput.clear();
        instancesInput.sendKeys(options.get("Number of Instances"));

        osSelector.click();
        WebElement osSelection = getElementSelection(options.get("Operating System / Software"));
        waitLoadElement(driver, osSelection);
        osSelection.click();

        provisioningModelLabel.click();

        machineFamilySelector.click();
        WebElement machineFamilySelection = getElementSelection(options.get("machine_family"));
        waitLoadElement(driver, machineFamilySelection);
        machineFamilySelection.click();

        seriesSelector.click();
        WebElement seriesSelection = getElementSelection(options.get("series"));
        waitLoadElement(driver, seriesSelection);
        seriesSelection.click();

        machineTypeSelector.click();
        WebElement machineTypeSelection = getElementSelection(options.get("Machine type"));
        waitLoadElement(driver, machineTypeSelection);
        machineTypeSelection.click();
    }

    /**
     * Method to configure GPU options on the Pricing Calculator form.
     * @param options Map containing configuration options for GPUs.
     */
    public void configureGpu(Map<String, String> options) {
        WebDriver driver = getDriver();

        addGPUsButton.click();
        waitLoadElement(driver, gpuModelSelector);

        gpuModelSelector.click();
        WebElement gpuModelSelection = getElementSelection(options.get("GPU Model"));
        waitLoadElement(driver, gpuModelSelection);
        gpuModelSelection.click();

        gpuNumberSelector.click();
        WebElement gpuNumberSelection = getElementSelection(options.get("Number of GPUs"));
        waitLoadElement(driver, gpuNumberSelection);
        gpuNumberSelection.click();

        ssdSelector.click();
        WebElement ssdSelection = getElementSelection(options.get("Local SSD"));
        waitLoadElement(driver, ssdSelection);
        ssdSelection.click();

        regionSelector.click();
        WebElement regionSelection = getElementSelection(options.get("Region"));
        waitLoadElement(driver, regionSelection);
        regionSelection.click();

        discountSelection.click();
    }

    /**
     * Method to navigate to the estimate summary page.
     * Clicks on 'Share Estimate' and then on 'Open estimate summary' button.
     */
    public void goToEstimateSummary(){
        WebDriver driver = getDriver();

        super.waitLoadElement(driver, serviceCostUpdate);

        shareEstimateButton.click();
        super.waitLoadElement(driver, estimateSummaryButton);

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
