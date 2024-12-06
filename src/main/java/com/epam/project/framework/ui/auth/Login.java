package com.epam.project.framework.ui.auth;

import com.epam.project.framework.ui.AbstractScreen;
import com.epam.project.framework.ui.yopmailEmailGeneration.EmailGenerationPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Login extends AbstractScreen {

    @FindBy(xpath = "//button[text()='Sign in']")
    private WebElement signInButton;

    @FindBy(xpath = "//input[@id='identifier-field']")
    private WebElement emailField;

    @FindBy(xpath = "//button[contains(., 'Continue')]")
    private WebElement continueButton;

    public Login() {
        super();
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isScreenLoaded() {
        return false;
    }

    public EmailGenerationPage clickSignIn() throws InterruptedException {
        Thread.sleep(2000);
        signInButton.click();
        return new EmailGenerationPage();
    }

    public Login clickContinue() {
        wait.until(ExpectedConditions.visibilityOf(continueButton)).click();
        return this;
    }

    public boolean verifyButtonIsDisplayed() {
        return continueButton.isDisplayed();
    }

    public String getEmail() {
        return emailField.getAttribute("value");
    }

    public Login enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailField)).sendKeys(email);
        return this;
    }
}
