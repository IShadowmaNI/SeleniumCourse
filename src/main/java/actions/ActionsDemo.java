package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

    public static void main(String[] args) {

        //How to MouseOver an object with Selenium - by using Actions class

        System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com/");
        Actions a = new Actions(driver);
        WebElement move = driver.findElement(By.cssSelector("a[id*='accountList']"));

        //Moves to specific element
        a.moveToElement(move)
                .contextClick() //Right-click
                .build()
                .perform();

        //Write on search box with capital letters and select text
        a.moveToElement(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")))
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("hello")
                .doubleClick()
                .build()
                .perform();

        //todo: Drag and drop
    }
}
