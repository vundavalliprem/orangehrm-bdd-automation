package pages;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployeePage extends BaseClass {
	
	
	

    // Navigation elements
    @FindBy(xpath = "//span[text()='PIM']")
    public WebElement menuPIM;
    
    @FindBy(xpath = "//a[text()='Add Employee']")
    public WebElement btnAddEmployee;

    // First Name
    @FindBy(xpath = "//label[text()='Employee Full Name']/following::input[contains(@class,'orangehrm-firstname')]")
    public WebElement txtFirstName;

    // Middle Name
    @FindBy(xpath = "//input[contains(@class,'orangehrm-middlename')]")
    public WebElement txtMiddleName;

    // Last Name
    @FindBy(xpath = "//input[contains(@class,'orangehrm-lastname')]")
    public WebElement txtLastName;

    // Employee ID
    @FindBy(xpath = "//label[text()='Employee Id']/following::input[1]")
    public WebElement txtEmployeeId;

    // Toggle or radio button "Create Login Details"
    @FindBy(xpath = "//p[text()='Create Login Details']/following-sibling::div//span[contains(@class,'oxd-switch-input')]")
    public WebElement toggleCreateLoginDetails;

    // Username
    @FindBy(xpath = "//label[text()='Username']/following::input[1]")
    public WebElement txtUsername;

    // Password
    @FindBy(xpath = "//label[text()='Password']/following::input[@type='password'][1]")
    public WebElement txtPassword;

    // Confirm Password
    @FindBy(xpath = "//label[text()='Confirm Password']/following::input[@type='password'][1]")
    public WebElement txtConfirmPassword;

    // Save Button
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement btnSave;

  
    // Constructor
    public AddEmployeePage() {
        PageFactory.initElements(driver, this);
    }

    // Method to fill employee details
    public void addEmployee(String firstName, String middleName, String lastName, String empId,
            boolean createLogin, String username, String password) {

txtFirstName.sendKeys(firstName);
txtMiddleName.sendKeys(middleName);
txtLastName.sendKeys(lastName);
txtEmployeeId.clear();
txtEmployeeId.sendKeys(empId);

if (createLogin) {
toggleCreateLoginDetails.click();
txtUsername.sendKeys(username);
txtPassword.sendKeys(password);
txtConfirmPassword.sendKeys(password);
}

       
    }

    public boolean isEmployeeAdded() {
        // Check if URL changed to personal details page (more reliable than toast)
        return driver.getCurrentUrl().contains("viewPersonalDetails") || 
               driver.getCurrentUrl().contains("personalDetails");    }
}
