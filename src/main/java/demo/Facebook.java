package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;

public class Facebook {


    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://facebook.com"); //URL in the browser


//        driver.findElement(By.id("email")).sendKeys("This is my first code");
//        driver.findElement(By.name("pass")).sendKeys("123456");
//
        //Bypass Cookie Popup
//        WebElement element = driver.findElement(By.linkText("Forgot password?"));
//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        jse.executeScript("arguments[0].click()", element);

        driver.findElement(By.cssSelector("#email")).sendKeys("emailaddress");
        driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("password");

        //Xpath for login button: //button[@name='login']
        //Xpath for email element: //input[@data-testid='royal_email']
        //Xpath for password element: //input[@id='pass']

    }
}
