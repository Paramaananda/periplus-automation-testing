package com.openway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.cdimascio.dotenv.Dotenv;

public class OpenBrowser {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        WebDriver driver = new ChromeDriver();
        
        String url = "https://www.periplus.com/";
        String email = dotenv.get("PERIPLUS_EMAIL");
        String password = dotenv.get("PERIPLUS_PASSWORD");

        driver.get(url);
        driver.manage().window().maximize();
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
