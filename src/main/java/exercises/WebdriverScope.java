package exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class WebdriverScope {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //1. Give me the count of links on the page

        // We need to calculate links on default content - all that has tagName "a"
        int numberOfLinksInDefaultContext = driver
                .findElements(By.tagName("a"))
                .size();
        System.out.println("The number of links on the default content is: " + numberOfLinksInDefaultContext);

        //We need to calculate links on frame
        int numberOfLinksInFrame = driver
                .switchTo()
                .frame(0)
                .findElements(By.tagName("a"))
                .size();
        System.out.println("The number of links on the frame content is: " + numberOfLinksInFrame);

        //We need to calculate the sum of links in both contexts and print
        System.out.println("The number of links on the webpage is: " +
                (numberOfLinksInDefaultContext + numberOfLinksInFrame));

        //Switching driver back to default content (main webpage)
        driver.switchTo().defaultContent();

        //******************************************************************************************************

        //2. Give me the count of links in footer section

        //Limiting webDriver scope - we need to create a miniDriver that has only certain scope - footer in this case
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));

        //We print the nr of links in footer
        System.out.println("The number of links on the footer section of the page is: " +
                footerDriver.findElements(By.tagName("a")).size());

        //******************************************************************************************************

        //3. Give me the count of links in footer section - first column links

        //We need to limit the scope again to first column
        WebElement firstColumnFooterDriver = footerDriver.findElement(By.xpath("table/tbody/tr/td[1]"));

        //Now we can print the links fromm first column
        System.out.println("The number of links on the first column of the footer section is: " +
                firstColumnFooterDriver.findElements(By.tagName("a")).size());

        //******************************************************************************************************

        //4. Click on each link in the column and check if the pages are opening

        int size = firstColumnFooterDriver.findElements(By.tagName("a")).size();

        //We define combination of keys to open in different tab
        String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);

        //We iterate through links (except first link that isn't working xD)
        for (int i = 1; i < size; i++) {

            //We use the combination defined
            firstColumnFooterDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);

            //We need to add wait for all pages to get loaded
            Thread.sleep(1000L);
        }

        //******************************************************************************************************

        //5. Print title on each tab opened

        Set<String> windows = driver.getWindowHandles();

        for (String window : windows) {
            driver.switchTo().window(window);
            System.out.println(driver.getTitle());
        }
    }
}
