package com.epam.project.framework.ui.yopmailEmailGeneration;

import com.epam.project.framework.ui.AbstractScreen;
import com.epam.project.framework.ui.auth.Login;
import com.epam.project.framework.ui.auth.Registration;
import com.epam.project.model.User;
import com.epam.project.service.UserService;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EmailGenerationPage extends AbstractScreen {
    private static final String URL = "https://yopmail.com/email-generator";

    Registration registration = new Registration();
    EmailPage emailPage = new EmailPage();
    Login login = new Login();

    @FindBy(xpath = "//button[contains(., 'Copy to clipboard')]")
    private WebElement copyToClipboard;

    @FindBy(xpath = "//button[contains(., 'Check Inbox')]")
    private WebElement checkInboxButton;

    @FindBy(xpath = "//input[@id='digit-0-field']")
    private WebElement verifyEmailCode;


    public EmailGenerationPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isScreenLoaded() {
        return false;
    }

    public EmailGenerationPage copyToClipboard() {
        wait.until(ExpectedConditions.visibilityOf(copyToClipboard)).click();
        return this;
    }

    public EmailGenerationPage clickCheckInbox() {
        wait.until(ExpectedConditions.visibilityOf(checkInboxButton)).click();
        return this;
    }

    public EmailGenerationPage enterVerifyEmailCode() {
        wait.until(ExpectedConditions.visibilityOf(verifyEmailCode)).sendKeys(Keys.CONTROL + "v");
        return this;
    }

    public void generateEmail(String password) throws InterruptedException {
        registration.clickSignUp();
        openPageInNewTab(URL);
        setWindowSize(1000, 1000);
        copyToClipboard().switchToTab(0);
        registration.register(password).switchToTab(1);
        clickRefreshButton();
        clickCheckInbox();
        emailPage.refreshButton().updateDriver(driver).copyVerifyEmailCode().switchToTab(0);
        enterVerifyEmailCode();
    }

    public void login(String email) throws InterruptedException {
        login.clickSignIn();
        login.enterEmail(email);
    }
}
