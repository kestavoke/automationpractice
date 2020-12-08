package com.automationpractice.pages;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CreateAccountPage extends PageObject {

    @Managed
    private WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "account-creation_form")
    WebElement accountCreationForm;

    @FindBy(id = "email_create")
    WebElement emailTextField;

    @FindBy(id = "uniform-id_gender1")
    WebElement MALE;

    @FindBy(id = "uniform-id_gender2")
    WebElement FEMALE;

    @FindBy(id = "customer_firstname")
    WebElement FIRST_NAME;

    @FindBy(id = "customer_lastname")
    WebElement LAST_NAME;

    @FindBy(id = "email")
    WebElement EMAIL;

    @FindBy(id = "passwd")
    WebElement PASSWORD;

    @FindBy(id = "uniform-days")
    WebElement DOB_DAY;

    @FindBy(id = "uniform-months")
    WebElement DOB_MONTH;

    @FindBy(id = "uniform-years")
    WebElement DOB_YEAR;

    @FindBy(id = "newsletter")
    WebElement newsLetter;

    @FindBy(id = "optin")
    WebElement offer;

    @FindBy(id = "company")
    WebElement COMPANY;

    @FindBy(id = "address1")
    WebElement ADDRESS;

    @FindBy(id = "city")
    WebElement CITY;

    @FindBy(id = "uniform-id_country")
    WebElement COUNTRY;

    @FindBy(id = "postcode")
    WebElement POSTCODE;

    @FindBy(id = "other")
    WebElement TEXTAREA;

    @FindBy(id = "phone_mobile")
    WebElement PHONE;

    @FindBy(id = "submitAccount")
    WebElement SUBMIT_ACCOUNT;

    public void createAccountPageIsDisplayed() {
        accountCreationForm.isDisplayed();
    }

    /**
     * Method is used to Check for the Gender in order the direct the program
     * to click based on the value input from the feature file
     */
    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("Mrs")) {
            FEMALE.click();
        } else {
            MALE.click();
        }
    }

    public void enterFirstName(String firstName) {
        FIRST_NAME.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        LAST_NAME.sendKeys(lastName);
    }

    public void clickEmail() {
        EMAIL.click();
    }

    public void enterPassword(String password) {
        PASSWORD.sendKeys(password);
    }

    public void setCompany(String company) {
        COMPANY.sendKeys(company);
    }

    public void setAddress(String address) {
        ADDRESS.sendKeys(address);
    }

    public void setCity(String city) {
        CITY.sendKeys(city);
    }

    /**
     * Method is to select an option from the list of dropdown menu based on the value from the feature file.
     * It also checks and validate the selected value
     */
    public void setState(String state) {
        int stateCount = 0;
        String[] inputState = {state};

        Select listOfState = new Select(driver.findElement(By.id("id_state")));
        List<WebElement> stateOptions = listOfState.getOptions();
        for (WebElement states : stateOptions) {
            for (int i = 0; i < inputState.length; i++) {
                if (states.getText().equalsIgnoreCase(inputState[i])) {
                    stateCount++;
                }
            }
        }
        if (stateCount == inputState.length) {
            listOfState.selectByVisibleText(state);
        } else {
            Assert.fail("Invalid " + state + " option selected");
        }
    }

    public void setPostCode(String postcode) {
        POSTCODE.sendKeys(postcode);
    }

    public void setOtherDetail(String otherDetail) {
        TEXTAREA.sendKeys(otherDetail);
    }

    public void setMobilePhone(String mobilePhone) {
        PHONE.sendKeys(mobilePhone);
    }

    public void setRegisterButton() {
        SUBMIT_ACCOUNT.click();
    }

}
