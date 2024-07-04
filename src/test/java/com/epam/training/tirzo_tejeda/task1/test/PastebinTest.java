package com.epam.training.tirzo_tejeda.task1.test;

import com.epam.training.tirzo_tejeda.task1.page.Pastebin;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PastebinTest {
    WebDriver driver;

    @Before
    public void browserUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void pastebin() {
        String pastebin = new Pastebin()
                .openPage(driver)
                .fillPasteInputs("Hello from WebDriver", "helloweb")
                .createPaste();
        driver.quit();
        Assert.assertNotEquals("https://pastebin.com/", pastebin);
    }
}
