package tek.bdd.steps;
import io.cucumber.java.After;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import tek.bdd.utility.SeleniumUtilities;

import java.time.Duration;

public class HookSteps extends SeleniumUtilities {
    // Hook that run before each scenario
    @Before
    public void initiateTest(){
        openBrowser();
    }
    // Hook will execute after each scenario
    // no matter what happened to scenario
   @After
    public void closingTest(Scenario scenario){
        // Take screenshot only if the test fails.
        if(scenario.isFailed()){
            // This is how we take screenshot
            TakesScreenshot screenshot = (TakesScreenshot) getChrome();
            byte[] capture = screenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(capture, "image/png", "screenshot");
        }

       getChrome().quit();

    }
}
