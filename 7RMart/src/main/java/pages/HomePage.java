package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@data-toggle='dropdown']")
	WebElement settingsandLogoutdropdown;
	@FindBy(xpath="//a[@class='dropdown-item'][2]")
	WebElement logoutOption;
	@FindBy(xpath="//i[@class='fas fa-arrow-circle-right'][1]")
	WebElement adminUserMoreInfo;
	@FindBy(xpath="//img[@alt='AdminLTE Logo']")
	WebElement homeLogo;
	
	
	
	public HomePage passwordAlert() {
		driver.switchTo().alert().accept();
		return this;
	}
	
	public LoginPage logoutAction(String dropdownValue) {
		settingsandLogoutdropdown.click();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10)); //explicit wait added to wait until logout option visible
		logoutOption.click();
		return new LoginPage(driver);
	}
	
	public AdminUsersPage clickAdminUserMoreInfo() {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		adminUserMoreInfo.click();
		return new AdminUsersPage(driver);
	}

}
