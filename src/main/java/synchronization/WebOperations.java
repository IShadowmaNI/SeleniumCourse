package synchronization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class WebOperations {

    public static void addItems(WebDriver driver, String[] items) {

        //Get all the products and make a list
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        int nrItems = 0;

        //Iterate through all products
        for (int i = 0; i < products.size(); i++) {
            //Get the name and format it to get actual vegetable name
            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim();

            //Convert array into array list for easy search
            List<String> listItems = Arrays.asList(items);

            //Check whatever name you extracted is present in array or not
            if (listItems.contains(formattedName)) {
                //Click on Add to cart
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

                nrItems++;

                if (nrItems == listItems.size()) {
                    break;
                }
            }
        }
    }
}
