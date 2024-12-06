package com.epam.project.framework.ui.screens;


import com.epam.project.framework.ui.AbstractScreen;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomeScreen extends AbstractScreen {

    @FindBy(xpath = "//a[text()='Products']")
    private WebElement productsLink;

    @FindBy(xpath = "//a[text()='About Us']")
    private WebElement aboutLink;

    @FindBy(xpath = "//a[text()='Contact']")
    private WebElement contactLink;

    @FindBy(xpath = "//a[text()='Report']")
    private WebElement reportLink;

    @FindBy(xpath = "//h1[contains(text(), 'Where every scoop is a delight')]")
    private WebElement headlineText;

    @FindBy(xpath = "//a[contains(text(), 'Start Order')]")
    private WebElement startOrderButton;

    @FindBy(xpath = "//button/span")
    private WebElement toggleThemeButton;

    public HomeScreen() {
        super();
        PageFactory.initElements(driver, this);
    }


    @Override
    public boolean isScreenLoaded() {
        return headlineText.isDisplayed();
    }

    public ProductScreen navigateToProductsPage() {
        productsLink.click();
        return new ProductScreen();
    }

    public AboutUsScreen navigateToAboutPage() {
        aboutLink.click();
        return new AboutUsScreen();
    }

    public void navigateToContactPage() {
        contactLink.click();
    }

    public void navigateToReportPage() {
        reportLink.click();
    }

    public void clickStartOrderButton() {
        startOrderButton.click();
    }

    public boolean isStartOrderButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(startOrderButton)).isDisplayed();
    }

    public void clickToggleThemeButton() {
        toggleThemeButton.click();
    }
}
