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

public class AdminUsersPage {
	
	public WebDriver driver;
	
	public AdminUsersPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
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
		Select selectAdminUserType=new Select(selectAdminUserTypeDropdown);
		selectAdminUserType.selectByVisibleText(usertype);
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
	
	
}
