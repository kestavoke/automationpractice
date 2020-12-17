#@Regression
Feature: Verify the page title and create a new user account
  As a new user, I want ot be able to verify the page title, provide user details and register via the website.

  Scenario Outline: Get page title and Register a new user
    Given user is on practice automation homepage
    When the page is fully loaded
    Then user should see the Page Title displayed
    When user clicks sign in option
    And user enters email <email> address and clicks create an account option
    Then create an account Page is displayed
    And user enters <title>, <firstName>, <lastName> and <password> as personal information
    And user enters <company>, <address>, <city>, <state>, <zipcode>, <otherDetail>, and <mobilePhone> as address information
    When user submit the information
    Then user should login to my account page
    When user clicks on sign out option
    Then user should be logged out successfully
  Examples:
    |title|firstName |lastName|email       |password|company|address     |city|state   |zipcode|otherDetail  |mobilePhone|
    |Mr   |Jane|Smith|test-email1@email.com|Test@123|a&b pty|12 road     |LA  |Ohio    |10001  | More details| 0987654321|
    |Mrs  |Brown|Bush|test-email2@email.com|Test@098|Uber   |15 Rand road|LA  |Alabama |10001  | More details| 0987987541|