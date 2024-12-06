package com.epam.project.framework.ui.auth;

import com.epam.project.framework.ui.AbstractScreen;
import com.epam.project.framework.ui.yopmailEmailGeneration.EmailGenerationPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

import static com.epam.project.utils.StringUtils.generateRandomPassword;

public class Registration extends AbstractScreen {

    @FindBy(xpath = "//input[@id='emailAddress-field']")
    private WebElement emailAddressField;

    @FindBy(xpath = "//input[@id='password-field']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[contains(., 'Continue')]")
    private WebElement continueButton;

    @FindBy(xpath = "//button[text()='Sign up']")
    private WebElement signUpButton;


    ArrayList<String> user = new ArrayList<>();

    public Registration() {
        super();
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isScreenLoaded() {
        return false;
    }

    public void enterEmailAddress() {
        emailAddressField.sendKeys(Keys.CONTROL + "v");
        String email = emailAddressField.getAttribute("value");
        user.add(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
        user.add(password);
    }

    public void clickCreateAccountButton() {
        continueButton.click();
    }

    public EmailGenerationPage clickSignUp() {
        wait.until(ExpectedConditions.visibilityOf(signUpButton)).click();
        return new EmailGenerationPage();
    }

    public EmailGenerationPage register(String password) {
        enterEmailAddress();
        enterPassword(password);
        clickCreateAccountButton();
        return new EmailGenerationPage();
    }
}
