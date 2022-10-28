package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

    public static void main(String[] args) {

        //Create Driver object for Chrome Browser
        //We will strictly implement methods of WebDriver interface
        //Invoke .exe file first

        System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com"); //Hit url on the browser
        System.out.println(driver.getTitle()); //validate if your page title is correct

        System.out.println(driver.getCurrentUrl()); //validate if you are landed on correct url

//        System.out.println(driver.getPageSource()); //print page source

        driver.get("http://yahoo.com");
        driver.navigate().back();
        driver.navigate().forward();
        driver.close(); //It closes current browser
        driver.quit(); //It closes all the browser opened by selenium script
    }
}
