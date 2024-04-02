package tek.bdd.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import tek.bdd.pages.HomePage;
import tek.bdd.pages.LoginPage;
import tek.bdd.utility.SeleniumUtilities;

public class ValidateTestSteps extends SeleniumUtilities {
    @Given("User clicks on Sign In button")
    public void userClicksOnSignOnButton() {
        clickElement(HomePage.SIGN_IN_BUTTON);
    }
    @When("User enters invalid username")
    public void userEntersInvalidUsername() {
        sendTextToElement(LoginPage.EMAIL_INPUT,"Hejaz_510@yahoo.com");
    }
    @When("User enters valid password")
    public void userEntersValidPassword() {
        sendTextToElement(LoginPage.PASSWORD_INPUT,"Lolo_7866@&");
        clickElement(LoginPage.LOGIN_BUTTON);
    }
    @Then("User will see an error message\"wrong username or password\"")
    public void userGetsAnErrorMessage() {
        boolean isDisplayed = isElementDisplayed(HomePage.CLASS_Locator);
        Assert.assertTrue(isDisplayed);

    }
}
