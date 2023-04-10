package org.bookstore.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.bookstore.pages.ProfilePage;
import org.junit.Assert;
import org.bookstore.pages.LoginPage;
import org.bookstore.pages.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;

public class BookStoreStepDef {
    private WebDriver driver;
    public LoginPage loginPage;
    public RegisterPage registerPage;
    public ProfilePage profilePage;

    @Before
    public void setup(){
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }




    @Given("I am on the DemoQAbookstore page")
    public void i_am_on_the_demoqa_book_page() {
        driver.get("https://demoqa.com/books");
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        profilePage = new ProfilePage(driver);
        driver.manage().window().maximize();

    }


    @When("I have entered a valid {} and {}")
    public void i_have_entered_a_valid_username_and_password(String username, String password) {
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
    }

    @Given("I have entered invalid {string} and {string}")
    public void i_have_entered_invalid_and(String username, String password) {
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
    }

    @Then("I click on the login button")
    public void i_click_on_the_login_button() {

        loginPage.clickLoginButton();
    }



    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        Assert.assertEquals(loginPage.checkLogoutLink(), true);
    }



    @Then("I should see an error message indicating {string}")
    public void i_should_see_an_error_message_indicating(String errorMessage) throws InterruptedException {
        // Assert that an error message is displayed on the page matching the expected error message
Thread.sleep(1000);
        Assert.assertEquals( driver.findElement(By.xpath("//p[@id='name']")).isDisplayed(), true);
    }



    @When("I click on logout button")
    public void iClickOnLogoutButton() {
        loginPage.clickLogoutButton();
    }

    @Then("I should be logged out successfully")
    public void iShouldBeLoggedOutSuccessfully() {
        Assert.assertEquals(loginPage.checkLoginLink(), true);
    }

    @When("I have searched for book by {}")
    public void iHaveSearchedForBookBy(String userInput) {
        profilePage.searchBook(userInput);
    }


    @Then("I should get correct {},{},{}")
    public void iShouldGetCorrect(String arg0, String arg1, String arg2) {
        profilePage.checkSearchBookResult(arg0, arg1, arg2);

    }

    @Then("I should be able to add book to my collection")
    public void iShouldBeAbleToAddBookToMyCollection() throws InterruptedException {
        profilePage.addBook();
    }

    @Then("Verify book with {} is successfully added to profile")
    public void verifyBookIsSuccessfullyAddedToProfile(String Title) throws InterruptedException {
        profilePage.VerifyBookAddProfile(Title);

    }

    @Then("I should be able to delete book with {} from my collection")
    public void iShouldBeAbleToDeleteBookFromMyCollection(String Title) throws InterruptedException {
        profilePage.DeleteBook(Title);
    }

    @Then("Verify book with {} is deleted from profile")
    public void verifyBookWithIsDeletedFromProfile(String Title) throws InterruptedException {
        profilePage.VerifyBookDeleteProfile(Title);


    }

    @Then("I should be able to delete all book from my profile")
    public void iShouldBeAbleToDeleteAllBookFromMyProfile() throws InterruptedException {
        profilePage.DeleteAllBooks();
    }

    @When("I click on the NewUser button")
    public void i_click_on_the_newuser_button() {

        registerPage.clickNewUserButton();
    }

    @When("I have entered  {} , {} , {} , {}")
    public void i_have_entered_valid_details(String FirstName,String LastName,String username, String password) {
        registerPage.enterRegisterDetails(FirstName,LastName,username,password);
    }
    @Then("I click on the register button")
    public void i_click_on_the_register_button() {

        registerPage.clickRegisterButton();
    }
    @And("I click on captcha")
    public void i_click_on_the_captcha() throws InterruptedException {

        registerPage.clickCaptchaCheckbox();
    }
}
