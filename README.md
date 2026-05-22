# periplus-automation-testing
Automation testing project for the Periplus Official Website created for the technical test of the Software / QA Engineer Internship at OpenWay Indonesia. Built with Java, Selenium WebDriver, Maven, and TestNG to automate login, search, and navigation testing.

## Project Overview

This project automates the shopping cart functionality on the Periplus website.  
The automation scenario covers:

- User login
- Product search
- Open product detail page
- Add product into shopping cart
- Verify success popup modal
- Verify selected product inside shopping cart

The project is implemented using Page Object Model (POM) structure for better code maintainability and scalability.

---

# Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Maven
- Dotenv

---

# Project Structure

```text
src
├── main
│   └── java
│       └── com
│           └── openway
│               └── pages
│                   ├── LoginPage.java
│                   └── ShoppingPage.java
│
└── test
    └── java
        └── com
            └── openway
                └── tests
                    └── ShoppingCartTest.java
```

---

# Features

## Login Automation
- Open Periplus website
- Login using valid account credentials

## Product Search
- Search product using keyword
- Open selected product from search result

## Shopping Cart Automation
- Add product into shopping cart
- Verify success add to cart popup modal
- Verify selected product title inside shopping cart

---

# Page Object Model Implementation

## LoginPage.java

Handles all login related actions.

### Methods

| Method | Description |
|---|---|
| `login(String email, String password)` | Login using registered user credentials |

---

## ShoppingPage.java

Handles all shopping related actions.

### Methods

| Method | Description |
|---|---|
| `searchForProduct(String productName)` | Search product using keyword |
| `openProduct(String expectedProductName)` | Open selected product from search result |
| `getProductTitle()` | Get selected product title |
| `addToCart()` | Click Add To Cart button |
| `getSuccessAddToCartModalMessage()` | Get popup success message |
| `getCartTotal()` | Get current cart counter |
| `openCart()` | Open shopping cart page |
| `getProductTitleInsideCart()` | Get product title displayed inside cart |

---

## ShoppingCartTest.java

Main automated test execution using TestNG.

### Test Flow

1. Open browser
2. Navigate to Periplus website
3. Login using valid credentials
4. Search product
5. Open selected product
6. Add product to shopping cart
7. Verify success popup modal
8. Open shopping cart
9. Verify selected product inside cart
10. Close browser

---

# Assertions Used

The project uses TestNG assertions for validation.

## Implemented Assertions

| Assertion | Purpose |
|---|---|
| `Assert.assertEquals()` | Verify success add to cart popup message |
| `Assert.assertTrue()` | Verify selected product title inside shopping cart |

---

# Environment Variables

Project credentials are stored using `.env` file.

Example:

```env
PERIPLUS_EMAIL=your_email
PERIPLUS_PASSWORD=your_password
```

---

# How To Run

## Clone Repository

```bash
git clone <repository-url>
```

---

## Install Dependencies

```bash
mvn clean install
```

---

## Run Automation Test

```bash
mvn test
```

---

# Test Scenario

## Automated Scenario

- User successfully logs in
- User searches product
- User opens selected product page
- User adds product into shopping cart
- System displays success popup modal
- Selected product appears inside shopping cart

---

# Author
I Putu Paramaananda Tanaya