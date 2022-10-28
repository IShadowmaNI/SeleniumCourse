package e2e;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class EndToEndAutomation {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Need to add wait amount of seconds because of the loading page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.spicejet.com/");

        //For select FROM and TO:
        driver.findElement(By.xpath("//body/div[@id='react-root']/div[@id='main-container']/div[1]/div[1]/div[3]/div[2]/div[3]/div[1]/div[1]/div[1]/div[2]/input[1]")).click();
        driver.findElement(By.xpath("//div[contains(text(), 'DEL')]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//div[contains(text(),'MAA')]")).click();

        //For select depart date:
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='react-root']/div[@id='main-container']/div[1]/div[1]/div[3]/div[2]/div[4]/div[1]/div[2]/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[3]/div[4]/div[7]/div[1]/div[1]")));
        driver.findElement(By.xpath("//body/div[@id='react-root']/div[@id='main-container']/div[1]/div[1]/div[3]/div[2]/div[4]/div[1]/div[2]/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[3]/div[4]/div[7]/div[1]/div[1]")).click();

        //Test to check if return date is disabled:
        if (driver.findElement(By.xpath("//div[contains(text(),'Return Date')]")).getAttribute("style").contains("0.5")) {
            System.out.println("is disabled");
            Assert.assertTrue(true);
        } else {
            System.out.println("is enabled");
            Assert.assertTrue(false);
        }

        //Selecting passengers:
        System.out.println(driver.findElement(By.xpath("//div[text()='Passengers']/following-sibling::div/div")).getText());
        driver.findElement(By.xpath("//div[text()='Passengers']")).click();
        for (int i = 0; i < 4; i++) {
            driver.findElement(By.xpath("//body/div[@id='react-root']/div[@id='main-container']/div[1]/div[1]/div[3]/div[2]/div[5]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[3]/*[1]")).click();
        }
        driver.findElement(By.xpath("//div[text()='Passengers']")).click();
        System.out.println(driver.findElement(By.xpath("//div[text()='Passengers']/following-sibling::div/div")).getText());

        //Click on checkbox:
        driver.findElement(By.xpath("//div[contains(text(), 'Family & Friends')]/parent::div/parent::div/div")).click();

        //Click on search button
        driver.findElement(By.xpath("//div[contains(text(), 'Search Flight')]/parent::div")).click();

    }
}
