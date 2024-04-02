package tek.bdd.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tek.bdd.base.BaseSetup;

import java.time.Duration;

public class SeleniumUtilities extends BaseSetup {
    private WebDriverWait getWait(){
        WebDriverWait wait = new WebDriverWait(getChrome(), Duration.ofSeconds(10));
        return wait;
    }
    // Create A method "clickElement" that takes By
    // object and click on element
    public void clickElement(By locator){

        getWait().until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    public String getElementText(By locator) {
        String text = getWait().until(ExpectedConditions
                .visibilityOfElementLocated(locator)).getText();
        return text;
    }
    public boolean isElementEnabled(By locator){
        boolean isEnabled = getWait().until(ExpectedConditions
                .presenceOfElementLocated(locator)).isEnabled();
        return isEnabled;
    }
    public void sendTextToElement(By locator, String text){
        getWait().until(ExpectedConditions.visibilityOfElementLocated(locator))
                .sendKeys(text);
    }
    public boolean isElementDisplayed(By locator){
        // Using return in one line
        return getWait().until(ExpectedConditions
                .visibilityOfElementLocated(locator))
                .isDisplayed();
    }

}
