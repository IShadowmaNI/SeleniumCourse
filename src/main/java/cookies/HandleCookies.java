package cookies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCookies {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //How to delete all cookies in certain scenarios where we run script for 1 min, then we want to delete cookies
        driver.manage().deleteAllCookies();

        //How to delete certain cookie
//        driver.manage().deleteCookieNamed("sessionKey");

        //Click on any link
        // Login page - verify login URL

        driver.get("https://google.com");
    }
}
