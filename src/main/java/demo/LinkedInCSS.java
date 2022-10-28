package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkedInCSS {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

        // tagName[attribute='value'] - css syntax
        driver
                .findElement(By.cssSelector("[autocomplete='username']"))
                .sendKeys("my own css");
        driver
                .findElement(By.cssSelector("input[autocomplete='current-password']"))
                .sendKeys("password");
        driver
                .findElement(By.cssSelector("button[class='sign-in-form__submit-button']"))
                .click();
    }
}
