package tek.bdd.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseSetup {

    // Create instance variable of ChromeDriver
    private static WebDriver driver; // change this to WebDriver from ChromeDriver.
   private final Properties properties = new Properties();
    // Create a consctructor called BaseSetup
    public BaseSetup(){
        // To read a property file. 1) File in system.
        //2: FileInputStream
        //3: Object of properties class to load.
        // File Location      System.getProperty("user.dir") return location

        try {
            String fileFilePath = System.getProperty("user.dir")
                    + "/src/test/resources/config/application-config.properties";
            File propertiesFile = new File(fileFilePath);
            FileInputStream propertyFileInputStream = new FileInputStream(propertiesFile);
            properties.load(propertyFileInputStream);

            System.out.println(properties.get("retail.ui.url"));
        } catch(IOException ex) {
        }
    }
    public void openBrowser(){
        // Implement opening Chrome browser
        // and navigate to retail app.
        // The code below will test the link to work with different browsers
        // Implement cross browser concept.
        // Read browser type from properties file
        String browserType = this.properties.getProperty("retail.browser.type"); //"chrome";
        // Read headless from properties file
        boolean isHeadless = Boolean.parseBoolean(this.properties.getProperty("retail.browser.headless"));
        if(browserType.equalsIgnoreCase("chrome")){
            // Create ChropmeOptions object
            ChromeOptions options = new ChromeOptions();
            if(isHeadless) options.addArguments("--headless");
            driver = new ChromeDriver(options);
        }
        else if (browserType.equalsIgnoreCase("edge")){
            // Create EdgeOptions object
            EdgeOptions options = new EdgeOptions();
            if(isHeadless) options.addArguments("--headless");
            driver = new EdgeDriver(options);
        }
        else if (browserType.equalsIgnoreCase("firefox")){
            // Create FirefoxOption object
            FirefoxOptions options = new FirefoxOptions();
            if(isHeadless) options.addArguments("--headless");
            driver = new FirefoxDriver(options);
        }

        else{
            throw new RuntimeException("Wrong browser type.");
        }
        //chrome = new ChromeDriver();
        driver.manage().window().maximize();
        //chrome.get("https://retail.tekschool-students.com/");
        // Get URL from property file
       String url = this.properties.getProperty("retail.ui.url");
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public WebDriver getChrome(){
        return driver;
    }
}
