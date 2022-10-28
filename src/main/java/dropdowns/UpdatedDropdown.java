package dropdowns;

import org.checkerframework.checker.units.qual.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UpdatedDropdown {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Need to add wait amount of seconds because of the loading page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.spicejet.com/");

        System.out.println(driver.findElement(By.xpath("//div[text()='Passengers']/following-sibling::div/div")).getText());
        driver.findElement(By.xpath("//div[text()='Passengers']")).click();
        for (int i = 0; i < 4; i++) {
            driver.findElement(By.xpath("//body/div[@id='react-root']/div[@id='main-container']/div[1]/div[1]/div[3]/div[2]/div[5]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[3]/*[1]")).click();
        }
        driver.findElement(By.xpath("//div[text()='Passengers']")).click();
        System.out.println(driver.findElement(By.xpath("//div[text()='Passengers']/following-sibling::div/div")).getText());




    }
}
