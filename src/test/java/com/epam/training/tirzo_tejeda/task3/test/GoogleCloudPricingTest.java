package com.epam.training.tirzo_tejeda.task3.test;

import com.epam.training.tirzo_tejeda.task3.model.GpuConfiguration;
import com.epam.training.tirzo_tejeda.task3.model.InstanceConfiguration;
import com.epam.training.tirzo_tejeda.task3.page.EstimateSummaryPage;
import com.epam.training.tirzo_tejeda.task3.page.PricingCalcHomePage;
import com.epam.training.tirzo_tejeda.task3.page.PricingFormPage;
import com.epam.training.tirzo_tejeda.task3.service.GpuConfigurationCreator;
import com.epam.training.tirzo_tejeda.task3.service.InstanceConfigurationCreator;
import org.junit.Assert;
import org.testng.annotations.Test;

/**
 * Test class for Google Cloud Pricing Calculator functionality.
 * Uses JUnit for test execution and Selenium WebDriver for browser automation.
 */
public class GoogleCloudPricingTest extends CommonConditions {

    /**
     * Test method to verify Google Cloud Pricing Calculator functionality.
     * Steps include filling out the Pricing Calculator form, configuring instance and GPU options,
     * navigating to the Estimate Summary, retrieving summary information, and asserting expected values.
     */
    @Test
    public void googleCloudPricingTest(){
        //pricing home page
        PricingCalcHomePage calcHomePage = new PricingCalcHomePage(driver);
        calcHomePage.enterEstimateForm();

        //create configuration to the instances with the creator services
        InstanceConfiguration instanceConfiguration = InstanceConfigurationCreator.createInstanceConfiguration();
        GpuConfiguration gpuConfiguration = GpuConfigurationCreator.createGpuConfiguration();

        //fill the pricing form
        PricingFormPage pricingForm = new PricingFormPage(driver);
        pricingForm.configureInstance(instanceConfiguration);
        pricingForm.configureGpu(gpuConfiguration);
        pricingForm.selectRegion(instanceConfiguration);
        pricingForm.select1YearDiscount();

        //get the cost in the form
        String formCost = pricingForm.getCostPerMonth();
        pricingForm.openEstimateSummary();

        EstimateSummaryPage estimateSummary = new EstimateSummaryPage(driver);
        estimateSummary.switchTab();

        //get the cost in the summary
        String summaryCost = estimateSummary.getServiceCostInfoText();

        //Tests
        Assert.assertEquals("Costs don't match", formCost, summaryCost);
//        Assert.assertEquals("Error: both costs are different", "$0", estimateSummary.getServiceCostInfoText()); //fail test
    }

}
