package com.epam.training.tirzo_tejeda.task2.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pastebin {
    private static final String PASTEBIN_URL = "https://pastebin.com/";
    WebDriver driver;

    @FindBy (id = "postform-text")
    WebElement codeInput;

    @FindBy (id = "select2-postform-format-container")
    WebElement syntaxSelector;

    @FindBy (id = "")

    public Pastebin openPage(WebDriver driver){
        this.driver = driver;
        driver.get(PASTEBIN_URL);
        PageFactory.initElements(driver, this);
    }
}
