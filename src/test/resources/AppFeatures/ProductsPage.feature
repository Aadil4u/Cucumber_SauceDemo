Feature: Products Page Feature

  Background:
    Given User is already logged in with below credentials
      | username      | password     |
      | standard_user | secret_sauce |
  @Smoke
  Scenario: Check products count
    Given user is on products page which has "PRODUCTS" header
    Then user gets product count
    And products count is equal to 6
  @Regression
  Scenario: Add products to cart
    Given user is on products page which has "PRODUCTS" header
    When user click on add to cart button for below products
      | Sauce Labs Backpack     |
      | Sauce Labs Onesie       |
      | Sauce Labs Bolt T-Shirt |
    Then user clicks on cart btn
    And verify total count is 3
  @Regression
  Scenario: Click on product name to check product details
    Given user is on products page which has "PRODUCTS" header
    When user click on "Sauce Labs Onesie" product name
    Then user navigated to product details page and gets product name
    And product name is equal to "Sauce Labs Onesie"

