package dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        Select s = new Select(driver.findElement(By.cssSelector("#ctl00_mainContent_DropDownListCurrency")));
        s.selectByValue("AED");
        s.selectByIndex(3);
        s.selectByVisibleText("INR");
    }
}
