package ohtu;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import ohtu.io.*;
import ohtu.data_access.*;
import ohtu.services.*;

public class Stepdefs {
    App app;
    StubIO io;
    UserDao userDao;
    AuthenticationService auth;
    List<String> inputLines;
    
    @Before
    public void setup(){
        userDao = new InMemoryUserDao();
        auth = new AuthenticationService(userDao);
        inputLines = new ArrayList<>();      
    }
    
    @Given("^command login is selected$")
    public void commandLoginSelected() throws Throwable {
        inputLines.add("login");
    }

    @When("username {string} and password {string} are entered")
    public void usernameAndPasswordAreEntered(String username, String password) {
       inputLines.add(username);
       inputLines.add(password);
       
       io = new StubIO(inputLines); 
       app = new App(io, auth);
       app.run();
    }    
    
    
    @Then("system will respond with {string}")
    public void systemWillRespondWith(String expectedOutput) {
        System.out.println("ohjelma tulosti seuraavat rivit: "+io.getPrints());
        System.out.println("ohjelma odotti seuraavaa: "+expectedOutput);        
        assertTrue(io.getPrints().contains(expectedOutput));
    }    

    
    
// Omat - 1. incorrect password    
    @Given("^command new is selected$")
    public void commandNewSelected() throws Throwable {
        inputLines.add("new");
    }

    
    @Given("user {string} with password {string} is created")
    public void userWithPasswordIsCreated(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
       inputLines.add("new");        
       inputLines.add(string);
       inputLines.add(string2);


        //throw new cucumber.api.PendingException();
    }    
    
    
/*    
    @When("username {string} and incorrect password {string} are entered")
    public void usernameAndPasswordAreEnteredA(String username, String password) {
       inputLines.add(username);
       inputLines.add(password);
       
       io = new StubIO(inputLines); 
       app = new App(io, auth);
       app.run();
    }    
    
    
    @Then("system will respond with {string}")
    public void systemWillRespondWithA(String expectedOutput) {
        System.out.println("ohjelma tulosti seuraavat rivit: "+io.getPrints());
        System.out.println("ohjelma odotti seuraavaa: "+expectedOutput);        
        assertTrue(io.getPrints().contains(expectedOutput));
    }    

  */  
    
    
    
    /*
    
// Omat - 2. incorrect password    
    @Given("^command login is selected$")
    public void commandLoginSelected() throws Throwable {
        inputLines.add("login");
    }

    @When("nonexistent username {string} and password {string} are entered")
    public void usernameAndPasswordAreEntered(String username, String password) {
       inputLines.add(username);
       inputLines.add(password);
       
       io = new StubIO(inputLines); 
       app = new App(io, auth);
       app.run();
    }    
    
    @Then("system will respond with {string}")
    public void systemWillRespondWith(String expectedOutput) {
        assertTrue(io.getPrints().contains(expectedOutput));
    }    
*/
    
    
}
