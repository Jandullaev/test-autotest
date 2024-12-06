package com.epam.project.framework.ui.screens;

import com.epam.project.framework.ui.AbstractScreen;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductScreen extends AbstractScreen {
    @FindBy(xpath = "//button[@id='radix-:Rtb7qcq:-trigger-radix-:R5ctb7qcq:']")
    private WebElement regionSelector;
    @FindBy(xpath = "//div[@data-state='active']/div/div/div/div/span")
    private WebElement productPrice;

    public ProductScreen() {
        super();
        PageFactory.initElements(driver, this);
    }

    public void selectRegion(String regionName) {
        regionSelector.click();
        regionSelector.sendKeys(regionName);
    }

    public String getProductPriceCurrency() {
        return productPrice.getText().split(" ")[0];
    }

    @Override
    public boolean isScreenLoaded() {
        return true;
    }
}
