package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.WaitUtility;

public class HomePage {

	public WebDriver driver;
	WaitUtility waitUtility=new WaitUtility();
	

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement settingsandLogoutdropdown;
	@FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
	WebElement logoutOption;
	@FindBy(xpath = "(//i[@class='fas fa-arrow-circle-right'])[1]")
	WebElement adminUserMoreInfo;
	@FindBy(xpath = "//img[@alt='AdminLTE Logo']")
	WebElement homeLogo;
	@FindBy(xpath = "//i[@class='nav-icon fas fa-th-large']")
	WebElement dashboardLogo;
	@FindBy(xpath = "(//a[@class=\"small-box-footer\"])[9]")
	WebElement manageNewsMoreInfo;
	@FindBy(xpath = "(//a[@class=\"small-box-footer\"])[3]")
	WebElement categoryMoreInfo;

	public HomePage passwordAlert() {
		driver.switchTo().alert().accept();
		return this;
	}

	public LoginPage logoutAction(String dropdownValue) {
		settingsandLogoutdropdown.click();
		waitUtility.waitForElementToBeClickable(driver, logoutOption);  // explicit wait added to wait until logout option visible
		logoutOption.click();
		return new LoginPage(driver);
	}

	public AdminUsersPage clickAdminUserMoreInfo() {
		waitUtility.waitForElementToBeClickable(driver, adminUserMoreInfo);
		adminUserMoreInfo.click();
		return new AdminUsersPage(driver);
	}

	public ManageNewsPage clickManageNewsMoreInfo() {
		manageNewsMoreInfo.click();
		return new ManageNewsPage(driver);

	}

	public CategoryPage clickCategoryMoreInfo() {
		categoryMoreInfo.click();
		return new CategoryPage(driver);
	}
}
