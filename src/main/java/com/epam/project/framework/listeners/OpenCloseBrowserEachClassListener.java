package com.epam.project.framework.listeners;

import com.epam.project.framework.loging.Log;
import com.epam.project.framework.ui.webdriver.WebDriverSingleton;
import org.testng.IClassListener;
import org.testng.ITestClass;

import static com.epam.project.framework.properties.EnvironmentProperty.getEnv;

public class OpenCloseBrowserEachClassListener implements IClassListener {
    @Override
    public void onBeforeClass(ITestClass testClass) {
        WebDriverSingleton.getInstance().getDriver().get(getEnv());
        Log.logInfoMessage("Open browser");
    }

    @Override
    public void onAfterClass(ITestClass testClass) {
        Log.logInfoMessage("Close browser");
        WebDriverSingleton.getInstance().closeDriver();
    }
}
