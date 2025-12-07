package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class MyInfoPersonalDetailsPage extends BaseClass {

	// Navigation - My Info menu
	@FindBy(xpath = "//span[text()='My Info']")
	public WebElement menuMyInfo;

	// Personal Details Section
	@FindBy(css = "input[placeholder='First Name']")
	public WebElement txtFirstName;

	@FindBy(css = "input[placeholder='Middle Name']")
	public WebElement txtMiddleName;

	@FindBy(css = "input[placeholder='Last Name']")
	public WebElement txtLastName;

	@FindBy(xpath = "//label[text()='Employee Id']/following::input[1]")
	public WebElement txtEmployeeId;

	@FindBy(xpath = "//label[text()='Other Id']/following::input[1]")
	public WebElement txtOtherId;

	@FindBy(xpath = "//label[text()=\"Driver's License Number\"]/following::input[1]")
	public WebElement txtLicenseNumber;

	@FindBy(xpath = "//label[text()='License Expiry Date']/following::input[1]")
	public WebElement txtLicenseExpiry;

	// Nationality dropdown
	@FindBy(xpath = "//label[text()='Nationality']/following::div[contains(@class,'oxd-select-text-input')][1]")
	public WebElement dropdownNationality;

	// Marital Status dropdown
	@FindBy(xpath = "//label[text()='Marital Status']/following::div[contains(@class,'oxd-select-text-input')][1]")
	public WebElement dropdownMaritalStatus;

	// Date of Birth
	@FindBy(xpath = "//label[text()='Date of Birth']/following::input[1]")
	public WebElement txtDateOfBirth;

	// Gender radio buttons
	@FindBy(xpath = "//label[text()='Male']/span")
	public WebElement radioMale;

	@FindBy(xpath = "//label[text()='Female']/span")
	public WebElement radioFemale;

	// Save button for Personal Details (first save button)
	@FindBy(xpath = "(//button[@type='submit'])[1]")
	public WebElement btnSavePersonalDetails;

	// Custom Fields Section
	@FindBy(xpath = "//label[text()='Blood Type']/following::div[contains(@class,'oxd-select-text-input')][1]")
	public WebElement dropdownBloodType;

	@FindBy(xpath = "//label[text()='Test_Field']/following::input[1]")
	public WebElement txtTestField;

	// Save button for Custom Fields (second save button)
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	public WebElement btnSaveCustomFields;

	// Attachments Section
	@FindBy(xpath = "//button[text()=' Add ']")
	public WebElement btnAddAttachment;
	@FindBy(xpath = "//input[@type='file']")
	public WebElement inputFile;

	@FindBy(xpath = "//textarea[@placeholder='Type comment here']")
	public WebElement txtAttachmentComment;

	@FindBy(xpath = "//h6[text()='Add Attachment']/following::button[@type='submit'][1]")
	public WebElement btnSaveAttachment;

	// Constructor
	public MyInfoPersonalDetailsPage() {
		PageFactory.initElements(driver, this);
	}

	public void navigateToMyInfoPersonalDetails() {
		menuMyInfo.click();
	}

	// Helper method to clear field reliably
	private void clearAndEnter(WebElement element, String value) {
		element.click();
		element.sendKeys(Keys.CONTROL + "a");
		element.sendKeys(Keys.BACK_SPACE);
		element.sendKeys(value);
	}

	public void fillPersonalDetails(String firstName, String middleName, String lastName, String empId, String otherId,
			String license, String licenseExpiry) {
		clearAndEnter(txtFirstName, firstName);
		clearAndEnter(txtMiddleName, middleName);
		clearAndEnter(txtLastName, lastName);
		clearAndEnter(txtEmployeeId, empId);
		clearAndEnter(txtOtherId, otherId);
		clearAndEnter(txtLicenseNumber, license);
		clearAndEnter(txtLicenseExpiry, licenseExpiry);
	}

	public void selectNationality(String nationality) {
		dropdownNationality.click();
		WebElement option = driver.findElement(By.xpath("//div[@role='option']//span[text()='" + nationality + "']"));
		option.click();
	}

	public void selectMaritalStatus(String maritalStatus) {
		dropdownMaritalStatus.click();
		WebElement option = driver.findElement(By.xpath("//div[@role='option']//span[text()='" + maritalStatus + "']"));
		option.click();
	}

	 public void enterDateOfBirth(String dob) {
	        txtDateOfBirth.click();
	        txtDateOfBirth.sendKeys(Keys.CONTROL + "a");
	        txtDateOfBirth.sendKeys(Keys.BACK_SPACE);
	        txtDateOfBirth.sendKeys(dob);
	    }

	 public void selectGender(String gender) throws InterruptedException {
		    Thread.sleep(1000);
		    ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("window.scrollBy(0, -200);");
		    Thread.sleep(500);
		    
		    if (gender.equalsIgnoreCase("Male")) {
		        radioMale.click();
		    } else if (gender.equalsIgnoreCase("Female")) {
		        radioFemale.click();
		    }
		}
	    
	    
	    
	    
	    
	public void savePersonalDetails() throws InterruptedException {
		btnSavePersonalDetails.click();
		Thread.sleep(3000);
	}

	public void fillCustomFields(String bloodType, String testField) {
		dropdownBloodType.click();
		WebElement option = driver.findElement(By.xpath("//div[@role='option']//span[text()='" + bloodType + "']"));
		option.click();

		clearAndEnter(txtTestField, testField);
	}

	public void saveCustomFields() throws InterruptedException {
		btnSaveCustomFields.click();
		Thread.sleep(3000);
	}

	public void addAttachment(String filePath, String comment) throws InterruptedException {
	    // Scroll to attachment section
	    ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btnAddAttachment);
	    Thread.sleep(500);
	    
	    btnAddAttachment.click();
	    Thread.sleep(2000);
	    
	    inputFile.sendKeys(filePath);
	    Thread.sleep(1000);
	    
	    txtAttachmentComment.sendKeys(comment);
	}
	public void saveAttachment() throws InterruptedException {
		btnSaveAttachment.click();
		Thread.sleep(3000);
	}

	public boolean isDetailsUpdated() {
		return driver.getCurrentUrl().contains("viewPersonalDetails")
				|| driver.getCurrentUrl().contains("personalDetails");
	}
}
