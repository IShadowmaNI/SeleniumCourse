package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Rediff {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rediff.com/");

        driver.findElement(By.cssSelector("a[title*='Sign in']")).click();

        driver
                .findElement(By.xpath("//input[contains(@id, 'login')]"))
                .sendKeys("xpath username");
        driver
                .findElement(By.cssSelector("input#password"))
                .sendKeys("xpath password");
        driver
                .findElement(By.xpath("//input[contains(@name, 'proc')]"))
                .click();
    }
}

