package com.saucedemo.stepdefs;

import com.saucedemo.managers.DriverManager;
import com.saucedemo.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.fail;

public class LoginSteps {
    private WebDriver driver = DriverManager.getDriver();
    private LoginPage loginPage = new LoginPage(driver);

    @Given("I am on the login page")
    public void navigateToLoginPage() {
        loginPage.navigateTo();
    }
    @Given("I am on the SauceDemo login page")
    public void navigateToLoginPage1() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("I login with valid credentials")
    public void loginWithValidCredentials() throws InterruptedException {
        loginPage.enterusername("standard_user");
        loginPage.enterpassword("secret_sauce");
        loginPage.clickLoginbutton();
    }

    @Then("I should be redirected to the products page")
    public void verifyProductsPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
    }
    @When("I enter valid username {string} and password {string}")
    public void enterValidCredentials(String username, String password) throws InterruptedException {
        loginPage.enterusername("standard_user");
        loginPage.enterpassword("secret_sauce");

    }@When("I enter invalid username {string} and password {string}")
    public void i_enter_invalid_username_and_password(String username, String password) {
        loginPage.enterusername("test");
        loginPage.enterpassword("test");
        loginPage.clickLoginbutton();
    }
    // OR Using Option 2 (separate methods)


    @When("I click the login button")
    public void clickLoginButton() {
        loginPage.clickLoginbutton();
    }

    @Then("I should see an error message {string}")
    public void iShouldSeeAnErrorMessage(String expectedErrorMessage
    ) {
        String actualError = loginPage.getErrorMessage();

        // Debug output
        System.out.println("Verifying error message:");

        System.out.println("Expected: " + expectedErrorMessage);
        System.out.println("Actual:   " + actualError);

        // Flexible assertion
        if (!actualError.contains(expectedErrorMessage)) {
            // Detailed failure message
            fail(String.format("Error message verification failed.%nExpected to find: '%s'%nActual message was: '%s'",
                    expectedErrorMessage, actualError));
        }



    }




    @When("I leave username and password fields empty and I click the login button")
    public void iLeaveUsernameAndPasswordFieldsEmptyAndIClickTheLoginButton() {

        loginPage.clickLoginbutton();
    }
    @Then("close the driver window")
    public void close_the_driver_window() {
        loginPage.closewindow();
    }
}