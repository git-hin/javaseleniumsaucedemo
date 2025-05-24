package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.sun.corba.se.impl.orbutil.CorbaResourceUtil.getText;

public class LoginPage {
    private WebDriver driver;

    @FindBy(xpath="//*[@id='user-name']")
    private WebElement usernameField;

    @FindBy(xpath = "//*[@id='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//*[@id='login_button_container']/div/form/div[3]/h3")
    private WebElement errorMessage;
    @FindBy(xpath = "//*[@id='login-button']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    public void login(String username, String password) {
//        usernameField.sendKeys(username);
//        passwordField.sendKeys(password);
//        loginButton.click();
//    }
    public void enterusername(String username){
        usernameField.sendKeys(username);
    }
    public void enterpassword(String password){
        passwordField.sendKeys(password);
    }
    public void clickLoginbutton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.id("login-button"))); // Using ID instead of XPath
        loginButton.click();

    }
    public void navigateTo() {
        driver.get("https://www.saucedemo.com/");
    }
    // Option 1: Use this if you want to keep login() only


    // Option 2: Add this if you prefer enterCredentials() + separate click
    public void enterCredentials(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }
    public String getErrorMessage() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement error = wait.until(ExpectedConditions.visibilityOf(errorMessage));
            return error.getText().trim();
        } catch (TimeoutException e) {
            // Check if different error element exists
            List<WebElement> errors = driver.findElements(By.cssSelector("[data-test='error']"));
            if (!errors.isEmpty()) {
                return errors.get(0).getText().trim();
            }
            return "No error message visible";
        }}
    public void closewindow(){
        driver.close();
    }
}