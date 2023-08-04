package com.testUI.bravoCare.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class LoginPage {
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#login-email")
    WebElement emailInput;
    @FindBy(css = "#login-password")
    WebElement passwordInput;

    @FindBy(css = "#main-login-button")
    WebElement submitButton;

    @FindBy(css = "#login-email-error")
    WebElement emailInputErrorMessage;

    @FindBy(xpath ="#login-password-error" )
    WebElement passwordInputErrorMessage;

    public void login(String email, String password) {
        this.emailInput.sendKeys(email);
        this.passwordInput.sendKeys(password);
        submitButton.click();


    }

    public String emailInputErrorMessage() {
        return BrowserUtils.getText(emailInputErrorMessage);

    }

    public void  passwordInputErrorMessage(String expectedErrorMessage) {
        Assert.assertTrue(expectedErrorMessage.contains(BrowserUtils.getText(passwordInputErrorMessage)));

    }
}




















