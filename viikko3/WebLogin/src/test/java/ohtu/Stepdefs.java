package ohtu;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Stepdefs {

    //WebDriver driver = new ChromeDriver();
    WebDriver driver = new HtmlUnitDriver();
    String baseUrl = "http://localhost:4567";

    @Given("login is selected")
    public void loginIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();
    }

    @When("correct username {string} and password {string} are given")
    public void correctUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }

    @Then("user is logged in")
    public void userIsLoggedIn() {
        pageHasContent("Ohtu Application main page");
    }

    @When("correct username {string} and incorrect password {string} are given")
    public void correctUsernameAndIncorrectPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }

    @Then("user is not logged in and error message is given")
    public void userIsNotLoggedInAndErrorMessageIsGiven() {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }

    @When("username {string} and password {string} are given")
    public void usernameAndPasswordAreGiven(String username, String password) throws Throwable {
        logInWith(username, password);
    }

    @Then("system will respond {string}")
    public void systemWillRespond(String pageContent) throws Throwable {
        assertTrue(driver.getPageSource().contains(pageContent));
    }

    // Omia:
    @When("nonexistent username {string} and incorrect password {string} are given")
    public void nonexistentUsernameAndIncorrectPasswordAreGiven(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        logInWith(string, string2);

    }

// Tehtävä 10:
    @Given("command new user is selected")
    public void commandNewUserIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
    }

    @When("a valid username {string} and password {string} and matching password confirmation are entered")
    public void aValidUsernameAndPasswordAndMatchingPasswordConfirmationAreEntered(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        createNewUser(string, string2);
    }

    @Then("a new user is created")
    public void aNewUserIsCreated() {
        // Write code here that turns the phrase above into concrete actions
        pageHasContent("Welcome to Ohtu Application!");
    }

    @When("a too short username {string} and password {string} and matching password confirmation are entered")
    public void aTooShortUsernameAndPasswordAndMatchingPasswordConfirmationAreEntered(String string, String string2) {
        createNewUser(string, string2);
    }

    @When("a valid username {string} and too short password {string} and matching password confirmation are entered")
    public void aValidUsernameAndTooShortPasswordAndMatchingPasswordConfirmationAreEntered(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        createNewUser(string, string2);
    }

    @When("a valid username {string} and password {string} and non matching password confirmation {string} are entered")
    public void aValidUsernameAndPasswordAndNonMatchingPasswordConfirmationAreEntered(String string, String string2, String string3) {
        // Write code here that turns the phrase above into concrete actions
        createNewUserWrongConf(string, string2, string3);
    }

    @Then("user is not created and error {string} is reported")
    public void userIsNotCreatedAndErrorIsReported(String string) {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(driver.getPageSource().contains(string));
    }

    @Given("user with username {string} with password {string} is successfully created")
    public void userWithUsernameWithPasswordIsSuccessfullyCreated(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
        createNewUser(string, string2);
        pageHasContent("Welcome to Ohtu Application!");
    }

    @When("a  username {string} and password {string} and matching password confirmation are entered")
    public void aUsernameAndPasswordAndMatchingPasswordConfirmationAreEntered(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        logInWith(string, string2);
    }
    
    @Given("user with username {string} and password {string} is tried to be created")
    public void userWithUsernameAndPasswordIsTriedToBeCreated(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
        createNewUser(string, string2);        
    }
    
    

    @After
    public void tearDown() {
        driver.quit();
    }

    /* helper methods */
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }

    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();
    }

    private void createNewUser(String username, String password) {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(password);
        element = driver.findElement(By.name("signup"));
        element.submit();
    }

    private void createNewUserWrongConf(String username, String password, String passwordConfirmation) {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(passwordConfirmation);
        element = driver.findElement(By.name("signup"));
        element.submit();
    }

}


/*
    Scenario: nonexistent user can not login to 
        Given login is selected
        When  nonexistent username "jukka67" and incorrect password "wrong67" are given
        Then user is not logged in and error message is given
 */
