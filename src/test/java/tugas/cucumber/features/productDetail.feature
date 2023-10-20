Feature: Product Detail
  @positive
  Scenario: Open product detail
    Given User in login page page
    And User fill Username & Password form
    And User click button login
    Then User directed to dashboard page
    And User click one product
    Then User directed to product detail page
