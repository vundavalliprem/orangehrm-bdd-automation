Feature: Dashboard Functionality

  Background:
    Given User visited the portal
    When User inputs valid "Admin" and "admin123"
    Then User can visit the dashboard

  Scenario: User can view dashboard after successful login
    Then User should see the dashboard page
    And User should see the profile dropdown

  Scenario: User can logout from dashboard
    When User clicks on profile dropdown
    And User clicks on logout link
    Then User should be redirected to login page

  Scenario: User can see all menu items on dashboard
    Then User should see multiple menu items
    And Menu count should be greater than 0

  Scenario Outline: User can navigate through dashboard menus
    When User clicks on "<menuName>" menu
    Then User should see "<menuName>" page

    Examples:
      | menuName |
      | Admin    |
      | PIM      |
      | Leave    |
