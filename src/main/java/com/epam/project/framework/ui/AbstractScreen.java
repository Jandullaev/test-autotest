package com.epam.project.framework.ui;

import static com.epam.project.framework.loging.Log.logInfoMessage;

import com.epam.project.framework.ui.webdriver.WebDriverSingleton;
import java.time.Duration;
import java.util.ArrayList;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractScreen {
    public static final int DEFAULT_TIME_OUT_FOR_PAGE_REFRESH = 30;
    public static final String PLACEHOLDER_CSS_PROPERTY = "placeholder";
    protected WebDriver driver;
    protected WebDriverWait wait;

    public AbstractScreen() {
        this.driver = WebDriverSingleton.getInstance().getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIME_OUT_FOR_PAGE_REFRESH));
    }

    public abstract boolean isScreenLoaded();

    public void clickBackButton() {
        logInfoMessage("Pressing browser's 'Back' button");
        driver.navigate().back();
    }

    public void clickRefreshButton() {
        logInfoMessage("Pressing browser's 'Refresh' button");
        driver.navigate().refresh();
    }

    public void openPage(String url) {
        logInfoMessage("Opening page: %s", url);
        driver.get(url);
    }

    public void openPageInNewTab(String url) {
        logInfoMessage("Opening page in new tab: %s", url);
        ((JavascriptExecutor) driver).executeScript("window.open()");
        switchToTab(1);
        openPage(url);
    }

    public void switchToTab(int tabIndex) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        logInfoMessage("Switching to tab with index: %d", tabIndex);
        driver.switchTo().window(tabs.get(tabIndex));
    }

    public void setWindowSize(int width, int height) {
        logInfoMessage("Setting window size to: %dx%d", width, height);
        driver.manage().window().setSize(new Dimension(width, height));
    }

    public void closeBrowser() {
        logInfoMessage("Closing browser");
        WebDriverSingleton.getInstance().closeDriver();
    }
}
