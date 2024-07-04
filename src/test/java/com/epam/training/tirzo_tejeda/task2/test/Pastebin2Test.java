package com.epam.training.tirzo_tejeda.task2.test;

import com.epam.training.tirzo_tejeda.task2.page.Pastebin2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pastebin2Test {
    WebDriver driver;

    @Before
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void pastebin2() {
        final String TITLE = "how to gain dominance among developers";
        final String CODE = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        String[] info = new Pastebin2()
                .openPage(driver)
                .fillForm(CODE, TITLE)
                .createNewPaste();
        driver.quit();
        Assert.assertTrue(info[0].contains(TITLE));
        Assert.assertEquals(info[1], "Bash");
        Assert.assertEquals(info[2], "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")");
    }
}
