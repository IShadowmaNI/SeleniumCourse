package synchronization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ImplicitWaitTest {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        //Declare an array of products that we want to add to cart
        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot"};
        WebOperations.addItems(driver, itemsNeeded);

        //Click on cart icon
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        //Click on checkout
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
        //Enter coupon code
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        //Click on Apply
        driver.findElement(By.cssSelector("button.promoBtn")).click();
        //Print the text
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
    }
}
