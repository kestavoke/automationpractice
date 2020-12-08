#@Regression
Feature: As an registered user, I want to be able to view the order history and send an email with the order details (select a random order number)

  Scenario Outline: view the order history and send an email with the order details
    Given user login to my account page with valid <email>, <password> credential
    When user clicks to order history and details page
    Then user should see order history page
    And user copy the order reference number
    Examples:
      | email             | password |
      | test007@email.com | Test@123 |