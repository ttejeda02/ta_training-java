package com.epam.training.tirzo_tejeda.task2.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Pastebin2 {
    private static final String PASTEBIN_URL = "https://pastebin.com/";
    WebDriver driver;

    @FindBy (id = "postform-text")
    WebElement codeInput;

    @FindBy (id = "select2-postform-format-container")
    WebElement syntaxSelector;

    @FindBy (id = "select2-postform-expiration-container")
    WebElement expirationSelector;

    @FindBy (id = "postform-name")
    WebElement nameInput;

    @FindBy (xpath = "//button[contains(text(), \"Create New Paste\")]")
    WebElement createButton;

    public Pastebin2 openPage(WebDriver driver){
        this.driver = driver;
        driver.get(PASTEBIN_URL);
        PageFactory.initElements(driver, this);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(codeInput));

        return this;
    }

    public Pastebin2 fillForm(String code, String title){
        codeInput.sendKeys(code);

        syntaxSelector.click();
        driver.findElement(By.xpath("//li[contains(text(), \"Bash\")]")).click();
        expirationSelector.click();
        driver.findElement(By.xpath("//li[contains(text(), \"10 Minutes\")]")).click();

        nameInput.sendKeys(title);

        return this;
    }

    public String[] createNewPaste(){
        createButton.click();
        String[] info = new String[3];
        info[0] = driver.getTitle();
        info[1] = driver.findElement(By.xpath("//div[@class=\"left\"]/a[1]")).getText();
        info[2] = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div[4]/div[2]/ol/li[2]/div")).getText();

        return info;
    }
}
