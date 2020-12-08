#@Regression
Feature: As a website user, I want to be able to submit a query using the contact us page

  Scenario Outline: Submit a query using the contact us page
    Given user navigate to the home page
    When user clicks on contact us menu
    Then user should see contact us page
    And user enters and send <subject>, <email>, <message> and upload document as email details
    When user submits the email query
    Then user should see confirmation message
    Examples:
      | subject          | email             | message              |
      | Customer service | test007@email.com | Testing contact form |