package com.automationpractice.pages;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AuthenticationPage extends PageObject {

    @Managed
    private WebDriver driver;

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Declare WebElements at the Class level
     * */
    @FindBy(id = "SubmitCreate")
    WebElement submitCreate;

    @FindBy(id = "email_create")
    WebElement emailTextField;

    @FindBy(id = "create_account_error")
    WebElement createAccountError;

    @FindBy(id = "email")
    WebElement EMAIL;

    @FindBy(id = "passwd")
    WebElement PASSWD;

    @FindBy(id = "SubmitLogin")
    WebElement SIGN_IN;

    public void authenticationPageIsDisplayed() {
        submitCreate.isDisplayed();
    }

    public void enterEmailAddress(String email_id) {
        emailTextField.sendKeys(email_id);
    }

   /**
    * Methods to click on create account option and check if the Email ID
    * is already registered on the system
    * */
    public void createAnAccountOption() {
        submitCreate.click();
    }

    public void userLogin(String username, String pass) {
        EMAIL.sendKeys(username);
        PASSWD.sendKeys(pass);
        SIGN_IN.click();
    }
}
