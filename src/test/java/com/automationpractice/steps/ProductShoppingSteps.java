package com.automationpractice.steps;

import com.automationpractice.pages.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.pages.PageObject;

public class ProductShoppingSteps extends PageObject {

    /**
     * Declaring Objects of the Class reusable Classes to be implemented in the Step definition Class
     * */
    private HomePage homePage;
    private ProductCategoriesPage categoryPage;
    private ShoppingCartSummaryPage cartSummaryPage;
    private AuthenticationPage authenticationPage;
    private AddressPage addressPage;
    private ShippingPage shippingPage;
    private PaymentPage paymentPage;
    private OrderConfirmationPage confirmOrder;
    private MyAccountPage myAccountPage;

    @Given("^user is on the store homepage$")
    public void homepage() {
        homePage.applicationHomePage();
    }

    @And("^user add tShirt items to shopping cart with (.*) quantities$")
    public void tShirtCategory(String qty) {
        categoryPage.tSHIRT_Category();
        categoryPage.clickMoreOption();
        categoryPage.add_Item_Qty(qty);
        categoryPage.addItemToCart();
    }

    @And("^user click on continue shopping option to add more items$")
    public void continueShopping() {
        categoryPage.continueShoppingOption();
    }

    @And("^user add (.*) quantities of dresses to cart$")
    public void dressCategory(String qty) {
        categoryPage.DRESS_Category();
        categoryPage.clickMoreOption();
        categoryPage.add_Item_Qty(qty);
        categoryPage.addItemToCart();
    }

    @And("^user proceed to check out$")
    public void checkOutOption() {
        categoryPage.proceedToCheckOut();
    }

    @And("^user should see the shopping cart summary page$")
    public void shoppingCartPage() {
        cartSummaryPage.proceedToCheckOut();
    }


    @And("^user enters login credentials (.*), (.*)$")
    public void loginPage(String username, String password) {
        authenticationPage.userLogin(username, password);
    }

    @And("^user continue to check out$")
    public void proceedToCheckOut() {
        addressPage.proceedToCheckOut();
    }

    @And("^user accept terms and conditions$")
    public void termsAndConditions() {
        shippingPage.termsAndConditions();
        shippingPage.proceedToCheckOut();
    }

    @When("^user selects payment option and confirm order$")
    public void orderConfirmationAndPayment() {
        paymentPage.paymentOption();
        paymentPage.confirmOrder();
    }

    @Then("^user should see order confirmation message$")
    public void confirmOrderMsg() {
        confirmOrder.confirmOrderMSG();
    }

    @When("^user clicks logout option$")
    public void userLogOut() {
        myAccountPage.logOutButton();
    }

    @Then("^user should be be logged out successfully$")
    public void confirmLogOut() {
        homePage.signInOption();
    }









}
