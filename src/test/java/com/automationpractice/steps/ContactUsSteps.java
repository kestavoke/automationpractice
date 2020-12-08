package com.automationpractice.steps;

import com.automationpractice.pages.ContactUsPage;
import com.automationpractice.pages.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ContactUsSteps {

    /**
     * Method used to READ file location on the project directory
     * */
    public static final String fileDir = "OrderReference";
    File fileLocation = new File(fileDir);
    String filePath = fileLocation.getAbsolutePath() + File.separator + "OrderNumber.txt";

    private String orderID;

    /**
     * Method used to READ Order Reference text file location on the project directory
     * */
    public String orderReader() {
        try{
            File file = new File("OrderReference" + File.separator + "OrderNumber.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            orderID = reader.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }  return orderID;

    }

    /**
     * Declaring Objects of the Class reusable Classes to be implemented in the Step definition Class
     * */
    private HomePage homePage;
    private ContactUsPage contactUsPage;

    @Given("^user navigate to the home page$")
    public void homepage() {
        homePage.applicationHomePage();
    }

    @When("^user clicks on contact us menu$")
    public void contactUsMenu() {
        homePage.CONTACT_US();
    }

    @When("^user should see contact us page$")
    public void validateContactUsPage() {
        contactUsPage.submitButton();
    }

    @And("^user enters and send (.*), (.*), (.*) and upload document as email details$")
    public void sendEmailForm(String subject, String email, String msg) throws InterruptedException, AWTException {
        contactUsPage.chooseSubjectHeading(subject);
        contactUsPage.enterEmailId(email);
        contactUsPage.enterOrderId(orderReader());
        contactUsPage.uploadFile(filePath);
        contactUsPage.enterMessage(msg);
    }

    @When("^user submits the email query$")
    public void sendEmailButton() {
        contactUsPage.sendButton();
    }

    @Then("^user should see confirmation message$")
    public void validateEmailConfirmation() {
        contactUsPage.conf_message();
    }



}
