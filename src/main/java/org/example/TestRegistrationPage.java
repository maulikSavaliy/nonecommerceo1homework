package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;

public class TestRegistrationPage {
    // create a variabel of webdriver
    protected static WebDriver driver;
    // create timestamp methode to show corrent time and use in a email for continusly check a registration page
    public static String timeStamp(){
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
        return timeStamp;
    }
    // create a new cliconelement method for reusabilityu purpose
    public static void clickonelement(By by){
        driver.findElement(by).click();
    }
    // create a new typeelement method for reusabilityu purpose
    public static void typeelement(By by,String text){
        driver.findElement(by).sendKeys(text);
    }
    // create a new togettextfromelement method for reusabilityu purpose
    public static String togettextfromelement(By by){
        return driver.findElement(by).getText();
    }
    //create explicity waitfor clickable method for put some more time in spacific element
    public static void Waitclickable(By by,int time){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(time));
    wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    //create explicity waitfor visiblity method for put some more time in spacific element
public static void waitforvisable(By by,int time){
        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
}
    //create explicity waitfor invisiblity method for put some more time in spacific element
public static void waitforinvisibility(By by,int time){
        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
}
    //create explicity waitfor url to be  method for put some more time in spacific element
public static void waitforurltobr(int time){
        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(time));
     wait.until(ExpectedConditions.urlToBe(driver.getCurrentUrl()));
}
    //create explicity waitfor disappear  method for put some more time in spacific element
public static void waitfordisappear(By by,int time){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(time));
       wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
//create a main method
    public static void main(String[] args) {
        //set property and path of webdriver
System.setProperty("webdriver.chrome.driver","src/test/Resources/drivers/chromedriver.exe");
// declate a instance variable a new name in local and use in main method
driver=new ChromeDriver();

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().fullscreen();
// tell driver to call this url
        driver.get("https://demo.nopcommerce.com/");
        //wait  5 second for lodiong url
        waitforurltobr(5);
        //reusability clickonelement method
        clickonelement(By.className("ico-register"));
        //wait for 10 second after click on registration button
        Waitclickable(By.className("ico-register"),10);
        //reusability clickonelement method
        clickonelement(By.id("gender-male"));
        //reusability typeelement method
        typeelement(By.xpath("//input[@name='FirstName']"),"raghav ");
        //reusability typeelement method
        typeelement(By.id("LastName"),"yadav");
            Select selectday=new Select(driver.findElement(By.name("DateOfBirthDay")));
            selectday.selectByVisibleText("12");
            Select selectmonth =new Select(driver.findElement(By.name("DateOfBirthMonth")));
            selectmonth.selectByIndex(3);
            Select selectyear=new Select(driver.findElement(By.name("DateOfBirthYear")));
            selectyear.selectByVisibleText("2002");
        typeelement(By.xpath("//input[@name='Email']"),"aahgcghc"+timeStamp()+"@gd.com");
        typeelement(By.id("Company"),"alex impax");
        clickonelement(By.xpath("//input[@value='true']"));
        typeelement(By.id("Password"),"aaaa123");
        typeelement(By.id("ConfirmPassword"),"aaaa123");
        clickonelement(By.id("register-button"));
        //wait  10 second for text is visible
        waitforvisable(By.xpath("//div[@class=\"result\"]"),10);
        //use gettext method to get text
        System.out.println(togettextfromelement(By.xpath("//div[@class=\"result\"]")));
        driver.close();

    }
}
