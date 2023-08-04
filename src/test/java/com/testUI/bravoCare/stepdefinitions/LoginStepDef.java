package com.testUI.bravoCare.stepdefinitions;

import com.testUI.bravoCare.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import utils.DriverHelper;

public class LoginStepDef {
    WebDriver driver = DriverHelper.getDriver();

    LoginPage loginPage = new LoginPage(driver);


    @When("User provides {string},{string} and clicks login button")
    public void userProvideAndClicksLoginButton(String email, String password) {
        loginPage.login(email,password);

    }

    @Then("User validates {string}")
    public void userValidates(String expectedURL) {
        Assert.assertEquals(expectedURL,driver.getCurrentUrl());


    }

    @Then("User validates the message {string}")
    public void userValidatesTheMessage(String expectedErrorMessage) throws InterruptedException {
        Thread.sleep(2000);
     loginPage.passwordInputErrorMessage(expectedErrorMessage);

    }
    @Then("User validates the message 'Sorry the password isn't right.'")
    public void user_validates_the_message_sorry_the_password_isn_t_right() {

    }
}