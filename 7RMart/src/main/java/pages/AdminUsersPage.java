package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.PageUtility;
import utility.WaitUtility;

public class AdminUsersPage {

	public WebDriver driver;
	PageUtility pageUtility=new PageUtility();
	WaitUtility waitUtility=new WaitUtility();

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement adminUserNewButton;
	@FindBy(xpath = "//input[@id='username']")
	WebElement inputAdminUserName;
	@FindBy(xpath = "//input[@id='password']")
	WebElement inputAdminPassword;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement selectAdminUserTypeDropdown;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement saveAdminUserInfo;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement SaveandDeleteSuccessAlert;
	@FindBy(xpath = "//i[@class='fas fa-trash-alt'][1]")
	WebElement deleteAdminUserIcon;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement adminUserSearchButton;
	@FindBy(xpath = "//input[@id='un']")
	WebElement adminSearchUserName;
	@FindBy(xpath = "//select[@id='ut']")
	WebElement adminSearchUserTypeDropdown;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement adminUserSearchSubmitButton;
	@FindBy(xpath = "//div[@class='card-footer clearfix']")
	WebElement adminUserSearchresultPagination;

	public AdminUsersPage newButtonClick() {
		waitUtility.waitForElementToBeClickable(driver, adminUserNewButton);
		adminUserNewButton.click();
		return this;
	}

	public AdminUsersPage inputAdminUsernameandPassword(String username, String password) {
		inputAdminUserName.sendKeys(username);
		inputAdminPassword.sendKeys(password);
		return this;
	}

	public AdminUsersPage selectAdminUserType(String usertype) {
		pageUtility.selectByVisibleText(selectAdminUserTypeDropdown, usertype);
		return this;
	}

	public AdminUsersPage clickSaveAdminUserInfo() {
		saveAdminUserInfo.click();
		return this;
	}

	public AdminUsersPage deleteAdminUser() {
		deleteAdminUserIcon.click();
		driver.switchTo().alert().accept();
		return this;
	}

	public boolean searchAdminUser(String username, String userType) {
		waitUtility.waitForElementToBeClickable(driver, adminUserSearchButton);
		adminUserSearchButton.click();
		adminSearchUserName.sendKeys(username);
		pageUtility.selectByVisibleText(adminSearchUserTypeDropdown, userType);
		adminUserSearchSubmitButton.click();
		boolean isPaginationDisplayed = adminUserSearchresultPagination.isDisplayed();
		System.out.println("Search result pagination displayed: " + isPaginationDisplayed);
		return isPaginationDisplayed;

	}
	
	public boolean isSaveandDeleteSuccess() {
		return pageUtility.isSaveandDeleteSuccess(SaveandDeleteSuccessAlert);
	}
	
	
	

}
