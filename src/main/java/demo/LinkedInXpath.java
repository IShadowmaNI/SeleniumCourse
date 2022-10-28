package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkedInXpath {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

        // //tagName[@attribute='value'] - xpath syntax
        driver
                .findElement(By.xpath("//input[@autocomplete='username']"))
                .sendKeys("my own xpath");
        driver
                .findElement(By.xpath("//input[@autocomplete='current-password']"))
                .sendKeys("password");
        driver
                .findElement(By.xpath("//button[@class='sign-in-form__submit-button']"))
                .click();
    }

}
