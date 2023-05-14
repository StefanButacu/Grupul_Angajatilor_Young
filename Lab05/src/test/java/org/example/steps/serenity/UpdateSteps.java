package org.example.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.example.pages.LoginPage;
import org.example.pages.ProfilePage;
import org.example.utils.WebConstants;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class UpdateSteps {
    LoginPage loginPage;
    ProfilePage profilePage;

    @Step
    public void successIsVisibleAfterUpdate(String firstName, WebDriver webDriver) {
        loginPage.open();
        loginPage.login(WebConstants.email, WebConstants.password);
        assertTrue(loginPage.welcomeIsVisible());

        profilePage.open();
        profilePage.update(firstName, webDriver);
        assertTrue(profilePage.successIsVisible());
    }
}
