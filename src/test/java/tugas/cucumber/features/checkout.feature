Feature: Saucedemo Checkout
  @positive
  Scenario: Positive Checkout
    Given User in login page
    And User fill Username and Password form
    Then User click login button
    And User directed to dashboard
    And User add one product to card
    And User click cart icon
    And User verify the product
    Then User click checkout button
    And User fill information form
    Then User click continue button
    And User directed to overview page
    Then User click finish button
    And User get order complete message
