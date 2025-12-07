Feature: Add Employee Functionality

     Background:
    Given User visited the portal
    When User inputs valid "Admin" and "admin123"
    Then User can visit the dashboard
 

  Scenario: Add employee without login credentials
    When User navigates to Add Employee page
    And User enters employee details "Sarah", "Ann", "Connor", "E2001"
    And User clicks save button
    Then Employee should be added successfully
    
    
    
    
  # Toggle scenario - With login credentials (Toggle ON)

  Scenario: Add employee with login credentials using toggle
    When User navigates to Add Employee page
    And User enters employee details "Johnn", "Michaelll", "Wickk", "E2002"
    And User enables create login details
    And User enters login credentials "jojhytrr" and "Password@123"
    And User clicks save button
    Then Employee should be added successfully
    And Employee login should be created
  # Using Examples - Simple data

  Scenario Outline: Add employee with basic details using Examples
    When User navigates to Add Employee page
    And User enters employee details "<firstName>", "<middleName>", "<lastName>", "<empId>"
    And User clicks save button
    Then Employee should be added successfully

    Examples:
      | firstName | middleName | lastName | empId |
      | Alicee     | Mariee      | Brownn    | E10011 |
      | Bobb       | Leee        | Wilsonn   | E10022 |
  # Using JSON Test Data - Complex data with toggle

  Scenario Outline: Add employee from JSON test data
    When User navigates to Add Employee page
    And User adds employee from test data "<testDataId>"
    Then Employee should be added successfully

    Examples:
      | testDataId |
      | employee1  |
      | employee2  |
      | employee3  |
