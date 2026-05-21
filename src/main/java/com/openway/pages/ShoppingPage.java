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

    public String getProductTitle() {
        return driver.findElement(By.cssSelector("h2")).getText();
    }

    public void addToCart() 
    throws InterruptedException {
        WebElement addToCartButton = driver.findElement(By.cssSelector(".btn.btn-add-to-cart"));
        Thread.sleep(3000);
        addToCartButton.click();
    }

    public void verifyProductInCart(){
        String actualPopupMessage = driver.findElement(By.className("modal-text")).getText();

        System.out.println("popup message: " + actualPopupMessage);

        if(actualPopupMessage.equalsIgnoreCase("Success add to cart")){
            System.out.println("SYSTEM SUCCESS GIVING MESSAGE WHEN ADDING PRODUCT IN CART");
        } else {
            System.out.println("SYSTEM FAILED GIVING MESSAGE WHEN ADDING PRODUCT IN CART");
        }
    }

    public int getCartTotal() {
        String cartText = driver.findElement(By.id("cart_total")).getText();
        return Integer.parseInt(cartText);
    }

    public void cartIncrement(int cartBeforeAdd, int cartAfterAdd) {
        if (cartAfterAdd == cartBeforeAdd + 1) {
            System.out.println("Cart incremented successfully.");
        } else {
            System.out.println("Cart increment failed.");
        }
    }

    public void openCart() {
        WebElement cartIcon = driver.findElement(By.id("show-your-cart"));
        cartIcon.click();
    }

    public void verifyTitleInsideCart(String expectedProductName) {
        String actualProductTitle = driver.findElement(By.cssSelector(".product-name.limit-lines a")).getText();
        System.out.println("Product title in cart: " + actualProductTitle);

        if (actualProductTitle.contains(expectedProductName)) {
            System.out.println("PRODUCT TITLE VERIFIED INSIDE CART");
        } else {
            System.out.println("FAILED TO VERIFY PRODUCT TITLE INSIDE CART");
        }
    }
}

