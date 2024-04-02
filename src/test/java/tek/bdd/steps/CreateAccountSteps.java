package tek.bdd.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import tek.bdd.pages.AccountProfilePage;
import tek.bdd.pages.LoginPage;
import tek.bdd.pages.SignUpPage;
import tek.bdd.utility.DataGeneratorUtility;
import tek.bdd.utility.SeleniumUtilities;

import java.util.List;
import java.util.Map;

public class CreateAccountSteps extends SeleniumUtilities {
   private String generatedRandomEmail;
    @Given("User clicks on Create Account")
    public void user_clicks_on_create_account() {
        clickElement(LoginPage.CREATE_ACCOUNT_LINK);

    }
    @When("User fills form {string} and {string} and {string}")
    public void user_fills_form_and_and(String name, String email, String password) {
        generatedRandomEmail = DataGeneratorUtility.randomEmail(email);
        sendTextToElement(SignUpPage.NAME_INPUT, name);
        sendTextToElement(SignUpPage.EMAIL_INPUT, generatedRandomEmail);
        sendTextToElement(SignUpPage.PASSWORD_INPUT, password);
        sendTextToElement(SignUpPage.CONFIRM_PASSWORD_INPUT, password);
    }
    @When("User fills up Sign Up form")
    public void user_fills_up_sign_up_form(DataTable dataTable) {
        // Converting Data Table to Map.
        Map<String, String> data = dataTable.asMap();
        String email = data.get("email");
        String name = data.get("name");
        String password = data.get("password");
        generatedRandomEmail = DataGeneratorUtility.randomEmail(email);
        sendTextToElement(SignUpPage.NAME_INPUT, name);
        sendTextToElement(SignUpPage.EMAIL_INPUT, generatedRandomEmail);
        sendTextToElement(SignUpPage.PASSWORD_INPUT, password);
        sendTextToElement(SignUpPage.CONFIRM_PASSWORD_INPUT, password);

    }
    @When("User fills up Sign Up form with List Map Data Table")
    public void user_fills_up_sign_up_form_with_list_map_data_table(io.cucumber.datatable.DataTable dataTable) {
       // Converting data table to List of maps.
        List<Map<String, String>> data = dataTable.asMaps();
        // Extract first row of data
        Map<String, String> dataMap = data.get(0);
        String email = dataMap.get("email");
        String name = dataMap.get("name");
        String password = dataMap.get("password");

        generatedRandomEmail = DataGeneratorUtility.randomEmail(email);
        sendTextToElement(SignUpPage.NAME_INPUT, name);
        sendTextToElement(SignUpPage.EMAIL_INPUT, generatedRandomEmail);
        sendTextToElement(SignUpPage.PASSWORD_INPUT, password);
        sendTextToElement(SignUpPage.CONFIRM_PASSWORD_INPUT, password);

    }
    @When("User fills up Sign Up form with List Data Table")
    public void user_fills_up_sign_up_form_with_list_data_table(DataTable dataTable) {
       // This example used List of data. Converting data Table to List.
        // This is not recommended to fill up the form because you do not know
        // What information goes to the form.
        List<String> data = dataTable.asList();
        String name = data.get(0);
        String email = data.get(1);
        String password = data.get(2);

        generatedRandomEmail = DataGeneratorUtility.randomEmail(email);
        sendTextToElement(SignUpPage.NAME_INPUT, name);
        sendTextToElement(SignUpPage.EMAIL_INPUT, generatedRandomEmail);
        sendTextToElement(SignUpPage.PASSWORD_INPUT, password);
        sendTextToElement(SignUpPage.CONFIRM_PASSWORD_INPUT, password);
    }
    @When("User fills up Sign Up form with List of List Data Table")
    public void user_fills_up_sign_up_form_with_list_of_list_data_table(DataTable dataTable) {
        // Convert data table to list of list asLists();
        List<List<String>> rawData = dataTable.asLists();
        // Extract first row of List
        List<String> data = rawData.get(0);
        String name = data.get(0);
        String email = data.get(1);
        String password = data.get(2);

        generatedRandomEmail = DataGeneratorUtility.randomEmail(email);
        sendTextToElement(SignUpPage.NAME_INPUT, name);
        sendTextToElement(SignUpPage.EMAIL_INPUT, generatedRandomEmail);
        sendTextToElement(SignUpPage.PASSWORD_INPUT, password);
        sendTextToElement(SignUpPage.CONFIRM_PASSWORD_INPUT, password);
    }
    @When("User clicks on Sign Up button")
    public void user_clicks_on_sign_up_button() {
        clickElement(SignUpPage.SIGN_UP_BUTTON);

    }
    @When("user will navigate to Account Profile page")
    public void user_will_navigate_to_account_profile_page() {
        boolean isDisplayed = isElementDisplayed(AccountProfilePage.YOUR_PROFILE_TEXT);
        Assert.assertTrue(isDisplayed);

    }
    @Then("Validate {string} and email in account page")
    public void validate_and_in_account_page(String expectedName) {
        String actualName = getElementText(AccountProfilePage.PROFILE_NAME_TEXT);
        Assert.assertEquals(expectedName, actualName);

       String actualEmail = getElementText(AccountProfilePage.PROFILE_EMAIL_TEXT);
       Assert.assertEquals(generatedRandomEmail, actualEmail);
    }
}
