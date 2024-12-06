package com.epam.project.framework.ui.yopmailEmailGeneration;

import com.epam.project.framework.ui.AbstractScreen;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import java.time.Duration;

public class EmailPage extends AbstractScreen {
    @FindBy(id = "refresh")
    private WebElement refreshButton;
    @FindBy(xpath = "//p[text()=' Enter the following verification code when prompted: ']//following-sibling::p[1]/b")
    private WebElement verifyEmailCode;


    public EmailPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public EmailPage updateDriver(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return this;
    }
    public EmailPage refreshButton() throws InterruptedException {
        Thread.sleep(5000);
        refreshButton.click();
        return this;
    }

    public EmailPage copyVerifyEmailCode() throws InterruptedException {
        Thread.sleep(2000);
        driver.switchTo().frame("ifmail");
        String code = verifyEmailCode.getText();
        StringSelection stringSelection = new StringSelection(code);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        return this;
    }


    @Override
    public boolean isScreenLoaded() {
        return false;
    }
}
