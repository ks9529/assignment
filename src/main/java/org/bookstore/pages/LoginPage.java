package org.bookstore.pages;



import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import java.time.Duration;



public class LoginPage {

       public WebDriver driver;

        // Locators
        private By userNameInputLocator = By.id("userName");
        private By passwordInputLocator = By.id("password");
        private By loginButtonLocator = By.id("login");


        private By logoutButtonLocator = By.id("submit");
        // Constructor
        public LoginPage(WebDriver driver) {
            this.driver = driver;
            js = (JavascriptExecutor) this.driver;
        }


        JavascriptExecutor js;
    // Methods
        public void enterUserName(String username) {

            WebElement usernameInput = driver.findElement(userNameInputLocator);

            js.executeScript("arguments[0].scrollIntoView();", usernameInput);
            usernameInput.sendKeys(username);
        }

        public void enterPassword(String password) {
            WebElement passwordInput = driver.findElement(passwordInputLocator);
            passwordInput.sendKeys(password);
        }

    public void clickLoginButton() {
            WebElement loginButton = driver.findElement(loginButtonLocator);

            js.executeScript("arguments[0].scrollIntoView();", loginButton);
            loginButton.click();
        }

    public void clickLogoutButton() {
        WebElement logoutButton = driver.findElement(logoutButtonLocator);
       js.executeScript("arguments[0].scrollIntoView();", logoutButton);
        logoutButton.click();
    }


        public boolean checkLogoutLink(){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButtonLocator));
            return driver.findElement(logoutButtonLocator).isDisplayed();
        }
    public boolean checkLoginLink(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButtonLocator));
        return driver.findElement(loginButtonLocator).isDisplayed();
    }












    }

