Feature: Product listing and sorting

  @Regression @Products
  Scenario: Verify product listing and sorting
    Given I am on the SauceDemo login page
    When I enter valid username "standard_user" and password "secret_sauce"
    And I click the login button
    When I am on the products page
    Then I should see a list of products
    When I sort products by "Price (low to high)"
    Then the products should be sorted by price in ascending order