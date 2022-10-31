package certifications;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SSLCertification {

    public static void main(String[] args) {

        //SSL certificates - writing code that will manage warning page and accept insecure certificates

        //Desired capabilities
        //General chrome profile
        DesiredCapabilities ch = new DesiredCapabilities();
//        ch.acceptInsecureCerts();
        //Another way to define insecure
        ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

        //Bellows to your local browser
        ChromeOptions c = new ChromeOptions();
        c.merge(ch);

        System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver\\chromedriver.exe");
        //We pass the c to driver created
        WebDriver driver = new ChromeDriver(c);
    }
}
