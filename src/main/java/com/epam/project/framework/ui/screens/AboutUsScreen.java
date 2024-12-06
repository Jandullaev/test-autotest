package com.epam.project.framework.ui.screens;

import com.epam.project.framework.ui.AbstractScreen;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutUsScreen extends AbstractScreen {

    @FindBy(xpath = "//h2[text()='Meet our team']")
    private WebElement aboutUsPage;

    public AboutUsScreen() {
        super();
        PageFactory.initElements(driver, this);
    }

    public boolean isScreenLoaded() {
        return aboutUsPage.isDisplayed();
    }
}
