Feature: Checkout process

  @Regression @Checkout
  Scenario: Complete checkout with two products
    Given I am on the SauceDemo login page
    When I enter valid username "standard_user" and password "secret_sauce"
    And I click the login button
    When I add two products to the cart
    And I proceed to checkout
    And I enter checkout information "John" "Doe" "12345"
    Then I should see the checkout complete page