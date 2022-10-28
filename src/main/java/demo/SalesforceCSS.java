package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SalesforceCSS {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://login.salesforce.com/");
        driver.findElement(By.cssSelector("input[id='username']")).sendKeys("css selector");
        driver.findElement(By.cssSelector("input[name='pw']")).sendKeys("password");
        driver.findElement(By.xpath("//form[@name='login']/input[2]")).click();
        driver.findElement(By.cssSelector("#Login")).click();

//        xpath= //tagName[@attribute='value']
//        css = tagName[attribute='value']
    }
}
