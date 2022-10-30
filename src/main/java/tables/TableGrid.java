package tables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TableGrid {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.cricbuzz.com/live-cricket-scorecard/43126/pak-vs-ned-29th-match-super-12-group-2-icc-mens-t20-world-cup-2022");
        Thread.sleep(2000L);

        //We need to accept cookies frame
        driver.switchTo().frame(driver.findElement(By.id("sp_message_iframe_666874")));
        driver.findElement(By.xpath("//div[contains(@class, 'mobile-reverse')]/div[2]/button")).click();

        //Parent to child transfer
        //We need to find the parent table of the values we want to process
        WebElement table = driver
                .findElement(By
                        .cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
        //We need to find the score column that we want to process
        List<WebElement> scores = table
                .findElements(By
                        .cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)"));

        //Initialize the sum for storing sum of the scores
        int totalValue = 0;

        //Get all the scores value except last 2 rows and stores in sum
        for (int i = 0; i < scores.size() - 2; i++) {
            totalValue += Integer.parseInt(scores.get(i).getText());
        }

        //Get the extras and put it on sum
        totalValue += Integer
                .parseInt(driver
                        .findElement(By.xpath("//div[text()='Extras']/following-sibling::div"))
                        .getText());

        System.out.println("Sum is: " + totalValue);

        //Get the total value from website
        int actualTotalValue = Integer
                .parseInt(driver
                                .findElement(By.xpath("//div[text()='Total']/following-sibling::div"))
                                .getText());

        //Verify if what we calculate matches with website total
        if (totalValue == actualTotalValue) {
            System.out.println("The result is correct!");
        } else {
            System.out.println("The result is incorrect!");
        }
    }
}
