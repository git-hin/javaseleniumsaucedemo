package com.saucedemo.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;


public class ProductsPage {
    private WebDriver driver;
    private final WebDriverWait wait;

//    @FindBy(xpath = "//*[@id='add-to-cart-sauce-labs-backpack']")
//    private WebElement addToCart1;
//
//    @FindBy(xpath="//*[@id='add-to-cart-sauce-labs-bike-light']")
//    private WebElement addToCart2;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;
    @FindBy(className = "title") private WebElement pageTitle;
    @FindBy(className = "inventory_item") private List<WebElement> products;
    @FindBy(className = "product_sort_container") private WebElement sortDropdown;
    @FindBy(className = "inventory_item_price") private List<WebElement> prices;

    public ProductsPage(WebDriver driver) {
        this.driver = Objects.requireNonNull(driver, "WebDriver must not be null");
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }


//    public void addProductToCart() {
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(addToCart1)).click();
//        wait.until(ExpectedConditions.elementToBeClickable(addToCart2)).click();
//    }
@FindBy(css = "button.btn_inventory")
private List<WebElement> addToCartButtons;




    public void addProductToCart() {
        wait.until(d -> !addToCartButtons.isEmpty());
        addToCartButtons.get(0).click(); // First product
        addToCartButtons.get(1).click(); // Second product
    }

    public void goToCart() {
        cartIcon.click();
    }
    public void proceedToCheckout() {
        checkoutButton.click();
    }

    public boolean isSortedByPriceAscending() {
        for (int i = 0; i < prices.size() - 1; i++) {
            double current = getPriceValue(prices.get(i).getText());
            double next = getPriceValue(prices.get(i+1).getText());
            if (current > next) return false;
        }
        return true;
    }

    public void sortProducts(String sortOption) {
        new Select(sortDropdown).selectByVisibleText(sortOption);
    }
    private double getPriceValue(String priceText) {
        return Double.parseDouble(priceText.replace("$", ""));
    }

    public boolean isOnProductsPage() {
        return pageTitle.getText().equals("Products");
    }

    public int getProductCount() {
        return products.size();
    }

}

