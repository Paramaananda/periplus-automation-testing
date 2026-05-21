package com.openway.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import java.util.List;

public class ShoppingPage {
    WebDriver driver;

    public ShoppingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchForProduct(String productName) {
        WebElement searchBar = driver.findElement(By.id("filter_name_desktop"));
        searchBar.sendKeys(productName);
        searchBar.sendKeys(Keys.ENTER);
    }

    public void openProduct(String expectedProductName) 
        throws InterruptedException {

        List<WebElement> products = driver.findElements(By.cssSelector(".product-content.product-contents h3 a"));

        for (WebElement product : products) {

            String actualTitle = product.getText();

            System.out.println("Searched Title: " + actualTitle);

            if (actualTitle.contains(expectedProductName)) {
                Thread.sleep(3000);
                product.click();
                break;
            }
        }
    }

    public void addToCart() 
    throws InterruptedException {
        WebElement addToCartButton = driver.findElement(By.cssSelector(".btn.btn-add-to-cart"));
        Thread.sleep(3000);
        addToCartButton.click();
    }
}

