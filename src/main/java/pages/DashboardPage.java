package pages;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage extends BaseClass {
    
    @FindBy(className = "oxd-userdropdown-name")
    public WebElement btnProfileTab;
    
    @FindBy(partialLinkText = "Logout")
    public WebElement linkLogout;

    @FindBy(className = "oxd-text--span")
    public List<WebElement> menus;

    @FindBy(className = "oxd-select-text-input")
    public List<WebElement> dropdown;
    
    @FindBy(tagName = "input")
    public List<WebElement> employeeName;
    
    public DashboardPage() {
        PageFactory.initElements(driver, this);
    }
    
    public void doLogout() {
        btnProfileTab.click();
        linkLogout.click();
    }
    
    public boolean isDashboardDisplayed() {
        return btnProfileTab.isDisplayed();
    }
    
    public int getMenuCount() {
        return menus.size();
    }
}