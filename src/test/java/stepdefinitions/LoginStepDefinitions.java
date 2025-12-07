package stepdefinitions;

import org.testng.Assert;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginStepDefinitions extends BaseClass {
    LoginPage loginPage;

    @Given("User visited the portal")
    public void user_visited_the_portal() {
        // Driver initialization and navigation is handled in Hooks -> BaseClass
        loginPage = new LoginPage();
    }

    @When("User inputs valid {string} and {string}")
    public void user_inputs_valid_and(String username, String password) {
        loginPage.doLogin(username, password);
    }

    @Then("User can see error message")
    public void user_can_see_error_message() {
        Assert.assertTrue(loginPage.lblValidationError.getText().contains("Invalid credentials"));
    }

    @Then("User can visit the dashboard")
    public void userCanVisitTheDashboard() throws InterruptedException {
    	Thread.sleep(2000); 
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }
}
