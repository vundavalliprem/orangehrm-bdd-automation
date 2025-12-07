package stepdefinitions;



import org.json.simple.JSONObject;
import org.testng.Assert;
import base.BaseClass;
import pages.MyInfoPersonalDetailsPage;
import utils.JsonUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyInfoPersonalDetailsStepDefinitions extends BaseClass {
    MyInfoPersonalDetailsPage myInfoPersonalDetailsPage;

    @When("User navigates to My Info Personal Details page")
    public void userNavigatesToMyInfoPersonalDetailsPage() {
        myInfoPersonalDetailsPage = new MyInfoPersonalDetailsPage();
        myInfoPersonalDetailsPage.navigateToMyInfoPersonalDetails();
    }

    @And("User updates personal details {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void userUpdatesPersonalDetails(String firstName, String middleName, String lastName, 
                                          String empId, String otherId, String license, String licenseExpiry) {
        myInfoPersonalDetailsPage.fillPersonalDetails(firstName, middleName, lastName, empId, otherId, license, licenseExpiry);
    }

    @And("User selects nationality {string}")
    public void userSelectsNationality(String nationality) {
        myInfoPersonalDetailsPage.selectNationality(nationality);
    }

    @And("User selects marital status {string}")
    public void userSelectsMaritalStatus(String maritalStatus) {
        myInfoPersonalDetailsPage.selectMaritalStatus(maritalStatus);
    }

    @And("User enters date of birth {string}")
    public void userEntersDateOfBirth(String dob) {
        myInfoPersonalDetailsPage.enterDateOfBirth(dob);
    }

    @And("User selects gender {string}")
    public void userSelectsGender(String gender) throws InterruptedException {
        myInfoPersonalDetailsPage.selectGender(gender);
    }

    @And("User saves personal details")
    public void userSavesPersonalDetails() throws InterruptedException {
        myInfoPersonalDetailsPage.savePersonalDetails();
    }

    @And("User updates custom fields {string}, {string}")
    public void userUpdatesCustomFields(String bloodType, String testField) {
        myInfoPersonalDetailsPage.fillCustomFields(bloodType, testField);
    }

    @And("User saves custom fields")
    public void userSavesCustomFields() throws InterruptedException {
        myInfoPersonalDetailsPage.saveCustomFields();
    }

    @And("User adds attachment {string} with comment {string}")
    public void userAddsAttachment(String filePath, String comment) throws InterruptedException {
        myInfoPersonalDetailsPage.addAttachment(filePath, comment);
    }

    @And("User saves attachment")
    public void userSavesAttachment() throws InterruptedException {
        myInfoPersonalDetailsPage.saveAttachment();
    }

    @And("User updates personal details from test data {string}")
    public void userUpdatesPersonalDetailsFromTestData(String testDataId) throws InterruptedException {
        JSONObject employeeData = JsonUtils.readJSON("src/test/resources/testdata/employees.json", testDataId);
        
        String firstName = (String) employeeData.get("firstName");
        String middleName = (String) employeeData.get("middleName");
        String lastName = (String) employeeData.get("lastName");
        String employeeId = (String) employeeData.get("employeeId");
        String otherId = (String) employeeData.get("otherId");
        String license = (String) employeeData.get("licenseNumber");
        String licenseExpiry = (String) employeeData.get("licenseExpiry");
        String nationality = (String) employeeData.get("nationality");
        String maritalStatus = (String) employeeData.get("maritalStatus");
        String dob = (String) employeeData.get("dateOfBirth");
        String gender = (String) employeeData.get("gender");
        String bloodType = (String) employeeData.get("bloodType");
        String testField = (String) employeeData.get("testField");
        String attachmentFilePath = (String) employeeData.get("attachmentFilePath");
        String attachmentComment = (String) employeeData.get("attachmentComment");
        
        myInfoPersonalDetailsPage.fillPersonalDetails(firstName, middleName, lastName, employeeId, otherId, license, licenseExpiry);
        myInfoPersonalDetailsPage.selectNationality(nationality);
        myInfoPersonalDetailsPage.selectMaritalStatus(maritalStatus);
        myInfoPersonalDetailsPage.enterDateOfBirth(dob);
        myInfoPersonalDetailsPage.selectGender(gender);
        //Thread.sleep(2000);
        myInfoPersonalDetailsPage.savePersonalDetails();
        
        myInfoPersonalDetailsPage.fillCustomFields(bloodType, testField);
        myInfoPersonalDetailsPage.saveCustomFields();
        
        myInfoPersonalDetailsPage.addAttachment(attachmentFilePath, attachmentComment);
        myInfoPersonalDetailsPage.saveAttachment();
    }

    @Then("Personal details should be updated successfully")
    public void personalDetailsShouldBeUpdatedSuccessfully() {
        Assert.assertTrue(myInfoPersonalDetailsPage.isDetailsUpdated(), 
                         "Personal details were not updated successfully");
    }
}
