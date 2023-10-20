Feature: Saucedemo logout
  @positive
  Scenario: Success Logout
    Given User already in login page
    And User fill Username form & Password form
    Then User click the login button
    And User is directed to dashboard
    And User click hamburger menu
    When User click logout
    Then User should directed to login page
