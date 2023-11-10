@authentication
Feature: Authentication with Gmail account
  
  As a user, I would like to log in with Gmail account

  @success_login
  Scenario: Authentication
    Given Navigate to Gmail login page
    When the user enter Login in username field
    And the user enter Password in password field
    When the user clicks on connection button
    Then the user is redirected to home page


