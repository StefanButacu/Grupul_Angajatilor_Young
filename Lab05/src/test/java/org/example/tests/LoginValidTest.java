package org.example.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.example.steps.serenity.LoginSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/java/org/example/utils/validLoginData.csv")
public class LoginValidTest {
    @Managed(uniqueSession = true, driver = "firefox")
    public WebDriver webDriver;

    private String email;
    private String password;

    @Steps
    public LoginSteps loginSteps;

    @Test
    public void loginTest() {
        loginSteps.welcomeIsVisibleAfterLogin(email, password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
