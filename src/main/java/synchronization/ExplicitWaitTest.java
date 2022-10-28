package synchronization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitTest {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        //Explicit wait to load page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h4.product-name")));

        //Declare an array of products that we want to add to cart
        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot"};
        WebOperations.addItems(driver, itemsNeeded);

        //Click on cart icon
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        //Click on checkout
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
        //Explicit wait
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
        //Enter coupon code
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        //Click on Apply
        driver.findElement(By.cssSelector("button.promoBtn")).click();
        //Explicit wait - target only specific element
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        //Print the text
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
    }
}
