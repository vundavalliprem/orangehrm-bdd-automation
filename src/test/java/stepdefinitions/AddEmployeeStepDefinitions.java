	package stepdefinitions;
	
	import org.json.simple.JSONObject;
import org.testng.Assert;

import base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddEmployeePage;
import  pages.DashboardPage;
import  utils.JsonUtils;
import  utils.WaitUtils;
	
	public class AddEmployeeStepDefinitions extends BaseClass {
		 DashboardPage dashboardPage;
		    AddEmployeePage addEmployeePage;
	
		    @When("User navigates to Add Employee page")
		    public void userNavigatesToAddEmployeePage() {
		        addEmployeePage = new AddEmployeePage();
		        addEmployeePage.menuPIM.click();
		        addEmployeePage.btnAddEmployee.click();
		    }
	
		    // APPROACH 1: Using Examples - Simple parameters
		    @And("User enters employee details {string}, {string}, {string}, {string}")
		    public void userEntersEmployeeDetails(String firstName, String middleName, String lastName, String empId) {
		        addEmployeePage.txtFirstName.sendKeys(firstName);
		        addEmployeePage.txtMiddleName.sendKeys(middleName);
		        addEmployeePage.txtLastName.sendKeys(lastName);
		        addEmployeePage.txtEmployeeId.clear();
		        addEmployeePage.txtEmployeeId.sendKeys(empId);
		   
		    
		
		    
		    }
		    
		 
		    @And("User clicks save button")
		    public void userClicksSaveButton() throws InterruptedException {
		        WaitUtils.waitForElementClickable(addEmployeePage.btnSave, 10);
		        addEmployeePage.btnSave.click();
		        Thread.sleep(5000);
		    }
	
		    // Toggle step - Enable create login details
		    @And("User enables create login details")
		    public void userEnablesCreateLoginDetails() {
		        WaitUtils.waitForElementClickable(addEmployeePage.toggleCreateLoginDetails, 10);
		        addEmployeePage.toggleCreateLoginDetails.click();
		    }
	
		    // Enter login credentials step
		    @And("User enters login credentials {string} and {string}")
		    public void userEntersLoginCredentials(String username, String password) {
		        WaitUtils.waitForElementVisible(addEmployeePage.txtUsername, 10);
		        addEmployeePage.txtUsername.sendKeys(username);
		        addEmployeePage.txtPassword.sendKeys(password);
		        addEmployeePage.txtConfirmPassword.sendKeys(password);
		    }
	
		    // APPROACH 2: Using JSON Test Data - Real-time Best Practice
		    @And("User adds employee from test data {string}")
		    public void userAddsEmployeeFromTestData(String testDataId) throws InterruptedException {
		        addEmployeePage = new AddEmployeePage();
		        
		        // Read employee data from JSON
		        JSONObject employeeData = JsonUtils.readJSON("src/test/resources/testdata/employees.json", testDataId);
		        
		        String firstName = (String) employeeData.get("firstName");
		        String middleName = (String) employeeData.get("middleName");
		        String lastName = (String) employeeData.get("lastName");
		        String employeeId = (String) employeeData.get("employeeId");
		        boolean createLogin = (boolean) employeeData.get("createLogin");
		        String username = (String) employeeData.get("username");
		        String password = (String) employeeData.get("password");
		        
		        // Use the page object method
		        addEmployeePage.addEmployee(firstName, middleName, lastName, employeeId, 
		                                    createLogin, username, password);
		        
		        
		        // Now click save button
		        WaitUtils.waitForElementClickable(addEmployeePage.btnSave, 10);
		        addEmployeePage.btnSave.click();
		        Thread.sleep(6000);
		    }
	
		    @Then("Employee should be added successfully")
		    public void employeeShouldBeAddedSuccessfully() throws InterruptedException {
		        Thread.sleep(2000); // Wait for save to complete
		      //  Assert.assertTrue(addEmployeePage.isEmployeeAdded(), 
		       //"Employee was not added successfully");
		    
		        // Debug: Print current URL
		        String currentUrl = driver.getCurrentUrl();
		        System.out.println("DEBUG: Current URL after save: " + currentUrl);
		        
		        Assert.assertTrue(addEmployeePage.isEmployeeAdded(), 
		                         "Employee was not added successfully. Current URL: " + currentUrl);
		    
		    
		    
		    }
	
		    @And("Employee login should be created")
		    public void employeeLoginShouldBeCreated() {
		        // Verify that login details section is visible or URL contains personal details
		        Assert.assertTrue(driver.getCurrentUrl().contains("personalDetails") || 
		                         driver.getCurrentUrl().contains("viewPersonalDetails"),
		                         "Employee login was not created");
	    }
	}
