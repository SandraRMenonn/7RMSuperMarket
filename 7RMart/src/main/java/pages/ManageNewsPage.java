package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.FileUploadUtility;
import utility.PageUtility;
import utility.WaitUtility;

public class ManageNewsPage {

	public WebDriver driver;
	WaitUtility waitUtility=new WaitUtility();

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//textarea[@name='news']")
	WebElement enterNewsArea;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement clickSaveButtonforNews;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement manageNewsNewButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement saveandDeleteSuccessAlert;

	public ManageNewsPage enterNewsInfo(String message) {
		enterNewsArea.click();
		enterNewsArea.sendKeys(message);
		clickSaveButtonforNews.click();
		return this;
	}
	
	public ManageNewsPage newButtonClick() {
		waitUtility.waitForElementToBeClickable(driver, manageNewsNewButton);
		manageNewsNewButton.click();
		return this;
	}
	
	public boolean isSaveandDeleteSuccess() {
		PageUtility pageUtility = new PageUtility();
		return pageUtility.isSaveandDeleteSuccess(saveandDeleteSuccessAlert);
	}

}
