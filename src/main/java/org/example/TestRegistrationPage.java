package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestRegistrationPage {
    // create a variabel of webdriver
    protected static WebDriver driver;

    public static void main(String[] args) {
        //set property and path of webdriver
System.setProperty("webdriver.chrome.driver","src/test/Resources/drivers/chromedriver.exe");
// declate a instance variable a new name in local and use in main method
driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().fullscreen();
// tell driver to call this url
        driver.get("https://demo.nopcommerce.com/");
        // tell driver go in to registration page using locatore by class name
driver.findElement(By.className("ico-register")).click();
//using id type locater and click on radio button
driver.findElement(By.id("gender-male")).click();
//using id type locater and clik on first name and input a first name
driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("raghav ");
//using a id type locater and click on last name and input ast name
driver.findElement(By.id("LastName")).sendKeys("yadav");
//using a id type locator znd click om email and type a email
driver.findElement(By.xpath("//input[@name='Email']")).sendKeys("aahgcghc@gd.com");
//using a id type locator and click on company name and input company name
driver.findElement(By.id("Company")).sendKeys("alex impax");
driver.findElement(By.xpath("//input[@value='true']")).click();
//using a id type locator and finf a password element and type a password
driver.findElement(By.id("Password")).sendKeys("aaaa123");
// usind a id type locater and find a confrim password box and enter a password
driver.findElement(By.id("ConfirmPassword")).sendKeys("aaaa123");
// using a id type locator and click on registration button
driver.findElement(By.id("register-button")).click();
//driver.close();

    }
}
