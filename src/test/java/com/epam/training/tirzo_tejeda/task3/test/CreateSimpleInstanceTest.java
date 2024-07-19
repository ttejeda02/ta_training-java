package com.epam.training.tirzo_tejeda.task3.test;

import com.epam.training.tirzo_tejeda.task3.model.InstanceConfiguration;
import com.epam.training.tirzo_tejeda.task3.page.EstimateSummaryPage;
import com.epam.training.tirzo_tejeda.task3.page.PricingCalcHomePage;
import com.epam.training.tirzo_tejeda.task3.page.PricingFormPage;
import com.epam.training.tirzo_tejeda.task3.service.InstanceConfigurationCreator;
import org.junit.Assert;
import org.testng.annotations.Test;

/**
 * Test class to verify creation of a simple instance configuration and compare it with the estimate summary.
 * Uses JUnit for test execution and Selenium WebDriver for browser automation.
 */
public class CreateSimpleInstanceTest extends CommonConditions {

    /**
     * Test method to create a simple instance configuration, fill out the pricing form, navigate to the estimate summary,
     * and verify the information matches the configured instance details.
     */
    @Test
    public void createSimpleInstance() {
        //home page
        PricingCalcHomePage pricingCalcHomePage = new PricingCalcHomePage(driver);
        pricingCalcHomePage.enterEstimateForm();

        //
        InstanceConfiguration instanceConfiguration = InstanceConfigurationCreator.createInstanceConfiguration();
        PricingFormPage pricingFormPage = new PricingFormPage(driver);
        pricingFormPage.configureInstance(instanceConfiguration);
        pricingFormPage.selectRegion(instanceConfiguration);
        pricingFormPage.openEstimateSummary();

        String firstTabTitle = pricingFormPage.getTabTitle();

        EstimateSummaryPage estimateSummaryPage = new EstimateSummaryPage(driver);
        estimateSummaryPage.switchTab();

        // Assertions
        Assert.assertNotEquals("The web page doesn't focus the tab", estimateSummaryPage.getTabTitle(), firstTabTitle);
        Assert.assertEquals("The instances don't match", instanceConfiguration.getNumberOfInstances(), estimateSummaryPage.getNumberOfInstancesInfoText());
        Assert.assertEquals("The operating system doesn't match", instanceConfiguration.getOperatingSystemSoftware(), estimateSummaryPage.getOperatingSystemInfoText());
        Assert.assertEquals("The provisioning model doesn't match", instanceConfiguration.getProvisioningModel(), estimateSummaryPage.getProvisioningModelInfoText());
        Assert.assertTrue(estimateSummaryPage.getMachineTypeInfoText().contains(instanceConfiguration.getMachineType()));
        Assert.assertEquals("The local SSD doesn't match", instanceConfiguration.getLocalSsd(), estimateSummaryPage.getLocalSSDInfoText());
        Assert.assertEquals("The region doesn't match", instanceConfiguration.getRegion(), estimateSummaryPage.getRegionInfoText());
    }
}
