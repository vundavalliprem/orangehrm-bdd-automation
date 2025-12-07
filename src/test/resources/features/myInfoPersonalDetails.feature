Feature: My Info - Personal Details Tab

  Background:
    Given User visited the portal
    When User inputs valid "Admin" and "admin123"
    Then User can visit the dashboard

  Scenario: Update personal details, custom fields, and upload attachment
    When User navigates to My Info Personal Details page
    And User updates personal details "John", "Michael", "Doe", "EMP123", "OTH456", "DL456789", "2025-12-31"
    And User selects nationality "Indian"
    And User selects marital status "Single"
    And User enters date of birth "1990-05-15"
    And User selects gender "Male"
    And User saves personal details
    And User updates custom fields "A+", "TestValue123"
    And User saves custom fields
    And User adds attachment "C:/Users/vunda/OneDrive/Desktop/photo1.jpeg" with comment "Test attachment upload"
    And User saves attachment
    Then Personal details should be updated successfully

  Scenario Outline: Update personal details using Examples
    When User navigates to My Info Personal Details page
    And User updates personal details "<firstName>", "<middleName>", "<lastName>", "<empId>", "<otherId>", "<license>", "<licenseExpiry>"
    And User selects nationality "<nationality>"
    And User selects marital status "<maritalStatus>"
    And User enters date of birth "<dob>"
    And User selects gender "<gender>"
    And User saves personal details
    And User updates custom fields "<bloodType>", "<testField>"
    And User saves custom fields
    And User adds attachment "<filePath>" with comment "<comment>"
    And User saves attachment
    Then Personal details should be updated successfully

    Examples:
      | firstName | middleName | lastName | empId | otherId | license  | licenseExpiry | nationality | maritalStatus | dob        | gender | bloodType | testField | filePath                                       | comment    |
      | Alice     | Marie      | Brown    | E1001 | OTH1001 | DL123456 |    2026-06-30 | Indian      | Married       | 1985-03-20 | Female | A+        | Test001   | ‪C:/Users/vunda/OneDrive/Desktop/photo1.jpeg    |Alice resume|
      | Bob       | Lee        | Wilson   | E1002 | OTH1002 | DL789012 |    2027-08-15 | Indian      | Single        | 1992-11-10 | Male   | O+        | Test002   | ‪C:/Users/vunda/OneDrive/Desktop/photo1.jpeg      |bobs resume|

  Scenario Outline: Update personal details from JSON test data
    When User navigates to My Info Personal Details page
    And User updates personal details from test data "<testDataId>"
    Then Personal details should be updated successfully

    Examples:
      | testDataId |
      | employee1  |
      | employee2  |
