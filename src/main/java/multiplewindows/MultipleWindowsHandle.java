package multiplewindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class MultipleWindowsHandle {

    public static void main(String[] args) {

        //How to handle multiple windows in Selenium - interview question

        System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://accounts.google.com/signup");
        driver.findElement(By.xpath("//ul[@class='Bgzgmd']/li[2]/a")).click();
        System.out.println(driver.getTitle());

        //We need to get list of windows
        Set<String> ids = driver.getWindowHandles();
        //Need to define iterator
        Iterator<String> it = ids.iterator();
        //We go through iterator and assign ids to windows
        String parentId = it.next();
        String childId = it.next();

        //Now we switch to desired window by using id
        driver.switchTo().window(childId);
        System.out.println(driver.getTitle());

        driver.switchTo().window(parentId);
        System.out.println(driver.getTitle());

    }
}
