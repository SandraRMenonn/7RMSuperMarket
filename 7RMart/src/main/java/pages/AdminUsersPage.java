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

public class AdminUsersPage {
	
	public WebDriver driver;
	PageUtility pageUtility=new PageUtility();
	
	public AdminUsersPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	@FindBy(xpath="//a[@onclick='click_button(1)']")
	WebElement adminUserNewButton;
	@FindBy(xpath="//input[@id='username']")
	WebElement inputAdminUserName;
	@FindBy(xpath="//input[@id='password']")
	WebElement inputAdminPassword;
	@FindBy(xpath="//select[@id='user_type']")
	WebElement selectAdminUserTypeDropdown;
	@FindBy(xpath="//button[@name='Create']")
	WebElement saveAdminUserInfo;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement AdminUserInfoSaveandDeleteSuccessAlert;
	@FindBy(xpath="//i[@class='fas fa-trash-alt'][1]")
	WebElement deleteAdminUserIcon;
	@FindBy(xpath="//a[@onclick='click_button(2)']")
	WebElement adminUserSearchButton;
	@FindBy(xpath="//input[@id='un']")
	WebElement adminSearchUserName;
	@FindBy(xpath="//select[@id='ut']")
	WebElement adminSearchUserTypeDropdown;
	@FindBy(xpath="//button[@name='Search']")
	WebElement adminUserSearchSubmitButton;
	@FindBy(xpath="//div[@class='card-footer clearfix']")
	WebElement adminUserSearchresultPagination;
	
	
	public AdminUsersPage newButtonClick() {
		
		adminUserNewButton.click(); 
		return this;
	}
	
	public AdminUsersPage inputAdminUsernameandPassword(String username, String password) {
		inputAdminUserName.sendKeys(username);
		inputAdminPassword.sendKeys(password);
		return this;
	}

	public AdminUsersPage selectAdminUserType(String usertype) {
		
		//Select selectAdminUserType=new Select(selectAdminUserTypeDropdown);
		//selectAdminUserType.selectByVisibleText(usertype);
		
		pageUtility.selectByVisibleText(selectAdminUserTypeDropdown, usertype);
		return this;
	}
	
	public AdminUsersPage clickSaveAdminUserInfo() {
		saveAdminUserInfo.click();
		return this;
	}
	
	public boolean isAdminUserInfoSaveandDeleteSuccess() {
		return AdminUserInfoSaveandDeleteSuccessAlert.isDisplayed(); 
	}
	
	public AdminUsersPage deleteAdminUser() {
		deleteAdminUserIcon.click();
		driver.switchTo().alert().accept();
		return this;
	}
	
	public AdminUsersPage searchAdminUser() {
		adminUserSearchButton.click();
		return this;
	}
	
	public AdminUsersPage inputAdminSearchUserName_UserType(String username, String userType){
		adminSearchUserName.sendKeys(username);
		pageUtility.selectByVisibleText(adminSearchUserTypeDropdown, userType);
		adminUserSearchSubmitButton.click();
		boolean isPaginationDisplayed = adminUserSearchresultPagination.isDisplayed();
		System.out.println("Search result pagination displayed: " + isPaginationDisplayed);
		return this;
		
	}
	
}
