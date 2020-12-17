@Regression
Feature: As an existing user, I want to be able to Add random items to the cart
  with random quantities and checkout

  Scenario Outline: Add items to the cart and checkout
    Given user is on the store homepage
    And user add tShirt items to shopping cart with <s_qty> quantities
    And user click on continue shopping option to add more items
    And user add <d_qty> quantities of dresses to cart
    When user proceed to check out
    Then user should see the shopping cart summary page
    And user enters login credentials <email>, <password>
    And user continue to check out
    And user accept terms and conditions
    When user selects payment option and confirm order
    Then user should see order confirmation message
    When user clicks logout option
    Then user should be be logged out successfully
  Examples:
    |s_qty|d_qty|email            |password|
    |3    |2    |test007@email.com|Test@123|
