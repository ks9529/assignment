package org.bookstore.pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {


    public WebDriver driver;
    private By SearchInputLocator = By.id("searchBox");
    private By BookTitleLocator = By.xpath(" //div[@class='action-buttons']/span/a");

    private By BookAuthorLocator = By.xpath("//div[@class='rt-tr -odd']/div[3]");
    private By BookPublisherLocator = By.xpath("//div[@class='rt-tr -odd']/div[4]");
    private By AddToYourCollectionButtonLocator = By.xpath("//button[contains(text(),'Add To Your')]");

    private By profileButtonLocator = By.xpath("//li/span[contains(text(),'Profile')]");

    private By DeleteButtonLocator = By.xpath("//span[@title='Delete']");
    private By OkButtonLocator = By.xpath("//button[@id='closeSmallModal-ok']");
    private By DeleteAllBookButtonLocator = By.xpath("//div[@class='do']/button[contains(text(),'Delete All')]");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }
    public void searchBook(String userInput){
        WebElement searchBox = driver.findElement(SearchInputLocator);
        searchBox.sendKeys(userInput);
    }
    public void checkSearchBookResult(String ExpectedTitle,String ExpectedAuthor,String ExpectedPublisher){
        WebElement BookTitle = driver.findElement(BookTitleLocator);
        String ActualTitle = BookTitle.getText();

        WebElement BookAuthor= driver.findElement(BookAuthorLocator);
        String ActualAuthor =BookAuthor.getText();

        WebElement BookPublisher= driver.findElement(BookPublisherLocator);
        String ActualPublisher = BookPublisher.getText();

        Assert.assertEquals( ActualTitle,ExpectedTitle);
        Assert.assertEquals( ActualAuthor ,ExpectedAuthor);
        Assert.assertEquals( ActualPublisher ,ExpectedPublisher);
        WebElement searchBox = driver.findElement(SearchInputLocator);
        searchBox.clear();


    }
    public void addBook() throws InterruptedException {
        WebElement BookTitle = driver.findElement(BookTitleLocator);
        BookTitle.click();
        WebElement AddBook = driver.findElement(AddToYourCollectionButtonLocator);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", AddBook);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        AddBook.click();
        //js.executeScript("arguments[0].click();",AddBook);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();


    }
    public void VerifyBookAddProfile(String ExpectedTitle) throws InterruptedException {
        WebElement ProfileButton = driver.findElement(profileButtonLocator);

        ProfileButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebElement searchBox = driver.findElement(SearchInputLocator);
        searchBox.sendKeys(ExpectedTitle);
        WebElement BookTitle = driver.findElement(BookTitleLocator);
        String ActualTitle = BookTitle.getText();


        Assert.assertEquals( ActualTitle,ExpectedTitle);



    }
    public void DeleteBook(String ExpectedTitle) throws InterruptedException {

        WebElement ProfileButton = driver.findElement(profileButtonLocator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", ProfileButton);
        ProfileButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebElement searchBox = driver.findElement(SearchInputLocator);
        searchBox.sendKeys(ExpectedTitle);

        WebElement DeleteButton = driver.findElement(DeleteButtonLocator);
        DeleteButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebElement OkButton = driver.findElement(OkButtonLocator);
        OkButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

    }
    public boolean VerifyBookDeleteProfile(String ExpectedTitle) throws InterruptedException {
        WebElement searchBox = driver.findElement(SearchInputLocator);
        searchBox.clear();
        searchBox.sendKeys(ExpectedTitle);

        try {
            driver.findElement(BookTitleLocator);
            return false;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return true;
        }
    }
    public void DeleteAllBooks() throws InterruptedException {
        WebElement ProfileButton = driver.findElement(profileButtonLocator);




        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", ProfileButton);
        ProfileButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        WebElement DeleteAllBookButton = driver.findElement(DeleteAllBookButtonLocator);
        js.executeScript("arguments[0].scrollIntoView();", DeleteAllBookButton);
        js.executeScript("arguments[0].click();", DeleteAllBookButton);
        //DeleteAllBookButton.click();
        WebElement OkButton = driver.findElement(OkButtonLocator);
        OkButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

    }





}
