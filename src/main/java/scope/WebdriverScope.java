package scope;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebdriverScope {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //1. Give me the count of links on the page

        // We need to calculate links on default context - all that has tagName "a"
        int numberOfLinksInDefaultContext = driver
                .findElements(By.tagName("a"))
                .size();
        System.out.println("The number of links on the default context is: " + numberOfLinksInDefaultContext);

        //We need to calculate links on frame
        int numberOfLinksInFrame = driver
                .switchTo()
                .frame(0)
                .findElements(By.tagName("a"))
                .size();
        System.out.println("The number of links on the frame context is: " + numberOfLinksInFrame);

        //We need to calculate the sum of links in both contexts and print
        System.out.println("The number of links on the webpage is: " +
                (numberOfLinksInDefaultContext + numberOfLinksInFrame));

    }
}
