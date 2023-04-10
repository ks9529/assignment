package org.bookstore.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;

public class RegisterPage  {
    public WebDriver driver;
    private By NewuserButtonLocator = By.id("newUser");
    private By RegisterButtonLocator = By.xpath("//button[contains(text(),'Register')]");
    private By CaptchaCheckboxLocator = By.id("recaptcha-anchor");
    private By FirstNameInputLocator = By.id("firstname");
    private By LastNameInputLocator = By.id("lastname");

    private By userNameInputLocator = By.id("userName");
    private By passwordInputLocator = By.id("password");


    public RegisterPage(WebDriver driver) {
        this.driver = driver;

    }

    public void enterRegisterDetails(String FirstName,String LastName,String UserName,String Password) {
        WebElement FirstNameInput = driver.findElement(FirstNameInputLocator);
        FirstNameInput.sendKeys(FirstName);
        WebElement LastNameInput = driver.findElement(LastNameInputLocator);
        LastNameInput.sendKeys(LastName);
        WebElement usernameInput = driver.findElement(userNameInputLocator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", usernameInput);
        usernameInput.sendKeys(UserName);
        WebElement passwordInput = driver.findElement(passwordInputLocator);
        passwordInput.sendKeys(Password);
    }

    public void clickNewUserButton() {

        WebElement newUserButton = driver.findElement(NewuserButtonLocator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", newUserButton);
        js.executeScript("arguments[0].click();", newUserButton);
       // newUserButton.click();
    }
    public void clickRegisterButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(RegisterButtonLocator));
        WebElement RegisterButton = driver.findElement(RegisterButtonLocator);
        RegisterButton.click();
    }
    public void clickCaptchaCheckbox() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                By.xpath("//iframe[@title='reCAPTCHA']")));

        WebElement CaptchaCheckbox = driver.findElement(CaptchaCheckboxLocator);
        CaptchaCheckbox.click();

        Thread.sleep(20000);
        driver.switchTo().defaultContent();

    }


}
