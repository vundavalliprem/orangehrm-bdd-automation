package stepdefinitions;

import org.openqa.selenium.WebElement;

import base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.DashboardPage;
import pages.LoginPage;
import utils.WaitUtils;

public class DashboardStepDefinitions extends BaseClass {
    
    DashboardPage dashboardPage;

    @Then("User should see the dashboard page")
    public void userShouldSeeTheDashboardPage() {
        dashboardPage = new DashboardPage();
        Assert.assertTrue("Dashboard is not displayed", dashboardPage.isDashboardDisplayed());
    }

    @And("User should see the profile dropdown")
    public void userShouldSeeTheProfileDropdown() {
        Assert.assertTrue("Profile dropdown is not visible", dashboardPage.btnProfileTab.isDisplayed());
    }

    @When("User clicks on profile dropdown")
    public void userClicksOnProfileDropdown() {
        dashboardPage = new DashboardPage();
        WaitUtils.waitForElementClickable(dashboardPage.btnProfileTab, 10);
        dashboardPage.btnProfileTab.click();
    }

    @And("User clicks on logout link")
    public void userClicksOnLogoutLink() {
        WaitUtils.waitForElementClickable(dashboardPage.linkLogout, 10);
        dashboardPage.linkLogout.click();
    }

    @Then("User should be redirected to login page")
    public void userShouldBeRedirectedToLoginPage() {
        LoginPage loginPage = new LoginPage();
        WaitUtils.waitForElementVisible(loginPage.btnSubmit, 5);
        Assert.assertTrue("Not redirected to login page", driver.getCurrentUrl().contains("login"));
    }

    @Then("User should see multiple menu items")
    public void userShouldSeeMultipleMenuItems() {
        dashboardPage = new DashboardPage();
        Assert.assertFalse("No menu items found", dashboardPage.menus.isEmpty());
    }

    @And("Menu count should be greater than {int}")
    public void menuCountShouldBeGreaterThan(int expectedCount) {
        int actualCount = dashboardPage.getMenuCount();
        Assert.assertTrue("Menu count is not greater than " + expectedCount, 
                         actualCount > expectedCount);
    }

    @When("User clicks on {string} menu")
    public void userClicksOnMenu(String menuName) {
        dashboardPage = new DashboardPage();
        for (WebElement menu : dashboardPage.menus) {
            if (menu.getText().equalsIgnoreCase(menuName)) {
                WaitUtils.waitForElementClickable(menu, 10);
                menu.click();
                break;
            }
        }
    }

    @Then("User should see {string} page")
    public void userShouldSeePage(String pageName) {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Not on " + pageName + " page", 
                         currentUrl.toLowerCase().contains(pageName.toLowerCase()));
    }
}
