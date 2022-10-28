package frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameTest {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://jqueryui.com/droppable/");
//        driver.switchTo().frame(1);
        System.out.println(driver.findElements(By.tagName("iframe")).size());

        //Switch to frame by using id
        driver.switchTo().frame(0);

        //Switch to frame by using web element
//        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
//        driver.findElement(By.id("draggable")).click();
        Actions a = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        a.dragAndDrop(source, target)
                .build()
                .perform();

        //Switch back to main webpage
        driver.switchTo().defaultContent();

    }
}
