Feature: Login Page Feature

  Scenario: Login page title
    Given user is on login page
    When user gets the title of the page
    Then title should be "Swag Labs"

  @Smoke @Regression
  Scenario Outline: : Login with correct credentials
    Given user is on login page
    When  user enter "<Username>" in username field
    And user enter "<Password>" in password field
    And click on login button
    Then user logged in successfully and lands on "https://www.saucedemo.com/inventory.html" products page
    And page header should be "PRODUCTS"
    Examples:
      | Username                | Password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
  @Smoke @Regression
  Scenario: Login with wrong credentials
    Given user is on login page
    When  user enter "locked_out_user" in username field
    And user enter "secret_sauce" in password field
    And click on login button
    Then user get "Epic sadface: Sorry, this user has been locked out." error