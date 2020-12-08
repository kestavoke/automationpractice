package com.automationpractice.steps;

import com.automationpractice.pages.AuthenticationPage;
import com.automationpractice.pages.CreateAccountPage;
import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.MyAccountPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateAccountSteps {

    /**
     * Declaring Objects of the Class reusable Classes to be implemented in the Step definition Class
     */
    private HomePage homePage;
    private AuthenticationPage authenticationPage;
    private CreateAccountPage accountPage;
    private MyAccountPage myAccountPage;

    @Given("^user is on practice automation homepage$")
    public void practiceAutomationHomepage() {
        homePage.applicationHomePage();
    }

    @When("^the page is fully loaded$")
    public void ensurePageIsLoaded() {
        homePage.ensurePageLoad();
    }

    @Then("^user should see the Page Title displayed$")
    public void validatePageTitle() {
        homePage.validatePageTitle();
    }

    @When("^user clicks sign in option$")
    public void signInOption() {
        homePage.signInOption();
        authenticationPage.authenticationPageIsDisplayed();
    }

    @And("^user enters email (.*) address and clicks create an account option$")
    public void enterEmailID(String email) {
        authenticationPage.enterEmailAddress(email);
        authenticationPage.createAnAccountOption();
    }

    @Then("^create an account Page is displayed$")
    public void createAccountPageIsDisplayed() {
        accountPage.createAccountPageIsDisplayed();
    }

    @And("^user enters (.*), (.*), (.*) and (.*) as personal information$")
    public void entersPersonalInformation(String gender, String firstname, String lastname, String password) {
        accountPage.selectGender(gender);
        accountPage.enterFirstName(firstname);
        accountPage.enterLastName(lastname);
        accountPage.clickEmail();
        accountPage.enterPassword(password);
    }

    @And("^user enters (.*), (.*), (.*), (.*), (.*), (.*), and (.*) as address information$")
    public void entersAddressInformation(String company, String address, String city, String state, String postcode, String otherDetail, String mobilePhone) {
        accountPage.setCompany(company);
        accountPage.setAddress(address);
        accountPage.setCity(city);
        accountPage.setState(state);
        accountPage.setPostCode(postcode);
        accountPage.setOtherDetail(otherDetail);
        accountPage.setMobilePhone(mobilePhone);
    }

    @When("^user submit the information$")
    public void clickRegisterOption() {
        accountPage.setRegisterButton();
    }

    @Then("^user should login to my account page$")
    public void validateUserIsLoggedIn() {
        myAccountPage.validateUserIsLoggedIn();
    }

    @Then("^user clicks on sign out option$")
    public void signOutOption() {
        myAccountPage.logOutButton();
    }

    @Then("^user should be logged out successfully$")
    public void validateUserIsLoggedOut() {
        homePage.signInOption();
    }

}
