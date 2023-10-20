Feature: Saucedemo Login
  @positive
  Scenario: Login Success
    Given User on login page
    And User input username
    And User input password
    When User click login
    Then User should redirected to dashboard

  @negative
  Scenario: Login Failed
    Given User on login page
    And User input username
    And User input invalid password
    When User click login
    Then User should have alert message

