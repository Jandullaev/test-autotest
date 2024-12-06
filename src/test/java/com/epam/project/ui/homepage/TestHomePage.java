package com.epam.project.ui.homepage;

import com.epam.project.framework.ui.auth.Login;
import com.epam.project.framework.ui.screens.HomeScreen;
import com.epam.project.framework.ui.yopmailEmailGeneration.EmailGenerationPage;
import com.epam.project.model.User;
import com.epam.project.service.UserService;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static com.epam.project.framework.properties.EnvironmentProperty.getEnv;

public class TestHomePage {
     HomeScreen homeScreen = new HomeScreen();
     EmailGenerationPage emailGenerationPage = new EmailGenerationPage();
     User user = UserService.withCredentialsFromProperty();
     Login login = new Login();

    @BeforeTest
    public void setUp() throws InterruptedException {
        homeScreen.openPage(getEnv());
        emailGenerationPage.generateEmail(user.getPassword());
    }

    @Test
    public void testButtonIsDisplayed() {
        Assert.assertTrue(homeScreen.isScreenLoaded(), "Home screen is not loaded");
    }

    @Test
    public void testEmailIsGenerated() {
        Assert.assertTrue(homeScreen.isStartOrderButtonDisplayed(), "Start order button is not displayed");
    }
}
