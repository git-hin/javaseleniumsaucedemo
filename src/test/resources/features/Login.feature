Feature: Login functionality

  @Login @Regression
  Scenario: Successful login with valid credentials
    Given I am on the SauceDemo login page
    When I enter valid username "standard_user" and password "secret_sauce"
    And I click the login button
    Then I should be redirected to the products page
    Then close the driver window
  @Login @Regression
  Scenario: Failed login with invalid credentials
    Given I am on the SauceDemo login page
    When I enter invalid username "invalid_user" and password "wrong_password"
    And I click the login button
    Then I should see an error message "Epic sadface: Username and password do not match any user in this service"
    Then close the driver window

  @Login @Regression
  Scenario: Failed login with empty credentials
    Given I am on the SauceDemo login page
    And I click the login button
    Then I should see an error message "Epic sadface: Username is required"
    Then close the driver window