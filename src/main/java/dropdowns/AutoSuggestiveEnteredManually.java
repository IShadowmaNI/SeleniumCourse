package dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveEnteredManually {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ro.aegeanair.com/");
        Thread.sleep(1000L);

        //Handle Go To
        WebElement source = driver.findElement(By.id("AirportFromSelect"));
        source.click();
        source.sendKeys("LON");
        Thread.sleep(1000L);
        source.sendKeys(Keys.ENTER);

        //Handle Destination
        WebElement destination = driver.findElement(By.id("AirportToSelect"));
        destination.click();
        destination.sendKeys("s");
        Thread.sleep(1000L);
        destination.sendKeys("sa");
        Thread.sleep(1000L);
        for (int i = 0; i < 4; i++) {
            destination.sendKeys(Keys.ARROW_DOWN);
        }
        Thread.sleep(1000L);
        destination.sendKeys(Keys.ENTER);
    }
}
