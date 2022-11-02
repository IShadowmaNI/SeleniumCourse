package sorting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableColumnSorting {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        //Bring full list to the view by changing page size
        Select s = new Select(driver.findElement(By.id("page-menu")));
        s.selectByValue("20");

        //We put the website list into ascending/descending order
        driver.findElement(By.cssSelector("tr th:nth-child(1)")).click();
        driver.findElement(By.cssSelector("tr th:nth-child(1)")).click();

        //We grab the column elements and put it into a list
        List<WebElement> firstColumnList = driver.findElements(By.cssSelector("tr td:nth-child(1)"));
        List<String> originalList = new ArrayList<>();

        //Iterate through web elements, grab the text and put it into an ArrayList
        for (WebElement element : firstColumnList) {
            originalList.add(element.getText());
        }

        //We make a copy of ArrayList and sort it
        List<String> copiedList = new ArrayList<>(originalList);
        Collections.sort(copiedList);

        //To sort in descending order
        Collections.reverse(copiedList);

        System.out.println("**************Original List*****************");
        System.out.println(originalList);
        System.out.println("**************Sorted List*****************");
        System.out.println(copiedList);

        //We check if the column is sorted or not in ascending order
        Assert.assertEquals(copiedList, originalList);


    }
}
