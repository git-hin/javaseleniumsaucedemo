package com.saucedemo.stepdefs;

import com.saucedemo.managers.DriverManager;
import com.saucedemo.pages.*;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class CheckoutSteps {
    private LoginPage loginPage;

    private CheckoutPage checkoutPage;
    private CheckoutCompletePage checkoutCompletePage;




        private WebDriver driver = DriverManager.getDriver();
        private ProductsPage productsPage =new ProductsPage(driver);

    @When("I add two products to the cart")
    public void i_add_two_products_to_the_cart() {
        productsPage.addProductToCart();
    }

    @When("I proceed to checkout")
    public void i_proceed_to_checkout() {
        productsPage.goToCart();
        productsPage.proceedToCheckout();
    }

    @When("I enter checkout information {string} {string} {string}")
    public void i_enter_checkout_information(String firstName, String lastName, String zipCode) {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterCheckoutInformation(firstName, lastName, zipCode);
        checkoutPage.continueToOverview();
    }

    @Then("I should see the checkout complete page")
    public void i_should_see_the_checkout_complete_page() {
        checkoutCompletePage = new CheckoutCompletePage(driver);
        Assert.assertTrue(checkoutCompletePage.isCheckoutComplete());
        driver.quit();
    }
}