package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RahulShettyAcademy {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.xpath("//header/div/a/following-sibling::button[1]")).click();
        driver.findElement(By.xpath("//header/div/a/following-sibling::button[2]")).click();
        driver.findElement(By.xpath("//header/div/a/following-sibling::button[3]")).click();
    }
}
