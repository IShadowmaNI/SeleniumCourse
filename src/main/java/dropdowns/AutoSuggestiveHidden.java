package dropdowns;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveHidden {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ksrtc.in/");

        WebElement leavingFrom = driver.findElement(By.xpath("//input[@id='fromPlaceName']"));
        leavingFrom.click();
        leavingFrom.sendKeys("CHE");
        Thread.sleep(1000L);

        //Javascript DOM can extract hidden elements because Selenium cannot identify hidden elements (Ajax impl)
        //Investigate the properties of object if it has any hidden text
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "return document.getElementById(\"fromPlaceName\").value;";
        String result = (String) js.executeScript(script);
        System.out.println(result);
        int count = 0;

        //PONDICHERRY
        while (!result.equalsIgnoreCase("PONDICHERRY")) {
            count++;
            leavingFrom.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(1000L);
            result = (String) js.executeScript(script);
            System.out.println(result);

            if (count > 10) {
                break;
            }
        }

        if (count > 10) {
            System.out.println("Element not found!");
        } else {
            System.out.println("Element found!");
        }

        leavingFrom.sendKeys(Keys.ENTER);
    }
}
