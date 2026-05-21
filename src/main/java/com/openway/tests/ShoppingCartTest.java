package com.openway.tests;

import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.openway.pages.LoginPage;
import com.openway.pages.ShoppingPage;

public class ShoppingCartTest {
    public static void main(String[] args) 
    throws InterruptedException {
        Dotenv dotenv = Dotenv.load();
        String email = dotenv.get("PERIPLUS_EMAIL");
        String password = dotenv.get("PERIPLUS_PASSWORD");
        String url = "https://www.periplus.com/";
        String productName = "Morisaki";

        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);

        ShoppingPage homeShoppingPage = new ShoppingPage(driver);
        homeShoppingPage.searchForProduct(productName);
        Thread.sleep(3000);
        homeShoppingPage.openProduct(productName);
        homeShoppingPage.addToCart();

    }
}
