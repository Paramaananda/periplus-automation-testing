package com.openway.tests;

import io.github.cdimascio.dotenv.Dotenv;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.openway.pages.LoginPage;
import com.openway.pages.ShoppingPage;

public class ShoppingCartTest {

    WebDriver driver;

    String email;
    String password;
    String url;
    String productName;

    @BeforeMethod
    public void setup() {

        Dotenv dotenv = Dotenv.load();

        email = dotenv.get("PERIPLUS_EMAIL");
        password = dotenv.get("PERIPLUS_PASSWORD");

        url = "https://www.periplus.com/";
        productName = "Morisaki";

        driver = new ChromeDriver();

        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test
    public void verifyAddProductToCart()
    throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);

        ShoppingPage shoppingPage = new ShoppingPage(driver);
        shoppingPage.searchForProduct(productName);

        Thread.sleep(3000);
        shoppingPage.openProduct(productName);
        String actualProductTitle = shoppingPage.getProductTitle();

        Thread.sleep(3000);
        shoppingPage.addToCart();

        Thread.sleep(2000);
        String actualPopupMessage =
        
        shoppingPage.getSuccessAddToCartModalMessage();
        Assert.assertEquals(actualPopupMessage,"Success add to cart", "FAILED TO DISPLAY SUCCESS ADD TO CART MODAL");
        System.out.println("SUCCESS ADD TO CART MODAL VERIFIED");  
        
        Thread.sleep(3000);
        shoppingPage.openCart();
        String actualProductTitleInsideCart = shoppingPage.getProductTitleInsideCart();
        Assert.assertTrue(actualProductTitleInsideCart.contains(actualProductTitle), "FAILED TO VERIFY PRODUCT TITLE INSIDE CART");
        System.out.println("PRODUCT TITLE INSIDE CART VERIFIED");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}