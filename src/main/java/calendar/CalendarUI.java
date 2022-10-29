package calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CalendarUI {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.path2usa.com/travel-companion/");
        Thread.sleep(3000L);

        //We need to set April-23-2023
        //We need to scroll to that specific element where we can click
        JavascriptExecutor jsx = (JavascriptExecutor)driver;
        jsx.executeScript("window.scrollBy(0,1000)", "");
        Thread.sleep(1000L);
        driver.findElement(By.cssSelector("#form-field-travel_comp_date")).click();

        //First we need to set the month and year
        //Logic would be to keep clicking next month until we reach april 2023
        while (!driver.findElement(By.className("cur-month")).getText().contains("April")) {
            driver.findElement(By.className("flatpickr-next-month")).click();
            //We need to add sleep because the program runs too fast with the changes on webpage
            Thread.sleep(1000L);
        }

        //Second we need to set the day
        //Grab the common attribute and put on the list
        List<WebElement> dates = driver.findElements(By.cssSelector(".flatpickr-day"));

        //We need to remove all the disabled dates because we will get “Element is not clickable at point” Exception
        dates.removeAll(driver.findElements(By.xpath("//span[contains(@class, 'disabled')]")));
        dates.removeAll(driver.findElements(By.xpath("//span[contains(@class, 'prevMonthDay')]")));

        //We go through the new list of dates and check for desired day number to click
        for (WebElement date : dates) {
            if (date.getText().equals("30")) {
                date.click();
                break;
            }
        }
    }
}
