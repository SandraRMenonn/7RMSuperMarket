package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.FileUploadUtility;

public class ManageNewsPage {
	
	public WebDriver driver;
	public AdminUsersPage adminUsersPage;
	
	public ManageNewsPage(WebDriver driver) {
		driver=this.driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='active nav-link']//child::p[text()='Manage News']")
	WebElement manageNewslink;
	@FindBy(xpath="//textarea[@name='news']")
	WebElement enterNewsArea;
	@FindBy(xpath="//button[@type='submit']")
	WebElement clickSaveButtonforNews;
	@FindBy(xpath="//div[@class='os-scrollbar os-scrollbar-vertical os-scrollbar-auto-hidden']")
	WebElement HomePageleftMenuScrollBar;
	
	
	
	public ManageNewsPage clickManageNewsLink() {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(manageNewslink));
		//HomePageleftMenuScrollBar.
		manageNewslink.click();
		return this;
	}
	
	public ManageNewsPage enterNewsInfo() {
		adminUsersPage.adminUserNewButton.click();
		enterNewsArea.sendKeys("News for 7RM");
		clickSaveButtonforNews.click();
		boolean isNewsSaveSuccess=adminUsersPage.AdminUserInfoSaveandDeleteSuccessAlert.isDisplayed();
		System.out.println("isNewsSaveSuccess:" + isNewsSaveSuccess);
		return this;
	}
	

}
