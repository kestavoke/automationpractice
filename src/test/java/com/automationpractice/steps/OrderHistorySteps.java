package com.automationpractice.steps;

import com.automationpractice.pages.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.IOException;

public class OrderHistorySteps {

    /**
     * Declaring Objects of the Class reusable Classes to be implemented in the Step definition Class
     * */
    private HomePage homePage;
    private AuthenticationPage authenticationPage;
    private MyAccountPage myAccountPage;
    private OrderHistoryPage orderHistoryPage;

    @Given("^user login to my account page with valid (.*), (.*) credential$")
    public void homepage(String username, String password) {
        homePage.applicationHomePage();
        homePage.signInOption();
        authenticationPage.userLogin(username, password);
    }

    @When("^user clicks to order history and details page$")
    public void orderHistoryMenu() {
        myAccountPage.orderHistoryMenu();
    }

    @Then("^user should see order history page$")
    public void orderHistoryPage() {
        orderHistoryPage.validateOrderHistoryPage();
    }

    @Then("^user copy the order reference number$")
    public void orderHistoryTable() throws IOException {
        orderHistoryPage.loopThroughMyOrderTable();
        orderHistoryPage.getOrderInformation("OrderNumber");
    }






}
