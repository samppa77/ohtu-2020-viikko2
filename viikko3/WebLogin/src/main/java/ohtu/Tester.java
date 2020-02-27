package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {

    public static void main(String[] args) {
        //WebDriver driver = new ChromeDriver();
        WebDriver driver = new HtmlUnitDriver();        
        driver.get("http://localhost:4567");
        
        Random r = new Random();
    
               
        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());
        
        sleep(2);
        
        
// Valmis esim.
/*
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();
        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());
        sleep(2);

        element = driver.findElement(By.name("username"));        
        element.sendKeys("pekka");
        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());

        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());
        
        element = driver.findElement(By.name("login"));
        sleep(2);
        element.submit();
        sleep(3);
        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());
*/


// Esim. Oikea tunnus, väärä salanasa (TOIMII)
/*
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();
        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());
        sleep(2);

        element = driver.findElement(By.name("username"));        
        element.sendKeys("pekka");
        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());

        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep2");
        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());
        
        element = driver.findElement(By.name("login"));
        sleep(2);
        element.submit();
        sleep(3);
        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());
*/
        
//TÄhän jäätiin!!        
//Esim. uuden käyttäjätunnuksen luominen

        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
        // tulostetaan sivu konsoliin
//        System.out.println(driver.getPageSource());
        sleep(2);

        int luku = r.nextInt(100000);
                
        element = driver.findElement(By.name("username"));        
        element.sendKeys("matti"+luku);
        // tulostetaan sivu konsoliin
//        System.out.println(driver.getPageSource());


        element = driver.findElement(By.name("password"));
        element.sendKeys("ittam"+luku);
        // tulostetaan sivu konsoliin
//        System.out.println(driver.getPageSource());

        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("ittam"+luku);
        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());
        
        element = driver.findElement(By.name("signup"));
        sleep(2);
        element.submit();
        sleep(3);
        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());
        
        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());
        
        element = driver.findElement(By.linkText("logout"));
        element.click();
        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());
        
        
        
        
        
        
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
