package com.epam.training.tirzo_tejeda.task1.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Pastebin {
    private static final String URL = "https://pastebin.com/";
    WebDriver driver;

    @FindBy (id = "postform-text")
    private WebElement codeInput;

    @FindBy (id = "select2-postform-expiration-container")
    private WebElement expirationSelector;

    @FindBy (id = "postform-name")
    private WebElement nameInput;

    @FindBy (xpath = "//button[contains(text(), 'Create New Paste')]")
    private WebElement createButton;

    public Pastebin openPage(WebDriver driver) {
        this.driver = driver;
        driver.get(URL);
        PageFactory.initElements(driver, this);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(codeInput));
        return this;
    }

    public Pastebin fillPasteInputs(String pasteCode, String name) {
        codeInput.sendKeys(pasteCode);
        expirationSelector.click();
        driver.findElement(By.xpath("//li[contains(text(), \"10 Minutes\")]")).click();
        nameInput.sendKeys(name);
        return this;
    }

    public String createPaste() {
        createButton.click();
        return driver.getCurrentUrl();
    }
}
