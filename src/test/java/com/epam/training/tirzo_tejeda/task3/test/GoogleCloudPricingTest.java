package com.epam.training.tirzo_tejeda.task3.test;

import com.epam.training.tirzo_tejeda.task3.page.EstimateSummary;
import com.epam.training.tirzo_tejeda.task3.page.PricingCalcHome;
import com.epam.training.tirzo_tejeda.task3.page.PricingForm;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.HashMap;
import java.util.Map;

/**
 * Test class for Google Cloud Pricing Calculator functionality.
 * Uses JUnit for test execution and Selenium WebDriver for browser automation.
 */
public class GoogleCloudPricingTest {
    WebDriver driver;

    /**
     * Setup method to initialize WebDriver before each test.
     * Creates a new ChromeDriver instance and maximizes the browser window.
     */
    @Before
    public void browserSetup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    /**
     * Test method to verify Google Cloud Pricing Calculator functionality.
     * Steps include filling out the Pricing Calculator form, configuring instance and GPU options,
     * navigating to the Estimate Summary, retrieving summary information, and asserting expected values.
     */
    @Test
    public void googleCloudPricingTest(){
        PricingCalcHome calcHome = new PricingCalcHome(driver);
        calcHome.enterEstimateForm();

        Map<String, String> options = getOptions();

        PricingForm pricingForm = new PricingForm(driver);
        pricingForm.configureInstance(options);
        pricingForm.configureGpu(options);
        pricingForm.goToEstimateSummary();

        EstimateSummary estimateSummary = new EstimateSummary(driver);
        estimateSummary.switchTab();
        String[] arrayOptions = options.keySet().toArray(new String[0]);
        Map<String, String> summaryInformation = estimateSummary.getSummaryInfo(arrayOptions);

        //assertions to verify the retrieved summary information matches the expected options
        Assert.assertEquals("The instances don't match", options.get("Number of Instances"), summaryInformation.get("Number of Instances"));
        Assert.assertEquals("The operating system doesn't match", options.get("Operating System / Software"), summaryInformation.get("Operating System / Software"));
        Assert.assertEquals("The provisioning model doesn't match", options.get("Provisioning Model"), summaryInformation.get("Provisioning Model"));
        Assert.assertTrue(summaryInformation.get("Machine type").contains(options.get("Machine type")));
        Assert.assertEquals("The GPU Model doesn't match", options.get("GPU Model"), summaryInformation.get("GPU Model"));
        Assert.assertEquals("The number of GPUs doesn't match", options.get("Number of GPUs"), summaryInformation.get("Number of GPUs"));
        Assert.assertEquals("The local SSD doesn't match", options.get("Local SSD"), summaryInformation.get("Local SSD"));
        Assert.assertEquals("The region doesn't match", options.get("Region"), summaryInformation.get("Region"));
    }

    /**
     * Helper method to provide test data options for configuring the Pricing Calculator form.
     * @return Map containing configuration options as key-value pairs.
     */
    private Map<String, String> getOptions() {
        Map<String, String> options = new HashMap<>();
        options.put("Number of Instances", "4");
        options.put("Operating System / Software", "Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)");
        options.put("Provisioning Model", "Regular");
        options.put("machine_family", "General Purpose");
        options.put("series", "N1");
        options.put("Machine type", "n1-standard-8");
        options.put("GPU Model", "NVIDIA V100");
        options.put("Number of GPUs", "1");
        options.put("Local SSD", "2x375 GB");
        options.put("Region", "Netherlands (europe-west4)");
        return options;
    }

    /**
     * Teardown method to quit the WebDriver after each test.
     */
    @After
    public void quitDriver() {
        driver.quit();
    }
}
