package com.openway.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String email, String password) {
        driver.findElement(By.id("nav-signin-text")).click();

        WebElement emailField = driver.findElement(By.name("email"));
        emailField.clear();
        emailField.sendKeys(email);

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.clear();
        passwordField.sendKeys(password);

        driver.findElement(By.id("button-login")).click();
    }
}
