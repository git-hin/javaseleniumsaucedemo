package com.saucedemo.stepdefs;

import com.saucedemo.managers.DriverManager;
import com.saucedemo.pages.ProductsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class ProductSteps {

    private WebDriver driver = DriverManager.getDriver();
    private ProductsPage productsPage =new ProductsPage(driver);

    @When("I am on the products page")
    public void i_am_on_the_products_page() {
        assertTrue(productsPage.isOnProductsPage());
    }

    @Then("I should see a list of products")
    public void i_should_see_a_list_of_products() {
        assertTrue(productsPage.getProductCount() > 0);
    }

    @When("I sort products by {string}")
    public void i_sort_products_by(String sortOption) {
        productsPage.sortProducts(sortOption);
    }

    @Then("the products should be sorted by price in ascending order")
    public void products_should_be_sorted_by_price_ascending() {
        assertTrue(productsPage.isSortedByPriceAscending());
    }
}